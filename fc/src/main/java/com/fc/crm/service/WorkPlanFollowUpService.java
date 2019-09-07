package com.fc.crm.service;

import com.fc.crm.domain.WorkPlanFollowUpDO;

import java.util.List;
import java.util.Map;

/**
 * @author fengchi
 * @email
 * @date 2019-09-05 22:39:01
 */
public interface WorkPlanFollowUpService {

    WorkPlanFollowUpDO get(Integer id);

    List<WorkPlanFollowUpDO> list(Map<String, Object> map);

    List<Map<String, Object>> findDataList(Map<String, Object> map);

    int save(WorkPlanFollowUpDO workPlanFollowUp);

    int update(WorkPlanFollowUpDO workPlanFollowUp);

    int remove(Integer id);

    int batchRemove(Integer[] ids);
}
