package com.fc.crm.dao;

import com.fc.crm.domain.ClassroomDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author fengchi
 * @email 
 * @date 2019-09-22 14:55:12
 */
@Mapper
public interface ClassroomDao {

	ClassroomDO get(Integer id);
	
	List<ClassroomDO> list(Map<String, Object> map);
	
	List<Map<String, Object>> findDataList(Map<String, Object> map);
	
	int save(ClassroomDO classroom);
	
	int update(ClassroomDO classroom);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
