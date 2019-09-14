package com.fc.crm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.fc.crm.dao.CampaignDao;
import com.fc.crm.domain.CampaignDO;
import com.fc.crm.service.CampaignService;
import com.github.pagehelper.PageHelper;
import com.fc.common.utils.PageUtils;

@Service
public class CampaignServiceImpl implements CampaignService {
	@Autowired
	private CampaignDao campaignDao;
	
	@Override
	public CampaignDO get(Integer id){
		return campaignDao.get(id);
	}
	
	@Override
	public List<CampaignDO> list(Map<String, Object> map){
		return campaignDao.list(map);
	}
	
	@Override
	public List<Map<String, Object>> findDataList(Map<String, Object> map){
		List<Map<String, Object>> list = campaignDao.findDataList(map);
		return list;
	}
	
	@Override
	public int save(CampaignDO campaign){
		return campaignDao.save(campaign);
	}
	
	@Override
	public int update(CampaignDO campaign){
		return campaignDao.update(campaign);
	}
	
	@Override
	public int remove(Integer id){
		return campaignDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return campaignDao.batchRemove(ids);
	}
	
}
