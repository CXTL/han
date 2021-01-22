package com.dupake.finance.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.dupake.common.api.BaseResult;
import com.dupake.common.api.CommonPage;
import com.dupake.common.api.CommonResult;
import com.dupake.common.constant.RedisKeyConstant;
import com.dupake.common.domain.dto.req.account.AccountAddRequest;
import com.dupake.common.domain.dto.req.account.AccountQueryRequest;
import com.dupake.common.domain.dto.req.account.AccountUpdateRequest;
import com.dupake.common.domain.dto.res.finance.AccountDTO;
import com.dupake.common.enums.YesNoSwitchEnum;
import com.dupake.common.exception.Asserts;
import com.dupake.common.service.RedisService;
import com.dupake.common.utils.DateUtil;
import com.dupake.finance.domain.FinAccount;
import com.dupake.finance.mapper.FinAccountMapper;
import com.dupake.finance.service.BaseService;
import com.dupake.finance.service.FinAccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * <p>
 * 财务-帐套信息表 服务实现类
 * </p>
 *
 * @author dupake
 * @since 2020-07-26
 */
@Service
@Slf4j
public class FinAccountServiceImpl extends BaseService implements FinAccountService {


    @Resource
    private FinAccountMapper finAccountMapper;

    @Resource
    private RedisService redisUtil;


    private final String redisKey = new StringBuffer(RedisKeyConstant.BABY_FINANCE_ACCOUNT_KEY).toString();

    /**
     * @param accountQueryRequest :
     * @return com.dupake.common.message.CommonResult<com.dupake.common.message.CommonPage < com.dupake.common.pojo.dto.res.finance.AccountDTO>>
     * @Description 分页查询帐套列表
     **/
    @Override
    public CommonResult<CommonPage<AccountDTO>> listByPage(AccountQueryRequest accountQueryRequest) {
        List<AccountDTO> accountDTOS = new ArrayList<>();

        int totalCount = finAccountMapper.getTotalCount(accountQueryRequest);
        if (totalCount > 0) {
            List<FinAccount> finAccounts = finAccountMapper.selectListPage(accountQueryRequest);
            if (!ObjectUtils.isEmpty(finAccounts)) {
                accountDTOS = finAccounts.stream().map(a -> {
                    AccountDTO accountDTO = new AccountDTO();
                    BeanUtils.copyProperties(a, accountDTO);
                    return accountDTO;
                }).collect(Collectors.toList());
            }
        }
        return CommonResult.success(CommonPage.restPage(accountDTOS, totalCount));
    }


    /**
     * @param accountAddRequest :
     * @return com.dupake.common.message.CommonResult
     * @Description 新增帐套
     **/
    @Override
    @Transactional(rollbackFor = Exception.class)
    public CommonResult addAccount(AccountAddRequest accountAddRequest) {

        //帐套名称校验 权限标识校验
//        checkAccountInfo(accountAddRequest.getName(), accountAddRequest.getPermission(),null);

        //落地帐套数据
        try {

            finAccountMapper.insert(FinAccount.builder()
                    .accountCode(accountAddRequest.getAccountCode())
                    .accountName(accountAddRequest.getAccountName())
                    .address(accountAddRequest.getAddress())
                    .bankAccount(accountAddRequest.getBankAccount())
                    .bankCardNumber(accountAddRequest.getBankCardNumber())
                    .companyName(accountAddRequest.getCompanyName())
                    .phone(accountAddRequest.getPhone())
                    .taxNumber(accountAddRequest.getTaxNumber())
                    .remark(accountAddRequest.getRemark())
                    .build());

        } catch (Exception e) {
            log.error("FinAccountServiceImpl add account error , param:{}, error:{}", JSONObject.toJSONString(accountAddRequest), e);
            Asserts.fail(BaseResult.FAILED);
        }

        try {
            //redis设置帐套信息
            Map<String, String> accountMap = getAccountMap();
            accountMap.put(accountAddRequest.getAccountCode(),accountAddRequest.getAccountName());
            redisUtil.hSet(redisKey,redisKey, JSONObject.toJSONString(accountMap));
        }catch (Exception e){
            redisUtil.hDel(redisKey,redisKey);
            log.error("FinAccountServiceImpl redis add account error , param:{}, error:{}", JSONObject.toJSONString(accountAddRequest), e);
        }


        return CommonResult.success();
    }


    /**
     * @param accountUpdateRequest :
     * @return com.dupake.common.message.CommonResult
     * @Description 修改帐套
     **/
    @Override
    @Transactional(rollbackFor = Exception.class)
    public CommonResult updateAccount(AccountUpdateRequest accountUpdateRequest) {

        FinAccount finAccount = finAccountMapper.selectOne(new LambdaQueryWrapper<FinAccount>()
                .eq(FinAccount::getId, accountUpdateRequest.getId())
                .eq(FinAccount::getIsDeleted, YesNoSwitchEnum.NO.getValue()));
        if(Objects.isNull(finAccount)){
            log.error("account is null");
            Asserts.fail(BaseResult.SYS_ROLE_INFO_IS_NOT_EXIST);
         }
        //帐套名称校验 权限标识校验
//        checkAccountInfo(accountUpdateRequest.getName(), accountUpdateRequest.getPermission(),finAccount);

        //修改帐套信息
        try {
            finAccountMapper.updateById(FinAccount.builder()
                    .accountCode(accountUpdateRequest.getAccountCode())
                    .accountName(accountUpdateRequest.getAccountName())
                    .address(accountUpdateRequest.getAddress())
                    .bankAccount(accountUpdateRequest.getBankAccount())
                    .bankCardNumber(accountUpdateRequest.getBankCardNumber())
                    .companyName(accountUpdateRequest.getCompanyName())
                    .phone(accountUpdateRequest.getPhone())
                    .taxNumber(accountUpdateRequest.getTaxNumber())
                    .remark(accountUpdateRequest.getRemark())
                    .id(accountUpdateRequest.getId())
                    .build());



        } catch (Exception e) {
            log.error("FinAccountServiceImpl update account error , param:{}, error:{}", JSONObject.toJSONString(accountUpdateRequest), e);
            Asserts.fail(BaseResult.FAILED);
        }

        try {
            Map<String, String> accountMap = getAccountMap();
            accountMap.put(accountUpdateRequest.getAccountCode(),accountUpdateRequest.getAccountName());
            redisUtil.hSet(redisKey,redisKey, JSONObject.toJSONString(accountMap));
        }catch (Exception e){
            redisUtil.hDel(redisKey,redisKey);
            log.error("FinAccountServiceImpl redis update account error , param:{}, error:{}", JSONObject.toJSONString(accountUpdateRequest), e);
        }


        return CommonResult.success();
    }

    /**
     * @param ids :
     * @return com.dupake.common.message.CommonResult
     * @Description
     **/
    @Override
    @Transactional(rollbackFor = Exception.class)
    public CommonResult deleteAccount(List<Long> ids) {
        //todo admin 帐号可可删除 查询帐套
//        List<FinAccount> finAccounts = finAccountMapper.selectList(
//                new LambdaUpdateWrapper<FinAccount>()
//                        .eq(FinAccount::getIsDeleted, YesNoSwitchEnum.NO.getValue())
//        );
//        if (!CollectionUtil.isEmpty(finAccounts)) {
//            log.error("account has sub accounts");
//            throw new BadRequestException(BaseResult.SYS_MENU_DELETE_ERROR_EXIST_SUB_MENU.getCode(),
//                    BaseResult.SYS_MENU_DELETE_ERROR_EXIST_SUB_MENU.getMessage());
//        }
        //批量修改帐套状态
        List<FinAccount> finAccountList = ids.stream().map(a -> {
            FinAccount finAccount = new FinAccount();
            finAccount.setIsDeleted(YesNoSwitchEnum.YES.getValue());
            finAccount.setUpdateTime(DateUtil.getCurrentTimeMillis());
            finAccount.setId(a);
            return finAccount;
        }).collect(Collectors.toList());

        try {
            finAccountMapper.updateBatch(finAccountList);
        } catch (Exception e) {
            log.error("FinAccountServiceImpl update account error , param:{}, error:{}", JSONObject.toJSONString(ids), e);
            Asserts.fail(BaseResult.FAILED);
        }

        //todo 修改角色帐套表数据


        try {
            Map<String, String> accountMap = getAccountMap();
            Map<String, String> stringMap = finAccountList.stream().collect(Collectors.toMap(FinAccount::getAccountCode, FinAccount::getAccountName));
            accountMap.forEach((k,v)->{
                if(!Objects.isNull(stringMap.get(k))){
                    accountMap.remove(k);
                }
            });
            redisUtil.hSet(redisKey,redisKey, JSONObject.toJSONString(accountMap));
        }catch (Exception e){
            redisUtil.hDel(redisKey,redisKey);
            log.error("FinAccountServiceImpl redis del account error , param:{}, error:{}", JSONObject.toJSONString(ids), e);
        }

        return CommonResult.success();
    }


    /**
     * 获取全部帐套信息
     * @return
     */
    @Override
    public CommonResult<List<AccountDTO>> listAll() {
        List<AccountDTO> collect = new ArrayList<>();
        //todo 根据角色ID查询角色所拥有帐套
        List<FinAccount> finAccounts = finAccountMapper.selectList(
                new LambdaUpdateWrapper<FinAccount>()
                        .eq(FinAccount::getIsDeleted, YesNoSwitchEnum.NO.getValue()));
        if(!CollectionUtils.isEmpty(finAccounts)){
            collect = finAccounts.stream().map(a -> {
                AccountDTO dto = new AccountDTO();
                BeanUtils.copyProperties(a, dto);
                return dto;
            }).collect(Collectors.toList());
        }


        return CommonResult.success(collect);
    }
}
