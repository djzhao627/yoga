package com.fc.crm.dao;

import com.fc.crm.domain.CourseMemberDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author fengchi
 * @email 
 * @date 2019-10-02 15:20:41
 */
@Mapper
public interface CourseMemberDao {

	CourseMemberDO get(Integer id);
	
	List<CourseMemberDO> list(Map<String, Object> map);
	
	List<Map<String, Object>> findDataList(Map<String, Object> map);
	
	int save(CourseMemberDO courseMember);
	
	int update(CourseMemberDO courseMember);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
