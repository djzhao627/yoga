package com.fc.business.service.impl;

import com.fc.business.dao.CustomFollowPlanDao;
import com.fc.business.domain.CustomFollowPlanDO;
import com.fc.business.domain.MemberBaseInfoDO;
import com.fc.business.service.CustomFollowPlanService;
import com.fc.business.service.MemberBaseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;


@Service
public class CustomFollowPlanServiceImpl implements CustomFollowPlanService {
	@Autowired
	private CustomFollowPlanDao customFollowPlanDao;
	@Autowired
	private MemberBaseInfoService memberBaseInfoService;
	
	@Override
	public CustomFollowPlanDO get(Integer id){
		return customFollowPlanDao.get(id);
	}
	
	@Override
	public List<CustomFollowPlanDO> list(Map<String, Object> map){
		List<CustomFollowPlanDO> list = customFollowPlanDao.list(map);
		Map<String,String> courseMap=memberBaseInfoService.queryNameByCode("consultingCourse_type");
		if (!CollectionUtils.isEmpty(list)) {
			list.forEach(p->{
				p.setConsultingCourse(courseMap.get(p.getConsultingCourse()));
				p.setStartTime(p.getStartTime()+"至"+p.getEndTime());
			});
		}
		return list;
	}
	
	@Override
	public List<Map<String, Object>> findDatas(Map<String, Object> map){
		List<Map<String, Object>> list = customFollowPlanDao.findDatas(map);
		return list;
	}
	
	@Override
	public int save(CustomFollowPlanDO customFollowPlan){
		int i = customFollowPlanDao.save(customFollowPlan);
		if (i == 1) {
			MemberBaseInfoDO memberBaseInfoDO = new MemberBaseInfoDO();
			memberBaseInfoDO.setId(Integer.parseInt(customFollowPlan.getCustomId()));
			memberBaseInfoDO.setConsultingCourse(customFollowPlan.getConsultingCourse());
			memberBaseInfoService.update(memberBaseInfoDO);
		}
		return i;
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
