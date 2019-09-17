package com.fc.crm.service.impl;

import com.fc.common.utils.ShiroUtils;
import com.fc.crm.dao.StockDao;
import com.fc.crm.domain.StockDO;
import com.fc.crm.service.GoodsService;
import com.fc.crm.vo.GoodsVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fc.crm.dao.GoodsDao;
import com.fc.crm.domain.GoodsDO;
import org.thymeleaf.expression.Arrays;

@Service
public class GoodsServiceImpl implements GoodsService {
	@Autowired
	private GoodsDao goodsDao;
	@Autowired
	private StockDao stockDao;
	
	@Override
	public GoodsVO get(Integer id){
        GoodsDO goodsDO = goodsDao.get(id);
        GoodsVO goodsVO = new GoodsVO();
        BeanUtils.copyProperties(goodsDO,goodsVO);
        StockDO stockDO = stockDao.get(goodsDO.getId());
		if (stockDO != null) {
			goodsVO.setStock(stockDO.getStock());
		}
        return goodsVO;
	}
	
	@Override
	public List<GoodsVO> list(Map<String, Object> map){
		List<GoodsDO> list = goodsDao.list(map);
		List<GoodsVO> voList=new ArrayList<>();
		list.forEach(p->{
			GoodsVO goodsVO = new GoodsVO();
			BeanUtils.copyProperties(p,goodsVO);
			StockDO stockDO = stockDao.get(p.getId());
			if (stockDO != null) {
				goodsVO.setStock(stockDO.getStock());
			}
			voList.add(goodsVO);
		});
		return voList;
	}

	@Override
	public List<Map<String, Object>> findDatas(Map<String, Object> map) {
		List<Map<String, Object>> list = goodsDao.findDatas(map);
		return list;
	}
	
	@Override
	public int save(GoodsVO goods){
		Long deptId = ShiroUtils.getUser().getDeptId();
		StockDO stockDO = new StockDO();
		GoodsDO goodsDO = new GoodsDO();
		BeanUtils.copyProperties(goods,goodsDO);
		goodsDO.setDeptId(String.valueOf(deptId));
		int key = goodsDao.save(goodsDO);
		int i=0;
		if (key>0) {
			stockDO.setGoodsId(key);
			stockDO.setStock(goods.getStock());
			 i = stockDao.save(stockDO);
		}
		return i;
	}
	
	@Override
	public int update(GoodsVO goods){
		StockDO stockDO = new StockDO();
		GoodsDO goodsDO = new GoodsDO();
		BeanUtils.copyProperties(goods,goodsDO);
		int i = goodsDao.update(goodsDO);
		int j=0;
		if (i >0) {
			stockDO.setGoodsId(goods.getId());
			stockDO.setStock(goods.getStock());
			 j = stockDao.update(stockDO);
		}
		return j;
	}
	
	@Override
	public int remove(Integer id){
		int i = goodsDao.remove(id);
		int j=0;
		if (i >0) {
			 j = stockDao.remove(id);
		}
		return j;
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		int i = goodsDao.batchRemove(ids);
		int j=0;
		if (i >0) {
			j = stockDao.batchRemove(ids);
		}
		return j;
	}
	
}
