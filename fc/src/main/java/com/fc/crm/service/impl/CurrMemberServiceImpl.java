package com.fc.crm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.fc.crm.dao.CurrMemberDao;
import com.fc.crm.domain.CurrMemberDO;
import com.fc.crm.service.CurrMemberService;
import com.github.pagehelper.PageHelper;
import com.fc.common.utils.PageUtils;

@Service
public class CurrMemberServiceImpl implements CurrMemberService {
	@Autowired
	private CurrMemberDao currMemberDao;
	
	@Override
	public CurrMemberDO get(Integer id){
		return currMemberDao.get(id);
	}
	
	@Override
	public List<CurrMemberDO> list(Map<String, Object> map){
		return currMemberDao.list(map);
	}
	
	@Override
	public List<Map<String, Object>> findDataList(Map<String, Object> map){
		List<Map<String, Object>> list = currMemberDao.findDataList(map);
		return list;
	}
	
	@Override
	public int save(CurrMemberDO currMember){
		return currMemberDao.save(currMember);
	}
	
	@Override
	public int update(CurrMemberDO currMember){
		return currMemberDao.update(currMember);
	}
	
	@Override
	public int remove(Integer id){
		return currMemberDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return currMemberDao.batchRemove(ids);
	}
	
}
