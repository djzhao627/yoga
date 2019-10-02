package com.fc.crm.service;


import com.fc.crm.domain.MemberDO;

import java.util.List;
import java.util.Map;

/**
 * 会员信息表
 * 
 * @author fengchi
 * @email 
 * @date 2019-08-19 21:40:52
 */
public interface MemberService {
	
	MemberDO get(Integer id);
	
	List<MemberDO> list(Map<String, Object> map);
	
	List<Map<String, Object>> findDatas(Map<String, Object> map);
	
	int save(MemberDO memberDO);
	
	int update(MemberDO memberDO);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
	Map<String,String> queryNameByCode(String code);

}
