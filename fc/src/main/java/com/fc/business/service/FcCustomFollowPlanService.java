package com.fc.business.service;


import com.fc.business.domain.FcCustomFollowPlanDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author fengchi
 * @email 
 * @date 2019-08-23 22:38:51
 */
public interface FcCustomFollowPlanService {
	
	FcCustomFollowPlanDO get(Integer id);
	
	List<FcCustomFollowPlanDO> list(Map<String, Object> map);
	
	List<Map<String, Object>> findDatas(Map<String, Object> map);
	
	int save(FcCustomFollowPlanDO fcCustomFollowPlan);
	
	int update(FcCustomFollowPlanDO fcCustomFollowPlan);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
