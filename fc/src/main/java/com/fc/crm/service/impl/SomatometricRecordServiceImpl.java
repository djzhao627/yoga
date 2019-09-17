package com.fc.crm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.fc.crm.dao.SomatometricRecordDao;
import com.fc.crm.domain.SomatometricRecordDO;
import com.fc.crm.service.SomatometricRecordService;
import com.github.pagehelper.PageHelper;
import com.fc.common.utils.PageUtils;

@Service
public class SomatometricRecordServiceImpl implements SomatometricRecordService {
	@Autowired
	private SomatometricRecordDao somatometricRecordDao;
	
	@Override
	public SomatometricRecordDO get(Integer id){
		return somatometricRecordDao.get(id);
	}
	
	@Override
	public List<SomatometricRecordDO> list(Map<String, Object> map){
		return somatometricRecordDao.list(map);
	}
	
	@Override
	public List<Map<String, Object>> findDataList(Map<String, Object> map){
		List<Map<String, Object>> list = somatometricRecordDao.findDataList(map);
		return list;
	}
	
	@Override
	public int save(SomatometricRecordDO somatometricRecord){
		return somatometricRecordDao.save(somatometricRecord);
	}
	
	@Override
	public int update(SomatometricRecordDO somatometricRecord){
		return somatometricRecordDao.update(somatometricRecord);
	}
	
	@Override
	public int remove(Integer id){
		return somatometricRecordDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return somatometricRecordDao.batchRemove(ids);
	}
	
}
