package com.dupake.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dupake.demo.domain.UmsAdmin;
import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @description TODO
 * @date 2020-12-23
 */
@Mapper
public interface DemoMapper extends BaseMapper<UmsAdmin> {


    List<UmsAdmin> getAdminListByPage(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);
}
