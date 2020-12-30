package com.dupake.admin.service;

import java.util.List;
import java.util.Map;

/**
 * @description 后台资源管理service
 * @date 2020-12-30
 */
public interface UmsResourceService {
    /**
     * 初始化资源角色规则
     */
    Map<String, List<String>> initResourceRolesMap();
}
