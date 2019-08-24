package com.fc.crm.service;

import com.fc.crm.domain.WorkPlanDO;

import java.util.List;
import java.util.Map;

/**
 * @author fengchi
 * @email
 * @date 2019-08-24 18:23:38
 */
public interface WorkPlanService {

    WorkPlanDO get(Integer id);

    List<WorkPlanDO> list(Map<String, Object> map);

    List<Map<String, Object>> findDatas(Map<String, Object> map);

    int save(WorkPlanDO workPlan);

    int update(WorkPlanDO workPlan);

    int remove(Integer id);

    int batchRemove(Integer[] ids);
}
