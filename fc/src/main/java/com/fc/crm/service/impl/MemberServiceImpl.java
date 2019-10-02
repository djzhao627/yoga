package com.fc.crm.service.impl;

import com.fc.business.service.MemberBaseInfoService;
import com.fc.common.utils.ShiroUtils;
import com.fc.crm.dao.MemberDao;
import com.fc.crm.domain.MemberDO;
import com.fc.crm.service.MemberService;
import com.fc.system.domain.UserDO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDao memberDao;
	
	@Override
	public MemberDO get(Integer id){
		MemberDO memberDO = memberDao.get(id);
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
		return memberDO;
	}
	
	@Override
	public List<MemberDO> list(Map<String, Object> map){
		List<MemberDO> list = memberDao.list(map);
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
		List<Map<String, Object>> list = memberDao.findDatas(map);
		return list;
	}
	
	@Override
	public int save(MemberDO member){

		UserDO user = ShiroUtils.getUser();
		Long userId = ShiroUtils.getUserId();
		member.setDeptId(member.getDeptId().split(",")[0]);
		return memberDao.save(member);
	}
	
	@Override
	public int update(MemberDO member){

		return memberDao.update(member);
	}
	
	@Override
	public int remove(Integer id){
		return memberDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return memberDao.batchRemove(ids);
	}

	public Map<String,String> queryNameByCode(String code){
		List<Map<String,String>> list= memberDao.queryNameByCode(code);
		Map<String,String> map=new HashMap<>();
		list.forEach(p->{
			map.put(p.get("value"),p.get("name"));
		});
		return map;
	}
}
