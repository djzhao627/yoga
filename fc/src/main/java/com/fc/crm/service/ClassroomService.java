package com.fc.crm.service;

import com.fc.crm.domain.ClassroomDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author fengchi
 * @email 
 * @date 2019-09-22 14:55:12
 */
public interface ClassroomService {
	
	ClassroomDO get(Integer id);
	
	List<ClassroomDO> list(Map<String, Object> map);
	
	List<Map<String, Object>> findDataList(Map<String, Object> map);
	
	int save(ClassroomDO classroom);
	
	int update(ClassroomDO classroom);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
