package com.fc.crm.dao;

import com.fc.crm.domain.CourseDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author fengchi
 * @email 
 * @date 2019-09-14 16:30:49
 */
@Mapper
public interface CourseDao {

	CourseDO get(Integer id);
	
	List<CourseDO> list(Map<String, Object> map);
	
	List<Map<String, Object>> findDataList(Map<String, Object> map);
	
	int save(CourseDO course);
	
	int update(CourseDO course);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
