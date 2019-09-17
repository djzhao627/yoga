package com.fc.crm.service.impl;

import com.fc.common.utils.ShiroUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.fc.crm.dao.CoursePackagesDao;
import com.fc.crm.domain.CoursePackagesDO;
import com.fc.crm.service.CoursePackagesService;
import com.github.pagehelper.PageHelper;
import com.fc.common.utils.PageUtils;

@Service
public class CoursePackagesServiceImpl implements CoursePackagesService {
	@Autowired
	private CoursePackagesDao coursePackagesDao;
	
	@Override
	public CoursePackagesDO get(Integer id){
		return coursePackagesDao.get(id);
	}
	
	@Override
	public List<CoursePackagesDO> list(Map<String, Object> map){
		return coursePackagesDao.list(map);
	}
	
	@Override
	public List<Map<String, Object>> findDataList(Map<String, Object> map){
		List<Map<String, Object>> list = coursePackagesDao.findDataList(map);
		return list;
	}
	
	@Override
	public int save(CoursePackagesDO coursePackages){
		String deptId = coursePackages.getDeptId();
		if (StringUtils.isBlank(deptId)) {
			coursePackages.setDeptId(ShiroUtils.getUser().getDeptId().toString());
		}
		return coursePackagesDao.save(coursePackages);
	}
	
	@Override
	public int update(CoursePackagesDO coursePackages){
		return coursePackagesDao.update(coursePackages);
	}
	
	@Override
	public int remove(Integer id){
		return coursePackagesDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return coursePackagesDao.batchRemove(ids);
	}
	
}
