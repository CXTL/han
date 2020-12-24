package com.dupake.demo.controller;


import com.dupake.common.api.CommonPage;
import com.dupake.common.api.CommonResult;
import com.dupake.demo.domain.UmsAdmin;
import com.dupake.demo.domain.UmsAdminDTO;
import com.dupake.demo.service.DemoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

/**
 * @description TODO
 * @date 2020-12-23
 */
@Api(tags = "DemoController")
@RestController
@RequestMapping(value = "demo")
public class DemoController {

    @Resource
    private DemoService demoService;

    @ApiOperation(value = "获取用户列表")
    @GetMapping(value = "getAdminList")
    public CommonResult<List<UmsAdmin>> getAdminList() {
        return CommonResult.success(demoService.getAdminList());
    }


    @ApiOperation(value = "分页获取用户列表")
    @GetMapping(value = "getAdminListByPage")
    public CommonResult<CommonPage<UmsAdmin>> getAdminListByPage(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                        @RequestParam(value = "pageSize", defaultValue = "3") Integer pageSize) {
        List<UmsAdmin> brandList = demoService.getAdminListByPage(pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(brandList));
    }


    @ApiOperation(value = "新增用户数据")
    @PostMapping(value = "addAdmin")
    public CommonResult<Integer> addAdmin(@RequestBody UmsAdminDTO dto) {
        return CommonResult.success(demoService.addAdmin(dto));
    }


    @ApiOperation(value = "修改用户数据")
    @PostMapping(value = "updateAdmin")
    public CommonResult<Integer> updateAdmin(@RequestBody UmsAdminDTO dto) {
        return CommonResult.success(demoService.updateAdmin(dto));
    }


    @ApiOperation(value = "删除用户数据")
    @PostMapping(value = "deleteAdmin")
    public CommonResult<Integer> deleteAdmin(@RequestBody Set<Long> ids) {
        return CommonResult.success(demoService.deleteAdmin(ids));
    }

}
