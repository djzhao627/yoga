package com.fc.business.service;

import com.fc.business.domain.MemberBaseInfoDO;

import java.util.List;
import java.util.Map;

/**
 * 会员信息表
 * 
 * @author fengchi
 * @email 
 * @date 2019-08-19 21:40:52
 */
public interface MemberBaseInfoService {
	
	MemberBaseInfoDO get(Integer id);
	
	List<MemberBaseInfoDO> list(Map<String, Object> map);
	
	List<Map<String, Object>> findDatas(Map<String, Object> map);
	
	int save(MemberBaseInfoDO fcMemberManagementBaseinfo);
	
	int update(MemberBaseInfoDO fcMemberManagementBaseinfo);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
	Map<String,String> queryNameByCode(String code);

}
