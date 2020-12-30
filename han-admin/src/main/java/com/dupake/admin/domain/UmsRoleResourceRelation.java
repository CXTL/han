package com.dupake.admin.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @description TODO
 * @date 2020-12-30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UmsRoleResourceRelation implements Serializable {
    private static final long serialVersionUID = -3431904287095052286L;
    private Long id;

    @ApiModelProperty(value = "角色ID")
    private Long roleId;

    @ApiModelProperty(value = "资源ID")
    private Long resourceId;
}
