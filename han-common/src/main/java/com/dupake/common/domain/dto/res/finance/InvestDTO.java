package com.dupake.common.domain.dto.res.finance;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

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
public class InvestDTO implements Serializable {

    private static final long serialVersionUID = -6225606748663424690L;
    private Long id;

    /**
     * 帐套信息编码
     */
    private String accountCode;
    /**
     * 科目编码
     */
    private String subjectCode;
    /**
     * 科目编码
     */
    private String subjectName;
    /**
     * 帐套名称
     */
    private String accountName;

    /**
     * 投资人名称
     */
    private String investorName;

    /**
     * 实际投资金额
     */
    private BigDecimal actualInvestAmount;

    /**
     * 投资总额
     */
    private BigDecimal totalInvestAmount;
    /**
     * 投资比例 %
     */
    private Double investRatio;


    /**
     * 备注
     */
    private String remark;

    /**
     * 创建时间
     */
    private Long createTime;

    /**
     * 应投资总额
     */
    private BigDecimal shouldInvestAmount;

    /**
     * 投资日期
     */
    private Long investDate;

}
