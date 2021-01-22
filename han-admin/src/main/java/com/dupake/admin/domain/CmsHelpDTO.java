package com.dupake.admin.domain;

import lombok.Data;

import java.util.Date;

/**
 * @description TODO
 * @date 2020-12-24
 */
@Data
public class CmsHelpDTO {

    private Long id;

    private Long categoryId;

    private String icon;

    private String title;

    private Integer showStatus;

    private Integer readCount;

    private String content;
}
