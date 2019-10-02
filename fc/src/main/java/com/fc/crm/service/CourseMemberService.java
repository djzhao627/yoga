package com.fc.crm.service;

import com.fc.crm.domain.CourseMemberDO;
import com.fc.crm.vo.CourseMemberVO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author fengchi
 * @email 
 * @date 2019-10-02 15:20:41
 */
public interface CourseMemberService {
	
	CourseMemberDO get(Integer id);
	
	List<CourseMemberDO> list(Map<String, Object> map);
	
	List<Map<String, Object>> findDataList(Map<String, Object> map);
	
	int save(CourseMemberVO courseMember);
	
	int update(CourseMemberDO courseMember);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
