package com.dupake.finance.service;

import com.dupake.common.api.CommonPage;
import com.dupake.common.api.CommonResult;
import com.dupake.common.domain.dto.req.invest.InvestAddRequest;
import com.dupake.common.domain.dto.req.invest.InvestQueryRequest;
import com.dupake.common.domain.dto.req.invest.InvestUpdateRequest;
import com.dupake.common.domain.dto.res.finance.InvestDTO;

import java.util.List;

/**
 * <p>
 * 财务-投资信息表 服务类
 * </p>
 *
 * @author dupake
 * @since 2020-07-26
 */
public interface FinInvestFlowService {

    CommonResult<CommonPage<InvestDTO>> listByPage(InvestQueryRequest accountQueryRequest);

    CommonResult addInvest(InvestAddRequest accountAddRequest);

    CommonResult updateInvest(InvestUpdateRequest accountUpdateRequest);

    CommonResult deleteInvest(List<Long> ids);
}
