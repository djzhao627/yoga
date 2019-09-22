package com.fc.crm.service;

import com.fc.crm.domain.EmployeeInfoDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author fengchi
 * @email 
 * @date 2019-09-22 17:11:28
 */
public interface EmployeeInfoService {
	
	EmployeeInfoDO get(String phonenumber);
	
	List<EmployeeInfoDO> list(Map<String, Object> map);
	
	List<Map<String, Object>> findDataList(Map<String, Object> map);
	
	int save(EmployeeInfoDO employeeInfo);
	
	int update(EmployeeInfoDO employeeInfo);
	
	int remove(String phonenumber);
	
	int batchRemove(String[] phonenumbers);
}
