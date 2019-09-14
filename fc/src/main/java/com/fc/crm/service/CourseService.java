package com.fc.crm.service;

import com.fc.crm.domain.CourseDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author fengchi
 * @email 
 * @date 2019-09-14 16:30:49
 */
public interface CourseService {
	
	CourseDO get(Integer id);
	
	List<CourseDO> list(Map<String, Object> map);
	
	List<Map<String, Object>> findDataList(Map<String, Object> map);
	
	int save(CourseDO course);
	
	int update(CourseDO course);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
