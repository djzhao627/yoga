package com.fc.crm.service.impl;

import com.fc.business.dao.MemberBaseInfoDao;
import com.fc.crm.dao.*;
import com.fc.crm.domain.*;
import com.fc.crm.vo.CurriculumVO;
import com.fc.system.dao.UserDao;
import com.fc.system.domain.UserDO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.fc.crm.service.CurriculumService;
import com.github.pagehelper.PageHelper;
import com.fc.common.utils.PageUtils;

@Service
public class CurriculumServiceImpl implements CurriculumService {
	@Autowired
	private CurriculumDao curriculumDao;
	@Autowired
	private CurrMemberDao currMemberDao;
	@Autowired
	private CourseDao courseDao;
	@Autowired
	private MemberDao memberDao;
	@Autowired
	private ClassroomDao classroomDao;
	@Autowired
	private UserDao userDao;
	
	@Override
	public CurriculumVO get(Integer id){
		CurriculumVO curriculumVO = new CurriculumVO();
		CurriculumDO curriculumDO = curriculumDao.get(id);
		BeanUtils.copyProperties(curriculumDO,curriculumVO);
		CourseDO courseDO = courseDao.get(curriculumDO.getCourseId());
		curriculumVO.setCourseName(courseDO.getCourseName());
		UserDO userDO = userDao.get(Long.parseLong(curriculumDO.getMemberId().toString()));
		curriculumVO.setMemberName(userDO.getUsername());
		ClassroomDO classroomDO = classroomDao.get(curriculumDO.getClassroomId());
		curriculumVO.setClassroomName(classroomDO.getRoomName());
		return curriculumVO;
	}
	
	@Override
	public List<CurriculumBO> list(Map<String, Object> map){
		return curriculumDao.list(map);
	}
	
	@Override
	public List<Map<String, Object>> findDataList(Map<String, Object> map){
		List<Map<String, Object>> list = curriculumDao.findDataList(map);
		return list;
	}
	
	@Override
	public int save(CurriculumVO curriculum){
		CurriculumDO curriculumDO = new CurriculumDO();
		BeanUtils.copyProperties(curriculum,curriculumDO);
		//TUDO
		//查询教练在此时间段是否已经排课
		//查询教室在此时间段是否已经排课
		int i = curriculumDao.save(curriculumDO);
		return i;
	}
	
	@Override
	public int update(CurriculumVO curriculum){
		CurriculumDO curriculumDO = new CurriculumDO();
		BeanUtils.copyProperties(curriculum,curriculumDO);
		int i = curriculumDao.update(curriculumDO);
		return i;
	}
	
	@Override
	public int remove(Integer id){
		return curriculumDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return curriculumDao.batchRemove(ids);
	}
	
}
