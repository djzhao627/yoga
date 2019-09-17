package com.fc.crm.service;

import com.fc.crm.domain.CoursePackagesDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author fengchi
 * @email 
 * @date 2019-09-14 16:30:50
 */
public interface CoursePackagesService {
	
	CoursePackagesDO get(Integer id);
	
	List<CoursePackagesDO> list(Map<String, Object> map);
	
	List<Map<String, Object>> findDataList(Map<String, Object> map);
	
	int save(CoursePackagesDO coursePackages);
	
	int update(CoursePackagesDO coursePackages);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
