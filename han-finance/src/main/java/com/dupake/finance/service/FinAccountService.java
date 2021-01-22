package com.dupake.finance.service;

import com.dupake.common.api.CommonPage;
import com.dupake.common.api.CommonResult;
import com.dupake.common.domain.dto.req.account.AccountAddRequest;
import com.dupake.common.domain.dto.req.account.AccountQueryRequest;
import com.dupake.common.domain.dto.req.account.AccountUpdateRequest;
import com.dupake.common.domain.dto.res.finance.AccountDTO;

import java.util.List;

/**
 * <p>
 * 财务-帐套信息表 服务类
 * </p>
 *
 * @author dupake
 * @since 2020-07-26
 */
public interface FinAccountService  {

    CommonResult<CommonPage<AccountDTO>> listByPage(AccountQueryRequest accountQueryRequest);

    CommonResult addAccount(AccountAddRequest accountAddRequest);

    CommonResult updateAccount(AccountUpdateRequest accountUpdateRequest);

    CommonResult deleteAccount(List<Long> ids);

    CommonResult<List<AccountDTO>> listAll();
}
