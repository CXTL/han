package com.dupake.common.domain.dto.req.user;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @ClassName UserUpdateRequest
 * @Description 修改 用户 请求实体
 * @Author dupake
 * @Date 2020/6/9 9:59
 */
@Data
public class UserUpdateRequest {

    /**
     * id 修改时使用
     */
    private Long id;

    /**
     * 账号
     */
    @NotEmpty(message = "帐号不能为空")
    private String username;
    /**
     * 昵称
     */
    @NotEmpty(message = "昵称不能为空")
    private String nickName;

    /**
     * 密码
     */
//    @NotNull(message = "密码不能为空")
//    @Pattern(regexp = "^[0-9]+$", message = "密码必须是6位数字")
    private String password;

    /**
     * 状态 0:未激活1:已激活2:已锁定3:已注销4::账号异常
     */
    @NotNull(message = "状态不能为空")
    private Integer status;


    /**
     * 手机号
     */
    @NotNull(message = "手机号不能为Null")
    @Pattern(regexp = "^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$", message = "手机号格式有误")
    private String phone;

    /**
     * 邮箱
     */
    @NotNull(message = "邮箱不能为Null")
    @Email(regexp = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])",
            message = "邮箱格式有误")
    private String email;

    /**
     * 备注
     */
    private String remark;
}
