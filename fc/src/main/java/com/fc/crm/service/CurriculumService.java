package com.fc.crm.service;

import com.fc.crm.domain.CurriculumDO;
import com.fc.crm.vo.CurriculumVO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author fengchi
 * @email 
 * @date 2019-09-22 14:55:13
 */
public interface CurriculumService {
	
	CurriculumDO get(Integer id);
	
	List<CurriculumDO> list(Map<String, Object> map);
	
	List<Map<String, Object>> findDataList(Map<String, Object> map);
	
	int save(CurriculumVO curriculum);
	
	int update(CurriculumVO curriculum);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
