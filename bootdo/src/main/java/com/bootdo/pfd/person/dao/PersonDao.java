package com.bootdo.pfd.person.dao;

import com.bootdo.pfd.person.domain.PersonDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-09-26 20:31:21
 */
@Mapper
public interface PersonDao {

	PersonDO get(String id);
	
	List<PersonDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(PersonDO person);
	
	int update(PersonDO person);
	
	int remove(String ID);
	
	int batchRemove(String[] ids);
}
