package com.fc.crm.dao;

import com.fc.crm.domain.MemberDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 会员信息表
 * @author fengchi
 * @email 
 * @date 2019-08-19 21:40:52
 */
@Mapper
public interface MemberDao {

	MemberDO get(Integer id);
	
	List<MemberDO> list(Map<String, Object> map);
	
	List<Map<String, Object>> findDatas(Map<String, Object> map);
	
	int save(MemberDO member);
	
	int update(MemberDO member);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);

    List<Map<String, String>> queryNameByCode(@Param("code") String code);

    void updateData(MemberDO memberBaseInfoDO);
}
