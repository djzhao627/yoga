package com.fc.business.dao;

import com.fc.business.domain.MemberBaseInfoDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 会员信息表
 * @author fengchi
 * @email 
 * @date 2019-08-19 21:40:52
 */
@Mapper
public interface MemberBaseInfoDao {

	MemberBaseInfoDO get(Integer id);
	
	List<MemberBaseInfoDO> list(Map<String, Object> map);
	
	List<Map<String, Object>> findDatas(Map<String, Object> map);
	
	int save(MemberBaseInfoDO fcMemberManagementBaseinfo);
	
	int update(MemberBaseInfoDO fcMemberManagementBaseinfo);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);

    List<Map<String, String>> queryNameByCode(@Param("code") String code);

    void updateData(MemberBaseInfoDO memberBaseInfoDO);
}
