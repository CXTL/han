package com.dupake.admin.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.dupake.admin.domain.UmsAdmin;
import com.dupake.admin.domain.UmsRole;
import com.dupake.admin.mapper.AdminMapper;
import com.dupake.admin.mapper.RoleMapper;
import com.dupake.admin.service.AdminService;
import com.dupake.common.domain.UserDto;
import com.dupake.common.exception.Asserts;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @description TODO
 * @date 2020-12-24
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Resource
    private AdminMapper adminMapper;

    @Resource
    private RoleMapper roleMapper;

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
}
