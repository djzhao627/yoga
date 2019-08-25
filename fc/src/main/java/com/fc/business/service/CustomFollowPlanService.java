package com.fc.business.service;


import com.fc.business.domain.CustomFollowPlanDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author fengchi
 * @email 
 * @date 2019-08-23 22:38:51
 */
public interface CustomFollowPlanService {
	
	CustomFollowPlanDO get(Integer id);
	
	List<CustomFollowPlanDO> list(Map<String, Object> map);
	
	List<Map<String, Object>> findDatas(Map<String, Object> map);
	
	int save(CustomFollowPlanDO customFollowPlanDO);
	
	int update(CustomFollowPlanDO customFollowPlanDO);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
