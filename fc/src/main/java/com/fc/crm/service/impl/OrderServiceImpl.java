package com.fc.crm.service.impl;

import com.fc.business.service.MemberBaseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.fc.crm.dao.OrderDao;
import com.fc.crm.domain.OrderDO;
import com.fc.crm.service.OrderService;
import com.github.pagehelper.PageHelper;
import com.fc.common.utils.PageUtils;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderDao orderDao;
	@Autowired
	private MemberBaseInfoService memberBaseInfoService;
	
	@Override
	public OrderDO get(Integer id){
		return orderDao.get(id);
	}
	
	@Override
	public List<OrderDO> list(Map<String, Object> map){
		Map<String, String> yesMap = memberBaseInfoService.queryNameByCode("yes_no");
		Map<String, String> payTypeMap = memberBaseInfoService.queryNameByCode("payment_type");
		Map<String, String> payModeMap = memberBaseInfoService.queryNameByCode("payment_mode");
		Map<String, String> sendMap = memberBaseInfoService.queryNameByCode("send_type");
		Map<String, String> campusMap = memberBaseInfoService.queryNameByCode("schedule_campus");
		Map<String, String> courseMap = memberBaseInfoService.queryNameByCode("consultingCourse_type");
		List<OrderDO> list = orderDao.list(map);
		list.forEach(p->{
			p.setInitialTraining(p.getInitialTraining()==null?p.getInitialTraining():yesMap.get(p.getInitialTraining()));
			p.setPaymentType(p.getPaymentType()==null?p.getPaymentType():payTypeMap.get(p.getPaymentType()));
			p.setPaymentMode(p.getPaymentMode()==null?p.getPaymentMode():payModeMap.get(p.getPaymentMode()));
			p.setBook(p.getBook()==null?p.getBook():sendMap.get(p.getBook()));
			p.setClothes(p.getClothes()==null?p.getClothes():sendMap.get(p.getClothes()));
			p.setScheduleCampus(p.getScheduleCampus()==null?p.getScheduleCampus():campusMap.get(p.getScheduleCampus()));
			p.setEnrollmentCourse(p.getEnrollmentCourse()==null?p.getEnrollmentCourse():courseMap.get(p.getEnrollmentCourse()));
		});
		return list;
	}
	
	@Override
	public List<Map<String, Object>> findDatas(Map<String, Object> map){
		List<Map<String, Object>> list = orderDao.findDatas(map);
		return list;
	}
	
	@Override
	public int save(OrderDO order){
		return orderDao.save(order);
	}
	
	@Override
	public int update(OrderDO order){
		return orderDao.update(order);
	}
	
	@Override
	public int remove(Integer id){
		return orderDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return orderDao.batchRemove(ids);
	}
	
}
