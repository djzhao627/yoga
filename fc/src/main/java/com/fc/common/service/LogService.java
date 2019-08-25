package com.fc.common.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fc.common.domain.LogDO;
import com.fc.common.domain.PageDO;
import com.fc.common.utils.Query;
@Service
public interface LogService {
	void save(LogDO logDO);
	List<LogDO> queryList(Query query);
	int remove(Long id);
	int batchRemove(Long[] ids);
}
