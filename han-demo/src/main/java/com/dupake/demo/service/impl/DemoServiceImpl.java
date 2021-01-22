package com.dupake.demo.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.dupake.demo.domain.UmsAdmin;
import com.dupake.demo.domain.UmsAdminDTO;
import com.dupake.demo.mapper.DemoMapper;
import com.dupake.demo.service.DemoService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

/**
 * @description TODO
 * @date 2020-12-23
 */
@Service
public class DemoServiceImpl implements DemoService {

    @Resource
    private DemoMapper demoMapper;

    @Override
    public List<UmsAdmin> getAdminList() {
        LambdaQueryWrapper<UmsAdmin> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        return demoMapper.selectList(lambdaQueryWrapper);
    }

    @Override
    public List<UmsAdmin> getAdminListByPage(Integer pageNum, Integer pageSize) {
        List<UmsAdmin> umsAdminList = demoMapper.getAdminListByPage(pageNum,pageSize);
        return umsAdminList;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer addAdmin(UmsAdminDTO dto) {
        UmsAdmin umsAdmin = UmsAdmin.builder().build();
        BeanUtil.copyProperties(dto,umsAdmin);
        return demoMapper.insert(umsAdmin);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer updateAdmin(UmsAdminDTO dto) {
        UmsAdmin umsAdmin = UmsAdmin.builder().build();
        BeanUtil.copyProperties(dto,umsAdmin);
        return demoMapper.updateById(umsAdmin);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer deleteAdmin(Set<Long> ids) {
        ids.forEach(a->{
            demoMapper.deleteById(a);
        });
        return ids.size();
    }
}
