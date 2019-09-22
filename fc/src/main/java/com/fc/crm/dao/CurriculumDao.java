package com.fc.crm.dao;

import com.fc.crm.domain.CurriculumDO;

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
public interface CurriculumDao {

	CurriculumDO get(Integer id);
	
	List<CurriculumDO> list(Map<String, Object> map);
	
	List<Map<String, Object>> findDataList(Map<String, Object> map);
	
	int save(CurriculumDO curriculum);
	
	int update(CurriculumDO curriculum);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
