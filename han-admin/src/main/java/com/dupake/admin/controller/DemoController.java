package com.dupake.admin.controller;


import com.dupake.admin.domain.CmsHelp;
import com.dupake.admin.domain.CmsHelpDTO;
import com.dupake.admin.service.DemoService;
import com.dupake.common.api.CommonPage;
import com.dupake.common.api.CommonResult;
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
@Api(tags = "CmsController")
@RestController
@RequestMapping(value = "cms")
public class DemoController {

    @Resource
    private DemoService demoService;

    @ApiOperation(value = "获取帮助列表")
    @GetMapping(value = "getCmsList")
    public CommonResult getCmsList() {
        return CommonResult.success(demoService.getCmsList());
    }


    @ApiOperation(value = "分页获取帮助列表")
    @GetMapping(value = "getCmsListByPage")
    public CommonResult<CommonPage<CmsHelp>> getCmsListByPage(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                        @RequestParam(value = "pageSize", defaultValue = "3") Integer pageSize) {
        List<CmsHelp> brandList = demoService.getCmsListByPage(pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(brandList));
    }


    @ApiOperation(value = "新增帮助数据")
    @PostMapping(value = "addCms")
    public CommonResult<Integer> addCms(@RequestBody CmsHelpDTO dto) {
        return CommonResult.success(demoService.addCms(dto));
    }


    @ApiOperation(value = "修改帮助数据")
    @PostMapping(value = "updateCms")
    public CommonResult<Integer> updateCms(@RequestBody CmsHelpDTO dto) {
        return CommonResult.success(demoService.updateCms(dto));
    }


    @ApiOperation(value = "删除帮助数据")
    @PostMapping(value = "deleteCms")
    public CommonResult<Integer> deleteCms(@RequestBody Set<Long> ids) {
        return CommonResult.success(demoService.deleteCms(ids));
    }

}
