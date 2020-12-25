package com.dupake.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dupake.admin.domain.UmsRole;
import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @description TODO
 * @date 2020-12-24
 */
@Mapper
public interface RoleMapper extends BaseMapper<UmsRole> {

    /**
     * 获取用于所有角色
     */
    List<UmsRole> getRoleList(@Param("adminId") Long adminId);

}
