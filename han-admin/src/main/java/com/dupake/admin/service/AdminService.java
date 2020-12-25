package com.dupake.admin.service;

import com.dupake.common.domain.UserDto;

/**
 * @description TODO
 * @date 2020-12-24
 */
public interface AdminService {
    /**
     * 获取用户信息
     */
    UserDto loadUserByUsername(String username);
}
