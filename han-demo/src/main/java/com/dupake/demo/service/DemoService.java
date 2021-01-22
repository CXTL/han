package com.dupake.demo.service;

import com.dupake.demo.domain.UmsAdmin;
import com.dupake.demo.domain.UmsAdminDTO;

import java.util.List;
import java.util.Set;

/**
 * @description TODO
 * @date 2020-12-23
 */
public interface DemoService {

    List<UmsAdmin> getAdminList();

    List<UmsAdmin> getAdminListByPage(Integer pageNum, Integer pageSize);

    Integer addAdmin(UmsAdminDTO dto);

    Integer updateAdmin(UmsAdminDTO dto);

    Integer deleteAdmin(Set<Long> ids);
}
