package com.dupake.common.domain.dto.res.finance;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName PermissionDTO
 * @Description 权限DTO
 * @Author dupake
 * @Date 2020/6/9 15:31
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SubjectDTO implements Serializable {

    private static final long serialVersionUID = -6225606748663424690L;
    private Long id;

    /**
     * 科目编号
     */
    private String subjectCode;

    /**
     * 科目名称
     */
    private String subjectName;

    /**
     * 父科目编号
     */
    private String parentCode;

    /**
     * 父科目名称
     */
    private String parentName;

    /**
     * 科目类型 1 资产 2负载 3权益 4成本 5其他
     */
    private Integer subjectType;

    /**
     * 借贷方向 0:借 1:贷
     */
    private Integer borrowFlag;


    /**
     * 备注
     */
    private String remark;
    /**
     * 创建时间
     */
    private Long createTime;


    /**
     * 子科目
     */
    private List<SubjectDTO> children;

}
