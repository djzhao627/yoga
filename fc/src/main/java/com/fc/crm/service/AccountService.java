package com.fc.crm.service;

import com.fc.crm.domain.AccountDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author fengchi
 * @email 
 * @date 2019-09-28 21:47:46
 */
public interface AccountService {
	
	AccountDO get(Integer id);
	
	List<AccountDO> list(Map<String, Object> map);
	
	List<Map<String, Object>> findDataList(Map<String, Object> map);
	
	int save(AccountDO account);
	
	int update(AccountDO account);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
