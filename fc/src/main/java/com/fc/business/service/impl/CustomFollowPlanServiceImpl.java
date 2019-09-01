package com.fc.business.service.impl;

import com.fc.business.dao.CustomFollowPlanDao;
import com.fc.business.domain.CustomFollowPlanDO;
import com.fc.business.service.CustomFollowPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class CustomFollowPlanServiceImpl implements CustomFollowPlanService {
	@Autowired
	private CustomFollowPlanDao customFollowPlanDao;
	
	@Override
	public CustomFollowPlanDO get(Integer id){
		return customFollowPlanDao.get(id);
	}
	
	@Override
	public List<CustomFollowPlanDO> list(Map<String, Object> map){
		return customFollowPlanDao.list(map);
	}
	
	@Override
	public List<Map<String, Object>> findDatas(Map<String, Object> map){
		List<Map<String, Object>> list = customFollowPlanDao.findDatas(map);
		return list;
	}
	
	@Override
	public int save(CustomFollowPlanDO customFollowPlan){
		return customFollowPlanDao.save(customFollowPlan);
	}
	
	@Override
	public int update(CustomFollowPlanDO customFollowPlan){
		return customFollowPlanDao.update(customFollowPlan);
	}
	
	@Override
	public int remove(Integer id){
		return customFollowPlanDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return customFollowPlanDao.batchRemove(ids);
	}

    @Override
    public CustomFollowPlanDO getPlanData(String customId) {
        return customFollowPlanDao.getPlanData(customId);
    }

}
