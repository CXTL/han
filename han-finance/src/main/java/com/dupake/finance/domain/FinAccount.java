package com.dupake.finance.domain;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.dupake.common.domain.entity.BaseEntity;
import lombok.*;

/**
 * <p>
 * 财务-帐套信息表
 * </p>
 *
 * @author dupake
 * @since 2020-07-26
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class FinAccount  extends BaseEntity  {


    private static final long serialVersionUID = -4027869981500881705L;
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 帐套信息编码
     */
    private String accountCode;

    /**
     * 帐套名称
     */
    private String accountName;

    /**
     * 公司名称
     */
    private String companyName;

    /**
     * 纳税识别号
     */
    private String taxNumber;

    /**
     * 地址
     */
    private String address;

    /**
     * 电话
     */
    private String phone;

    /**
     * 开户银行
     */
    private String bankAccount;

    /**
     * 银行卡号
     */
    private String bankCardNumber;



    /**
     * 是否删除 0:未删除1:已删除
     */
    @TableField(value = "is_deleted",fill = FieldFill.INSERT)
    private Integer isDeleted;

    /**
     * 备注
     */
    private String remark;

}
