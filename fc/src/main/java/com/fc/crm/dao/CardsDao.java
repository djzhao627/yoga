package com.fc.crm.dao;

import com.fc.crm.domain.CardsDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author fengchi
 * @email 
 * @date 2019-09-28 21:47:46
 */
@Mapper
public interface CardsDao {

	CardsDO get(Integer id);
	
	List<CardsDO> list(Map<String, Object> map);
	
	List<Map<String, Object>> findDataList(Map<String, Object> map);
	
	int save(CardsDO cards);
	
	int update(CardsDO cards);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
