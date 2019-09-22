package com.fc.business.service.impl;

import com.fc.common.utils.ShiroUtils;
import com.fc.system.domain.UserDO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fc.business.dao.MemberBaseInfoDao;
import com.fc.business.domain.MemberBaseInfoDO;
import com.fc.business.service.MemberBaseInfoService;

@Service
public class MemberBaseInfoServiceImpl implements MemberBaseInfoService {
	@Autowired
	private MemberBaseInfoDao memberBaseInfoDao;
	
	@Override
	public MemberBaseInfoDO get(Integer id){
		MemberBaseInfoDO memberBaseInfoDO = memberBaseInfoDao.get(id);
//		String type = memberBaseInfoDO.getType();
//		Map<String,String> mapCode=queryNameByCode("custom_type");
//		if (type.contains(",")) {
//			String[] types = type.split(",");
//			String temp="";
//			for (int i = 0; i < types.length; i++) {
//				temp+=mapCode.get(types[i])+",";
//			}
//			memberBaseInfoDO.setType(temp.substring(0,temp.lastIndexOf(",")));
//		}
		return memberBaseInfoDO;
	}
	
	@Override
	public List<MemberBaseInfoDO> list(Map<String, Object> map){
		List<MemberBaseInfoDO> list = memberBaseInfoDao.list(map);
		Map<String,String> mapCode=queryNameByCode("custom_type");
		Map<String,String> courseMap=queryNameByCode("consultingCourse_type");
		Map<String,String> yesMap=queryNameByCode("yes_no");
		Map<String,String> dataMap=queryNameByCode("dataSource_type");
		list.forEach(p->{
			p.setType(mapCode.get(p.getType()));
			String course = p.getConsultingCourse();
			if (StringUtils.isNotBlank(course)) {
				String temp="";
				for (int i = 0; i <course.split(",").length ; i++) {
					temp+=courseMap.get(course.split(",")[i])+",";
				}
				p.setConsultingCourse(temp.substring(0,temp.lastIndexOf(",")));
			}
			p.setAccommodation(yesMap.get(p.getAccommodation()));
			p.setDataSource(dataMap.get(p.getDataSource()));
		});
		return list;
	}
	
	@Override
	public List<Map<String, Object>> findDatas(Map<String, Object> map){
		List<Map<String, Object>> list = memberBaseInfoDao.findDatas(map);
		return list;
	}
	
	@Override
	public int save(MemberBaseInfoDO fcMemberManagementBaseinfo){

		UserDO user = ShiroUtils.getUser();
		Long userId = ShiroUtils.getUserId();
		fcMemberManagementBaseinfo.setDeptId(fcMemberManagementBaseinfo.getDeptId().split(",")[0]);
		return memberBaseInfoDao.save(fcMemberManagementBaseinfo);
	}
	
	@Override
	public int update(MemberBaseInfoDO memberBaseInfo){

		return memberBaseInfoDao.update(memberBaseInfo);
	}
	
	@Override
	public int remove(Integer id){
		return memberBaseInfoDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return memberBaseInfoDao.batchRemove(ids);
	}

	public Map<String,String> queryNameByCode(String code){
		List<Map<String,String>> list= memberBaseInfoDao.queryNameByCode(code);
		Map<String,String> map=new HashMap<>();
		list.forEach(p->{
			map.put(p.get("value"),p.get("name"));
		});
		return map;
	}
}
