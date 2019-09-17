package com.fc.crm.service;

import com.fc.crm.domain.GoodsDO;
import com.fc.crm.vo.GoodsVO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author fengchi
 * @email 
 * @date 2019-09-08 14:56:30
 */
public interface GoodsService {
	
	GoodsVO get(Integer id);
	
	List<GoodsVO> list(Map<String, Object> map);
	
	List<Map<String, Object>> findDatas(Map<String, Object> map);
	
	int save(GoodsVO goods);
	
	int update(GoodsVO goods);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
