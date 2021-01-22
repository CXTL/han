package com.dupake.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dupake.admin.domain.CmsHelp;
import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @description TODO
 * @date 2020-12-23
 */
@Mapper
public interface DemoMapper extends BaseMapper<CmsHelp> {


    List<CmsHelp> getCmsListByPage(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);
}
