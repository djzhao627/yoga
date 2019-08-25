package com.fc.business.dao;

import com.fc.business.domain.FcMemberManagementBaseinfoDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 会员信息表
 *
 * @author fengchi
 * @email
 * @date 2019-08-19 21:40:52
 */
@Mapper
public interface FcMemberManagementBaseinfoDao {

    FcMemberManagementBaseinfoDO get(Integer id);

    List<FcMemberManagementBaseinfoDO> list(Map<String, Object> map);

    List<Map<String, Object>> findDatas(Map<String, Object> map);

    int save(FcMemberManagementBaseinfoDO fcMemberManagementBaseinfo);

    int update(FcMemberManagementBaseinfoDO fcMemberManagementBaseinfo);

    int remove(Integer id);

    int batchRemove(Integer[] ids);
}
