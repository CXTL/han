package com.dupake.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.dupake.admin.domain.UmsResource;
import com.dupake.admin.domain.UmsRole;
import com.dupake.admin.domain.UmsRoleResourceRelation;
import com.dupake.admin.mapper.ResourceMapper;
import com.dupake.admin.mapper.RoleMapper;
import com.dupake.admin.mapper.RoleResourceRelationMapper;
import com.dupake.admin.service.UmsResourceService;
import com.dupake.common.constant.AuthConstant;
import com.dupake.common.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * @description TODO
 * @date 2020-12-30
 */
@Service
public class UmsResourceServiceImpl implements UmsResourceService {

    @Autowired
    private RedisService redisService;

    @Autowired
    private ResourceMapper resourceMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private RoleResourceRelationMapper roleResourceRelationMapper;

    @Value("${spring.application.name}")
    private String applicationName;

    @Override
    public Map<String, List<String>> initResourceRolesMap() {
        Map<String,List<String>> resourceRoleMap = new TreeMap<>();
        List<UmsResource> resourceList = resourceMapper.selectList(new LambdaQueryWrapper<>());
        List<UmsRole> roleList = roleMapper.selectList(new LambdaQueryWrapper<>());
        List<UmsRoleResourceRelation> relationList = roleResourceRelationMapper.selectList(new LambdaQueryWrapper<>());
        for (UmsResource resource : resourceList) {
            Set<Long> roleIds = relationList.stream().filter(item -> item.getResourceId().equals(resource.getId())).map(UmsRoleResourceRelation::getRoleId).collect(Collectors.toSet());
            List<String> roleNames = roleList.stream().filter(item -> roleIds.contains(item.getId())).map(item -> item.getId() + "_" + item.getName()).collect(Collectors.toList());
            resourceRoleMap.put("/"+applicationName+resource.getUrl(),roleNames);
        }
        redisService.del(AuthConstant.RESOURCE_ROLES_MAP_KEY);
        redisService.hSetAll(AuthConstant.RESOURCE_ROLES_MAP_KEY, resourceRoleMap);
        return resourceRoleMap;
    }
}
