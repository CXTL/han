package com.dupake.demo.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class UmsAdminDTO implements Serializable {
    private Long id;

    private String username;

    private String password;

    private String icon;

    private String email;

    private String nickName;

    private String note;

    private Integer status;

}