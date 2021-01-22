package com.dupake.admin.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.dupake.admin.domain.CmsHelp;
import com.dupake.admin.domain.CmsHelpDTO;
import com.dupake.admin.mapper.DemoMapper;
import com.dupake.admin.service.DemoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
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
    public List<CmsHelp> getCmsList() {
        LambdaQueryWrapper<CmsHelp> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        return demoMapper.selectList(lambdaQueryWrapper);
    }

    @Override
    public List<CmsHelp> getCmsListByPage(Integer pageNum, Integer pageSize) {
        List<CmsHelp> CmsHelpList = demoMapper.getCmsListByPage(pageNum,pageSize);
        return CmsHelpList;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer addCms(CmsHelpDTO dto) {
        CmsHelp cmsHelp = CmsHelp.builder().build();
        BeanUtil.copyProperties(dto,cmsHelp);
        cmsHelp.setCreateTime(new Date());
        return demoMapper.insert(cmsHelp);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer updateCms(CmsHelpDTO dto) {
        CmsHelp cmsHelp = CmsHelp.builder().build();
        BeanUtil.copyProperties(dto,cmsHelp);
        return demoMapper.updateById(cmsHelp);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer deleteCms(Set<Long> ids) {
        ids.forEach(a->{
            demoMapper.deleteById(a);
        });
        return ids.size();
    }
}
