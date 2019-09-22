package com.fc.crm.service;

import com.fc.crm.domain.CurrMemberDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author fengchi
 * @email 
 * @date 2019-09-22 14:55:13
 */
public interface CurrMemberService {
	
	CurrMemberDO get(Integer id);
	
	List<CurrMemberDO> list(Map<String, Object> map);
	
	List<Map<String, Object>> findDataList(Map<String, Object> map);
	
	int save(CurrMemberDO currMember);
	
	int update(CurrMemberDO currMember);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
