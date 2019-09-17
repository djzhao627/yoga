package com.fc.crm.service.impl;

import com.fc.common.utils.ShiroUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.fc.crm.dao.CourseDao;
import com.fc.crm.domain.CourseDO;
import com.fc.crm.service.CourseService;
import com.github.pagehelper.PageHelper;
import com.fc.common.utils.PageUtils;

@Service
public class CourseServiceImpl implements CourseService {
	@Autowired
	private CourseDao courseDao;
	
	@Override
	public CourseDO get(Integer id){
		return courseDao.get(id);
	}
	
	@Override
	public List<CourseDO> list(Map<String, Object> map){
		return courseDao.list(map);
	}
	
	@Override
	public List<Map<String, Object>> findDataList(Map<String, Object> map){
		List<Map<String, Object>> list = courseDao.findDataList(map);
		return list;
	}
	
	@Override
	public int save(CourseDO course){
		String deptId = course.getDeptId();
		if (StringUtils.isBlank(deptId)) {
			course.setDeptId(ShiroUtils.getUser().getDeptId().toString());
		}
		return courseDao.save(course);
	}
	
	@Override
	public int update(CourseDO course){
		return courseDao.update(course);
	}
	
	@Override
	public int remove(Integer id){
		return courseDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return courseDao.batchRemove(ids);
	}
	
}
