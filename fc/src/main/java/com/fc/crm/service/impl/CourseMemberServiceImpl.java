package com.fc.crm.service.impl;

import com.fc.crm.vo.CourseMemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.fc.crm.dao.CourseMemberDao;
import com.fc.crm.domain.CourseMemberDO;
import com.fc.crm.service.CourseMemberService;
import com.github.pagehelper.PageHelper;
import com.fc.common.utils.PageUtils;

@Service
public class CourseMemberServiceImpl implements CourseMemberService {
	@Autowired
	private CourseMemberDao courseMemberDao;
	
	@Override
	public CourseMemberDO get(Integer id){
		return courseMemberDao.get(id);
	}
	
	@Override
	public List<CourseMemberDO> list(Map<String, Object> map){
		return courseMemberDao.list(map);
	}
	
	@Override
	public List<Map<String, Object>> findDataList(Map<String, Object> map){
		List<Map<String, Object>> list = courseMemberDao.findDataList(map);
		return list;
	}
	
	@Override
	public int save(CourseMemberVO courseMember){
		CourseMemberDO courseMemberDO = new CourseMemberDO();
		String memberIds = courseMember.getMemberIds();
		if (memberIds.contains(",")) {
			String[] idArr = memberIds.split(",");
			String[] nameArr = courseMember.getMemberName().split(",");
			for (int i = 0; i < idArr.length; i++) {
				courseMemberDO.setCourseId(courseMember.getCourseId());
				courseMemberDO.setCourseName(courseMember.getCourseName());
				courseMemberDO.setMemberId(Integer.parseInt(idArr[i]));
				courseMemberDO.setMemberName(nameArr[i]);
				courseMemberDao.save(courseMemberDO);
			}
		}
		return 1;
	}
	
	@Override
	public int update(CourseMemberDO courseMember){
		return courseMemberDao.update(courseMember);
	}
	
	@Override
	public int remove(Integer id){
		return courseMemberDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return courseMemberDao.batchRemove(ids);
	}
	
}
