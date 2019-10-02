package com.fc.crm.dao;

import com.fc.crm.domain.AccountDO;

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
public interface AccountDao {

	AccountDO get(Integer id);
	
	List<AccountDO> list(Map<String, Object> map);
	
	List<Map<String, Object>> findDataList(Map<String, Object> map);
	
	int save(AccountDO account);
	
	int update(AccountDO account);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
