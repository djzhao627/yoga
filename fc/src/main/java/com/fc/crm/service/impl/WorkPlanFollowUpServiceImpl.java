package com.fc.crm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.fc.crm.dao.WorkPlanFollowUpDao;
import com.fc.crm.domain.WorkPlanFollowUpDO;
import com.fc.crm.service.WorkPlanFollowUpService;
import com.github.pagehelper.PageHelper;
import com.fc.common.utils.PageUtils;

@Service
public class WorkPlanFollowUpServiceImpl implements WorkPlanFollowUpService {
	@Autowired
	private WorkPlanFollowUpDao workPlanFollowUpDao;
	
	@Override
	public WorkPlanFollowUpDO get(Integer id){
		return workPlanFollowUpDao.get(id);
	}
	
	@Override
	public List<WorkPlanFollowUpDO> list(Map<String, Object> map){
		return workPlanFollowUpDao.list(map);
	}
	
	@Override
	public List<Map<String, Object>> findDataList(Map<String, Object> map){
		List<Map<String, Object>> list = workPlanFollowUpDao.findDataList(map);
		return list;
	}
	
	@Override
	public int save(WorkPlanFollowUpDO workPlanFollowUp){
		return workPlanFollowUpDao.save(workPlanFollowUp);
	}
	
	@Override
	public int update(WorkPlanFollowUpDO workPlanFollowUp){
		return workPlanFollowUpDao.update(workPlanFollowUp);
	}
	
	@Override
	public int remove(Integer id){
		return workPlanFollowUpDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return workPlanFollowUpDao.batchRemove(ids);
	}
	
}
