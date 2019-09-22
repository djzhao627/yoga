package com.fc.crm.dao;

import com.fc.crm.domain.CurrMemberDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author fengchi
 * @email 
 * @date 2019-09-22 14:55:13
 */
@Mapper
public interface CurrMemberDao {

	CurrMemberDO get(Integer id);
	
	List<CurrMemberDO> list(Map<String, Object> map);
	
	List<Map<String, Object>> findDataList(Map<String, Object> map);
	
	int save(CurrMemberDO currMember);
	
	int update(CurrMemberDO currMember);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);

    void deleteAll(Integer currId, String[] ids);
}
