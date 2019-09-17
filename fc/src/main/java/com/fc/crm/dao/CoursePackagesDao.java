package com.fc.crm.dao;

import com.fc.crm.domain.CoursePackagesDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author fengchi
 * @email 
 * @date 2019-09-14 16:30:50
 */
@Mapper
public interface CoursePackagesDao {

	CoursePackagesDO get(Integer id);
	
	List<CoursePackagesDO> list(Map<String, Object> map);
	
	List<Map<String, Object>> findDataList(Map<String, Object> map);
	
	int save(CoursePackagesDO coursePackages);
	
	int update(CoursePackagesDO coursePackages);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
