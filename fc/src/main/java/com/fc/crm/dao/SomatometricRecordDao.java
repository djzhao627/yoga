package com.fc.crm.dao;

import com.fc.crm.domain.SomatometricRecordDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author fengchi
 * @email 
 * @date 2019-09-14 15:03:04
 */
@Mapper
public interface SomatometricRecordDao {

	SomatometricRecordDO get(Integer id);
	
	List<SomatometricRecordDO> list(Map<String, Object> map);
	
	List<Map<String, Object>> findDataList(Map<String, Object> map);
	
	int save(SomatometricRecordDO somatometricRecord);
	
	int update(SomatometricRecordDO somatometricRecord);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
