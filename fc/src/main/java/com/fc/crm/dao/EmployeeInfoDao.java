package com.fc.crm.dao;

import com.fc.crm.domain.EmployeeInfoDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author fengchi
 * @email 
 * @date 2019-09-23 00:35:29
 */
@Mapper
public interface EmployeeInfoDao {

	EmployeeInfoDO get(String phoneNumber);
	
	List<EmployeeInfoDO> list(Map<String,Object> map);
	
	List<Map<String, Object>> findDataList(Map<String, Object> map);
	
	int save(EmployeeInfoDO employeeInfo);
	
	int update(EmployeeInfoDO employeeInfo);
	
	int remove(String phoneNumber);
	
	int batchRemove(String[] phoneNumbers);
}
