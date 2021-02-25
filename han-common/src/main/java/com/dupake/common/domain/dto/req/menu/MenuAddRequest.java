package com.dupake.common.domain.dto.req.menu;

import lombok.Data;

/**
 * @ClassName AccountAddRequest
 * @Description 新增菜单 请求实体
 * @Author dupake
 * @Date 2020/6/9 9:59
 */
@Data
public class MenuAddRequest {


    /**
     * 名称
     */
    private String name;

    /**
     * 父ID
     */
    private Long pid;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 路径
     */
    private String path;
    /**
     * 图标
     */
    private String icon;
    /**
     * 是否隐藏 0:未隐藏1:已隐藏
     */
    private Integer hidden;

    /**
     * 权限
     */
    private String permission;

    /**
     * 类型 0:菜单权限 1:资源权限
     */
    private Integer type;

    /**
     * 备注
     */
    private String remark;
}