package com.fc.crm.service;

import com.fc.crm.domain.WorkPlanDO;

import java.util.List;
import java.util.Map;

/**
 * 工作计划
 *
 * @author fengchi
 * @email
 * @date 2019-08-26 22:59:56
 */
public interface WorkPlanService {

    WorkPlanDO get(String id);

    List<WorkPlanDO> list(Map<String, Object> map);

    List<Map<String, Object>> findDatas(Map<String, Object> map);

    int save(WorkPlanDO workPlan);

    int update(WorkPlanDO workPlan);

    int remove(String id);

    int batchRemove(String[] ids);

    int publicWorkPlan(String[] ids);
}
