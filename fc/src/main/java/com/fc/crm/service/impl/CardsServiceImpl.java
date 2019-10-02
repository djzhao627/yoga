package com.fc.crm.service.impl;

import com.fc.crm.dao.MemberDao;
import com.fc.crm.domain.MemberDO;
import com.fc.crm.vo.CardsVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.fc.crm.dao.CardsDao;
import com.fc.crm.domain.CardsDO;
import com.fc.crm.service.CardsService;
import com.github.pagehelper.PageHelper;
import com.fc.common.utils.PageUtils;

@Service
public class CardsServiceImpl implements CardsService {
	@Autowired
	private CardsDao cardsDao;
	@Autowired
	private MemberDao memberDao;
	
	@Override
	public CardsVO get(Integer id){
		CardsDO cardsDO = cardsDao.get(id);
		CardsVO cardsVO = new CardsVO();
		BeanUtils.copyProperties(cardsDO,cardsVO);
		MemberDO memberDO = memberDao.get(cardsDO.getMemberId());
		cardsVO.setMemberName(memberDO.getName());
		return cardsVO;
	}
	
	@Override
	public List<CardsDO> list(Map<String, Object> map){
		return cardsDao.list(map);
	}
	
	@Override
	public List<Map<String, Object>> findDataList(Map<String, Object> map){
		List<Map<String, Object>> list = cardsDao.findDataList(map);
		return list;
	}
	
	@Override
	public int save(CardsDO cards){
		return cardsDao.save(cards);
	}
	
	@Override
	public int update(CardsDO cards){
		return cardsDao.update(cards);
	}
	
	@Override
	public int remove(Integer id){
		return cardsDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return cardsDao.batchRemove(ids);
	}
	
}
