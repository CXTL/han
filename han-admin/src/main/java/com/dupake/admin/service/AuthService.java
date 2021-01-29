package com.dupake.admin.service;

import com.dupake.common.api.CommonResult;
import com.dupake.common.constant.FeignConstant;
import com.dupake.common.domain.dto.Oauth2TokenDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @description TODO
 * @date 2020-12-28
 */
@FeignClient(FeignConstant.SERVER_NAME_AUTH)
public interface AuthService {

    @PostMapping(value = "/oauth/token")
    CommonResult<Oauth2TokenDto> getAccessToken(@RequestParam Map<String, String> parameters);

}
