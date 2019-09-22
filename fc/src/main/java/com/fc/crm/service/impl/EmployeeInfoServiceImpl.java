package com.fc.crm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.fc.crm.dao.EmployeeInfoDao;
import com.fc.crm.domain.EmployeeInfoDO;
import com.fc.crm.service.EmployeeInfoService;
import com.github.pagehelper.PageHelper;
import com.fc.common.utils.PageUtils;

@Service
public class EmployeeInfoServiceImpl implements EmployeeInfoService {
	@Autowired
	private EmployeeInfoDao employeeInfoDao;
	
	@Override
	public EmployeeInfoDO get(String phonenumber){
		return employeeInfoDao.get(phonenumber);
	}
	
	@Override
	public List<EmployeeInfoDO> list(Map<String, Object> map){
		return employeeInfoDao.list(map);
	}
	
	@Override
	public List<Map<String, Object>> findDataList(Map<String, Object> map){
		List<Map<String, Object>> list = employeeInfoDao.findDataList(map);
		return list;
	}
	
	@Override
	public int save(EmployeeInfoDO employeeInfo){
		return employeeInfoDao.save(employeeInfo);
	}
	
	@Override
	public int update(EmployeeInfoDO employeeInfo){
		return employeeInfoDao.update(employeeInfo);
	}
	
	@Override
	public int remove(String phonenumber){
		return employeeInfoDao.remove(phonenumber);
	}
	
	@Override
	public int batchRemove(String[] phonenumbers){
		return employeeInfoDao.batchRemove(phonenumbers);
	}
	
}
