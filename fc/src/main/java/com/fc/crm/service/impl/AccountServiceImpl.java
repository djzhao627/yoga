package com.fc.crm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.fc.crm.dao.AccountDao;
import com.fc.crm.domain.AccountDO;
import com.fc.crm.service.AccountService;
import com.github.pagehelper.PageHelper;
import com.fc.common.utils.PageUtils;

@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	private AccountDao accountDao;
	
	@Override
	public AccountDO get(Integer id){
		return accountDao.get(id);
	}
	
	@Override
	public List<AccountDO> list(Map<String, Object> map){
		return accountDao.list(map);
	}
	
	@Override
	public List<Map<String, Object>> findDataList(Map<String, Object> map){
		List<Map<String, Object>> list = accountDao.findDataList(map);
		return list;
	}
	
	@Override
	public int save(AccountDO account){
		return accountDao.save(account);
	}
	
	@Override
	public int update(AccountDO account){
		return accountDao.update(account);
	}
	
	@Override
	public int remove(Integer id){
		return accountDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return accountDao.batchRemove(ids);
	}
	
}
