package com.dupake.demo.service;

import com.dupake.common.api.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by macro on 2019/10/18.
 */
@FeignClient("han-admin")
public interface FeignAdminService {

    @GetMapping(value = "cms/getCmsList")
    public CommonResult getCmsList();
}
