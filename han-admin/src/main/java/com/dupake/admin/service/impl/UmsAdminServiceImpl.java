package com.dupake.admin.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.dupake.admin.domain.UmsAdmin;
import com.dupake.admin.domain.UmsAdminLoginLog;
import com.dupake.admin.domain.UmsAdminLoginParam;
import com.dupake.admin.domain.UmsRole;
import com.dupake.admin.mapper.AdminMapper;
import com.dupake.admin.mapper.LoginLogMapper;
import com.dupake.admin.mapper.RoleMapper;
import com.dupake.admin.service.UmsAdminCacheService;
import com.dupake.admin.service.UmsAdminService;
import com.dupake.admin.service.AuthService;
import com.dupake.common.api.CommonResult;
import com.dupake.common.api.ResultCode;
import com.dupake.common.constant.AuthConstant;
import com.dupake.common.domain.UserDto;
import com.dupake.common.exception.Asserts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @description TODO
 * @date 2020-12-24
 */
@Service
public class UmsAdminServiceImpl implements UmsAdminService {

    @Resource
    private AuthService authService;

    @Resource
    private AdminMapper adminMapper;

    @Resource
    private RoleMapper roleMapper;

    @Resource
    private LoginLogMapper loginLogMapper;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private UmsAdminCacheService adminCacheService;

    @Override
    public UserDto loadUserByUsername(String username) {
        UmsAdmin admin = adminMapper.selectOne(new LambdaQueryWrapper<UmsAdmin>().eq(UmsAdmin::getUsername, username));
        if(Objects.isNull(admin)){
            Asserts.fail("用户不存在");
        }
        UserDto dto = new UserDto();
        BeanUtil.copyProperties(admin,dto);

        List<UmsRole> roleList = roleMapper.getRoleList(admin.getId());
        if(CollUtil.isNotEmpty(roleList)){
            List<String> roleStrList = roleList.stream().map(item -> item.getId() + "_" + item.getName()).collect(Collectors.toList());
            dto.setRoles(roleStrList);
        }
        return dto;
    }

    /**
     * 登陆功能
     * @param param
     * @return
     */
    @Override
    public CommonResult login(UmsAdminLoginParam param) {
        Map<String, String> params = new HashMap<>();
        params.put("client_id", AuthConstant.ADMIN_CLIENT_ID);
        params.put("client_secret","123456");
        params.put("grant_type","password");
        params.put("username",param.getUsername());
        params.put("password",param.getPassword());
        CommonResult restResult = authService.getAccessToken(params);
        if(ResultCode.SUCCESS.getCode()==restResult.getCode() && restResult.getData()!=null){
            insertLoginLog(param.getUsername());
        }
        return restResult;
    }

    /**
     * 添加登录记录
     * @param username 用户名
     */
    private void insertLoginLog(String username) {
        UmsAdmin admin = adminMapper.selectOne(new LambdaQueryWrapper<UmsAdmin>().eq(UmsAdmin::getUsername, username));
        if(Objects.isNull(admin)){
            Asserts.fail("用户不存在");
        }
        UmsAdminLoginLog loginLog = new UmsAdminLoginLog();
        loginLog.setAdminId(admin.getId());
        loginLog.setCreateTime(new Date());
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        loginLog.setIp(request.getRemoteAddr());
        loginLogMapper.insert(loginLog);
    }


    @Override
    public UmsAdmin getCurrentAdmin() {
        String userStr = request.getHeader(AuthConstant.USER_TOKEN_HEADER);
        if(StrUtil.isEmpty(userStr)){
            Asserts.fail(ResultCode.UNAUTHORIZED);
        }
        UserDto userDto = JSONUtil.toBean(userStr, UserDto.class);
        UmsAdmin admin = adminCacheService.getAdmin(userDto.getId());
        if(admin!=null){
            return admin;
        }else{
            admin = adminMapper.selectById(userDto.getId());
            adminCacheService.setAdmin(admin);
            return admin;
        }
    }
}
