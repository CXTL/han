package com.dupake.finance.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dupake.common.domain.dto.req.subject.SubjectQueryRequest;
import com.dupake.finance.domain.FinSubject;

import java.util.List;

/**
 * <p>
 * 财务-会计科目信息表 Mapper 接口
 * </p>
 *
 * @author dupake
 * @since 2020-07-26
 */
public interface FinSubjectMapper extends BaseMapper<FinSubject> {

    int getTotalCount(SubjectQueryRequest investQueryRequest);

    List<FinSubject> selectListPage(SubjectQueryRequest investQueryRequest);

    void updateBatch(List<FinSubject> finSubjectList);
}
