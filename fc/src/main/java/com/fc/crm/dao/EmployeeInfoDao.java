package com.fc.crm.dao;

import com.fc.crm.domain.EmployeeInfoDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author fengchi
 * @email 
 * @date 2019-09-22 17:11:28
 */
@Mapper
public interface EmployeeInfoDao {

	EmployeeInfoDO get(String phonenumber);
	
	List<EmployeeInfoDO> list(Map<String,Object> map);
	
	List<Map<String, Object>> findDataList(Map<String, Object> map);
	
	int save(EmployeeInfoDO employeeInfo);
	
	int update(EmployeeInfoDO employeeInfo);
	
	int remove(String phonenumber);
	
	int batchRemove(String[] phonenumbers);
}
