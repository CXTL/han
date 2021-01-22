package com.dupake.demo.controller;

import com.dupake.common.api.CommonResult;
import com.dupake.demo.service.FeignAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description TODO
 * @date 2020-12-24
 */
@Api(tags = "FeignAdminController")
@RestController
@RequestMapping(value = "feign/admin")
public class FeignAdminController {

    @Autowired
    private FeignAdminService adminService;

    @ApiOperation(value = "获取cms列表")
    @GetMapping(value = "getCmsList")
    public CommonResult getCmsList() {
        return CommonResult.success(adminService.getCmsList());
    }

}
