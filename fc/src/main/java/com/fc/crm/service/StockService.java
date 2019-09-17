package com.fc.crm.service;

import com.fc.crm.domain.StockDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author fengchi
 * @email 
 * @date 2019-09-08 14:56:31
 */
public interface StockService {
	
	StockDO get(Integer goodsId);
	
	List<StockDO> list(Map<String, Object> map);
	
	List<Map<String, Object>> findDatas(Map<String, Object> map);
	
	int save(StockDO stock);
	
	int update(StockDO stock);
	
	int remove(Integer goodsId);
	
	int batchRemove(Integer[] goodsIds);
}
