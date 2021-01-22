package com.dupake.finance.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dupake.common.domain.dto.req.account.AccountQueryRequest;
import com.dupake.finance.domain.FinAccount;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 财务-帐套信息表 Mapper 接口
 * </p>
 *
 * @author dupake
 * @since 2020-07-26
 */
@Mapper
public interface FinAccountMapper extends BaseMapper<FinAccount> {

    int getTotalCount(AccountQueryRequest accountQueryRequest);

    List<FinAccount> selectListPage(AccountQueryRequest accountQueryRequest);

    void updateBatch(List<FinAccount> finAccountList);
}
