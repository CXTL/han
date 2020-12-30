package com.dupake.admin.service;

import com.dupake.admin.domain.UmsAdmin;
import com.dupake.admin.domain.UmsAdminLoginParam;
import com.dupake.common.api.CommonResult;
import com.dupake.common.domain.UserDto;

/**
 * @description TODO
 * @date 2020-12-24
 */
public interface UmsAdminService {
    /**
     * 获取用户信息
     */
    UserDto loadUserByUsername(String username);

    /**
     * 登陆功能
     * @param param
     * @return
     */
    CommonResult login(UmsAdminLoginParam param);


    /**
     *
     * @return
     */
    UmsAdmin getCurrentAdmin();
}
