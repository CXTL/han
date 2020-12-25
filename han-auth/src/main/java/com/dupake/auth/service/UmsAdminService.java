package com.dupake.auth.service;

import com.dupake.common.domain.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by macro on 2019/10/18.
 */
@FeignClient("han-admin")
public interface UmsAdminService {

    @GetMapping(value = "/admin/loadByUsername")
    public UserDto loadUserByUsername(@RequestParam String username);
}
