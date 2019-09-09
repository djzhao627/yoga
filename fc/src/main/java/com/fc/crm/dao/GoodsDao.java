package com.fc.crm.dao;

import com.fc.crm.domain.GoodsDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author fengchi
 * @email 
 * @date 2019-09-08 14:56:30
 */
@Mapper
public interface GoodsDao {

	GoodsDO get(Integer id);
	
	List<GoodsDO> list(Map<String, Object> map);
	
	List<Map<String, Object>> findDatas(Map<String, Object> map);
	
	int save(GoodsDO goods);
	
	int update(GoodsDO goods);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
