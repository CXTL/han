package com.dupake.common.domain.dto.req.invest;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @ClassName AccountAddRequest
 * @Description 新增菜单 请求实体
 * @Author dupake
 * @Date 2020/6/9 9:59
 */
@Data
public class InvestAddRequest {



    /**
     * 帐套编码
     */
    private String accountCode;


    /**
     * 科目编码
     */
    private String subjectCode;

    /**
     * 投资人ID
     */
    private Long investorId;

    /**
     * 实际投资金额
     */
    private BigDecimal actualInvestAmount;

    /**
     * 投资总额
     */
    private BigDecimal totalInvestAmount;


    /**
     * 应投资总额
     */
    private BigDecimal shouldInvestAmount;

    /**
     * 投资日期
     */
    private Long investDate;

    /**
     * 备注
     */
    private String remark;
}
