package com.fc.crm.dao;

import com.fc.crm.domain.WorkPlanFollowUpDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * @author fengchi
 * @email
 * @date 2019-09-05 22:39:01
 */
@Mapper
public interface WorkPlanFollowUpDao {

    WorkPlanFollowUpDO get(Integer id);

    List<WorkPlanFollowUpDO> list(Map<String, Object> map);

    List<Map<String, Object>> findDataList(Map<String, Object> map);

    int save(WorkPlanFollowUpDO workPlanFollowUp);

    int update(WorkPlanFollowUpDO workPlanFollowUp);

    int remove(Integer id);

    int batchRemove(Integer[] ids);
}
