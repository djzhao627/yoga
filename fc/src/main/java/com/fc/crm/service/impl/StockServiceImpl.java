package com.fc.crm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.fc.crm.dao.StockDao;
import com.fc.crm.domain.StockDO;
import com.fc.crm.service.StockService;
import com.github.pagehelper.PageHelper;
import com.fc.common.utils.PageUtils;

@Service
public class StockServiceImpl implements StockService {
	@Autowired
	private StockDao stockDao;
	
	@Override
	public StockDO get(Integer goodsId){
		return stockDao.get(goodsId);
	}
	
	@Override
	public List<StockDO> list(Map<String, Object> map){
		return stockDao.list(map);
	}
	
	@Override
	public List<Map<String, Object>> findDatas(Map<String, Object> map){
		List<Map<String, Object>> list = stockDao.findDatas(map);
		return list;
	}
	
	@Override
	public int save(StockDO stock){
		return stockDao.save(stock);
	}
	
	@Override
	public int update(StockDO stock){
		return stockDao.update(stock);
	}
	
	@Override
	public int remove(Integer goodsId){
		return stockDao.remove(goodsId);
	}
	
	@Override
	public int batchRemove(Integer[] goodsIds){
		return stockDao.batchRemove(goodsIds);
	}
	
}
