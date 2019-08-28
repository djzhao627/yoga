package com.fc.crm.dao;

import com.fc.crm.domain.OrderDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author fengchi
 * @email 
 * @date 2019-08-27 21:40:02
 */
@Mapper
public interface OrderDao {

	OrderDO get(Integer id);
	
	List<OrderDO> list(Map<String, Object> map);
	
	List<Map<String, Object>> findDatas(Map<String, Object> map);
	
	int save(OrderDO order);
	
	int update(OrderDO order);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
