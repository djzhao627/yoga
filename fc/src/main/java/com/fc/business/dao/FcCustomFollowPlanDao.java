package com.fc.business.dao;

import java.util.List;
import java.util.Map;

import com.fc.business.domain.FcCustomFollowPlanDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author fengchi
 * @email 
 * @date 2019-08-23 22:38:51
 */
@Mapper
public interface FcCustomFollowPlanDao {

	FcCustomFollowPlanDO get(Integer id);
	
	List<FcCustomFollowPlanDO> list(Map<String, Object> map);
	
	List<Map<String, Object>> findDatas(Map<String, Object> map);
	
	int save(FcCustomFollowPlanDO fcCustomFollowPlan);
	
	int update(FcCustomFollowPlanDO fcCustomFollowPlan);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
