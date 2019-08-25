package com.fc.business.dao;

import java.util.List;
import java.util.Map;

import com.fc.business.domain.CustomFollowPlanDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author fengchi
 * @email 
 * @date 2019-08-23 22:38:51
 */
@Mapper
public interface CustomFollowPlanDao {

	CustomFollowPlanDO get(Integer id);
	
	List<CustomFollowPlanDO> list(Map<String, Object> map);
	
	List<Map<String, Object>> findDatas(Map<String, Object> map);
	
	int save(CustomFollowPlanDO customFollowPlanDO);
	
	int update(CustomFollowPlanDO customFollowPlanDO);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
