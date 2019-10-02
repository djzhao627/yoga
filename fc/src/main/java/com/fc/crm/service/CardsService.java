package com.fc.crm.service;

import com.fc.crm.domain.CardsDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author fengchi
 * @email 
 * @date 2019-09-28 21:47:46
 */
public interface CardsService {
	
	CardsDO get(Integer id);
	
	List<CardsDO> list(Map<String, Object> map);
	
	List<Map<String, Object>> findDataList(Map<String, Object> map);
	
	int save(CardsDO cards);
	
	int update(CardsDO cards);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
