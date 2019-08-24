package com.fc.business.service.impl;

import com.fc.business.dao.FcCustomFollowPlanDao;
import com.fc.business.domain.FcCustomFollowPlanDO;
import com.fc.business.service.FcCustomFollowPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class FcCustomFollowPlanServiceImpl implements FcCustomFollowPlanService {
	@Autowired
	private FcCustomFollowPlanDao fcCustomFollowPlanDao;
	
	@Override
	public FcCustomFollowPlanDO get(Integer id){
		return fcCustomFollowPlanDao.get(id);
	}
	
	@Override
	public List<FcCustomFollowPlanDO> list(Map<String, Object> map){
		return fcCustomFollowPlanDao.list(map);
	}
	
	@Override
	public List<Map<String, Object>> findDatas(Map<String, Object> map){
		List<Map<String, Object>> list = fcCustomFollowPlanDao.findDatas(map);
		return list;
	}
	
	@Override
	public int save(FcCustomFollowPlanDO fcCustomFollowPlan){
		return fcCustomFollowPlanDao.save(fcCustomFollowPlan);
	}
	
	@Override
	public int update(FcCustomFollowPlanDO fcCustomFollowPlan){
		return fcCustomFollowPlanDao.update(fcCustomFollowPlan);
	}
	
	@Override
	public int remove(Integer id){
		return fcCustomFollowPlanDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return fcCustomFollowPlanDao.batchRemove(ids);
	}
	
}
