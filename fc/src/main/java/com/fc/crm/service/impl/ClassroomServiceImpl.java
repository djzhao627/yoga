package com.fc.crm.service.impl;

import com.fc.common.utils.ShiroUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.fc.crm.dao.ClassroomDao;
import com.fc.crm.domain.ClassroomDO;
import com.fc.crm.service.ClassroomService;
import com.github.pagehelper.PageHelper;
import com.fc.common.utils.PageUtils;

@Service
public class ClassroomServiceImpl implements ClassroomService {
	@Autowired
	private ClassroomDao classroomDao;
	
	@Override
	public ClassroomDO get(Integer id){
		return classroomDao.get(id);
	}
	
	@Override
	public List<ClassroomDO> list(Map<String, Object> map){
		return classroomDao.list(map);
	}
	
	@Override
	public List<Map<String, Object>> findDataList(Map<String, Object> map){
		List<Map<String, Object>> list = classroomDao.findDataList(map);
		return list;
	}
	
	@Override
	public int save(ClassroomDO classroom){
		Long deptId = ShiroUtils.getUser().getDeptId();
		Long deptId1 = classroom.getDeptId();
		if (deptId1 == null) {
			classroom.setDeptId(deptId);
		}
		return classroomDao.save(classroom);
	}
	
	@Override
	public int update(ClassroomDO classroom){
		Long deptId = ShiroUtils.getUser().getDeptId();
		Long deptId1 = classroom.getDeptId();
		if (deptId1 == null) {
			classroom.setDeptId(deptId);
		}
		return classroomDao.update(classroom);
	}
	
	@Override
	public int remove(Integer id){
		return classroomDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return classroomDao.batchRemove(ids);
	}
	
}
