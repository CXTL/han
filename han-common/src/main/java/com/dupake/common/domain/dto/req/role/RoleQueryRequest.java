package com.dupake.common.domain.dto.req.role;

import com.dupake.common.domain.dto.req.BasePageRequest;
import lombok.Data;

/**
 * @ClassName UserQueryRequest
 * @Description 用户查询请求实体
 * @Author dupake
 * @Date 2020/6/9 10:57
 */
@Data
public class RoleQueryRequest extends BasePageRequest {

    private static final long serialVersionUID = -1970997896879063951L;
    
    private String name;

    private Long startTime;

    private Long endTime;

}
