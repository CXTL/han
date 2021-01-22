package com.dupake.admin.service;

import com.dupake.admin.domain.CmsHelp;
import com.dupake.admin.domain.CmsHelpDTO;

import java.util.List;
import java.util.Set;

/**
 * @description TODO
 * @date 2020-12-23
 */
public interface DemoService {

    List<CmsHelp> getCmsList();

    List<CmsHelp> getCmsListByPage(Integer pageNum, Integer pageSize);

    Integer addCms(CmsHelpDTO dto);

    Integer updateCms(CmsHelpDTO dto);

    Integer deleteCms(Set<Long> ids);
}
