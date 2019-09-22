package com.fc.crm.service.impl;

import com.fc.crm.dao.CurrMemberDao;
import com.fc.crm.domain.CurrMemberDO;
import com.fc.crm.vo.CurriculumVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.fc.crm.dao.CurriculumDao;
import com.fc.crm.domain.CurriculumDO;
import com.fc.crm.service.CurriculumService;
import com.github.pagehelper.PageHelper;
import com.fc.common.utils.PageUtils;

@Service
public class CurriculumServiceImpl implements CurriculumService {
	@Autowired
	private CurriculumDao curriculumDao;
	@Autowired
	private CurrMemberDao currMemberDao;
	
	@Override
	public CurriculumDO get(Integer id){
		return curriculumDao.get(id);
	}
	
	@Override
	public List<CurriculumDO> list(Map<String, Object> map){
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
		CurrMemberDO currMemberDO = new CurrMemberDO();
		String ids = curriculum.getIds();
		if (ids != null) {
			String[] arr = ids.split(",");
			for (int h = 0; h < arr.length; h++) {
				currMemberDO.setCurriculumId(curriculum.getId());
				currMemberDO.setMemberId(Integer.parseInt(arr[h]));
				currMemberDao.save(currMemberDO);
			}
		}
		return i;
	}
	
	@Override
	public int update(CurriculumVO curriculum){
		CurriculumDO curriculumDO = new CurriculumDO();
		BeanUtils.copyProperties(curriculum,curriculumDO);
		int i = curriculumDao.update(curriculumDO);
		CurrMemberDO currMemberDO = new CurrMemberDO();
		String ids = curriculum.getIds();
		if (ids != null) {
			String[] arr = ids.split(",");
			currMemberDao.deleteAll(curriculum.getId(),arr);
			for (int h = 0; h < arr.length; h++) {
				currMemberDO.setCurriculumId(curriculum.getId());
				currMemberDO.setMemberId(Integer.parseInt(arr[h]));
				currMemberDao.save(currMemberDO);
			}
		}
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
