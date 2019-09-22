package com.fc.crm.dao;

import com.fc.crm.domain.WorkPlanDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 工作计划
 *
 * @author fengchi
 * @email
 * @date 2019-08-26 22:59:56
 */
@Mapper
public interface WorkPlanDao {

    WorkPlanDO get(String id);

    List<WorkPlanDO> list(Map<String, Object> map);

    List<Map<String, Object>> findDataList(Map<String, Object> map);

    int save(WorkPlanDO workPlan);

    int update(WorkPlanDO workPlan);

    int remove(String id);

    int batchRemove(String[] ids);
}
