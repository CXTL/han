package com.dupake.finance.service;

import com.dupake.common.api.CommonPage;
import com.dupake.common.api.CommonResult;
import com.dupake.common.domain.dto.req.investor.InvestorAddRequest;
import com.dupake.common.domain.dto.req.investor.InvestorQueryRequest;
import com.dupake.common.domain.dto.req.investor.InvestorUpdateRequest;
import com.dupake.common.domain.dto.res.finance.InvestorDTO;

import java.util.List;

/**
 * <p>
 * 财务-帐套信息表 服务类
 * </p>
 *
 * @author dupake
 * @since 2020-07-26
 */
public interface FinInvestorService {

    CommonResult<CommonPage<InvestorDTO>> listByPage(InvestorQueryRequest accountQueryRequest);

    CommonResult addInvestor(InvestorAddRequest accountAddRequest);

    CommonResult updateInvestor(InvestorUpdateRequest accountUpdateRequest);

    CommonResult deleteInvestor(List<Long> ids);

    CommonResult<List<InvestorDTO>> listInvestor();
}
