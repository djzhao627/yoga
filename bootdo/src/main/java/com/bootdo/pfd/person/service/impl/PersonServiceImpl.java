package com.bootdo.pfd.person.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.pfd.person.dao.PersonDao;
import com.bootdo.pfd.person.domain.PersonDO;
import com.bootdo.pfd.person.service.PersonService;



@Service
public class PersonServiceImpl implements PersonService {
	@Autowired
	private PersonDao personDao;
	
	@Override
	public PersonDO get(String id){
		return personDao.get(id);
	}
	
	@Override
	public List<PersonDO> list(Map<String, Object> map){
		return personDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return personDao.count(map);
	}
	
	@Override
	public int save(PersonDO person){
		return personDao.save(person);
	}
	
	@Override
	public int update(PersonDO person){
		return personDao.update(person);
	}
	
	@Override
	public int remove(String id){
		return personDao.remove(id);
	}
	
	@Override
	public int batchRemove(String[] ids){
		return personDao.batchRemove(ids);
	}
	
}
