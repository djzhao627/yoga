package com.fc.crm.dao;

import com.fc.crm.domain.CampaignDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author fengchi
 * @email 
 * @date 2019-09-14 15:03:03
 */
@Mapper
public interface CampaignDao {

	CampaignDO get(Integer id);
	
	List<CampaignDO> list(Map<String, Object> map);
	
	List<Map<String, Object>> findDataList(Map<String, Object> map);
	
	int save(CampaignDO campaign);
	
	int update(CampaignDO campaign);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
