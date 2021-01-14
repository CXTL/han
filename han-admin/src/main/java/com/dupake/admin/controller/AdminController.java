package com.dupake.admin.controller;


import com.dupake.admin.domain.UmsAdmin;
import com.dupake.admin.domain.UmsAdminLoginParam;
import com.dupake.admin.service.UmsAdminService;
import com.dupake.common.api.CommonResult;
import com.dupake.common.domain.UserDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @description TODO
 * @date 2020-12-23
 */
@Api(tags = "AdminController")
@RestController
@RequestMapping(value = "admin")
public class AdminController {


    @Value("${server.port}")
    private String port;
    @Resource
    private UmsAdminService adminService;

    @ApiOperation(value = "TestNacos data")
    @GetMapping(value = "/test")
    public CommonResult test() {
        return CommonResult.success(port);
    }

    @ApiOperation(value = "用户注册")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult register() {
        return CommonResult.success(null);
    }

    @ApiOperation(value = "登录以后返回token")
    @PostMapping(value = "/login")
    public CommonResult login(@RequestBody UmsAdminLoginParam param) {
        return adminService.login(param);
    }

    @ApiOperation(value = "获取当前登录用户信息")
    @GetMapping(value = "/info")
    public CommonResult getAdminInfo() {
        UmsAdmin umsAdmin = adminService.getCurrentAdmin();
        return CommonResult.success(umsAdmin);
    }

    @ApiOperation(value = "登出功能")
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult logout() {
        return CommonResult.success(null);
    }


    @ApiOperation("根据用户名获取通用用户信息")
    @GetMapping(value = "/loadByUsername")
    public UserDto loadUserByUsername(@RequestParam String username) {
        UserDto userDTO = adminService.loadUserByUsername(username);
        return userDTO;
    }

}
