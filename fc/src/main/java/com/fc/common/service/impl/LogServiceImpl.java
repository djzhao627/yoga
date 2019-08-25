package com.fc.common.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.fc.common.dao.LogDao;
import com.fc.common.domain.LogDO;
import com.fc.common.domain.PageDO;
import com.fc.common.service.LogService;
import com.fc.common.utils.Query;

@Service
public class LogServiceImpl implements LogService {
	@Autowired
	LogDao logMapper;

	@Async
	@Override
	public void save(LogDO logDO) {
		 logMapper.save(logDO);
	}

	@Override
	public List<LogDO> queryList(Query query) {
		//int total = logMapper.count(query);
		List<LogDO> logs = logMapper.list(query);
		/*PageDO<LogDO> page = new PageDO<>();
		page.setTotal(total);
		page.setRows(logs);*/
		return logs;
	}

	@Override
	public int remove(Long id) {
		int count = logMapper.remove(id);
		return count;
	}

	@Override
	public int batchRemove(Long[] ids){
		return logMapper.batchRemove(ids);
	}
}
