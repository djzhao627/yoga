package com.fc.oa.service;

import com.fc.common.utils.PageUtils;
import com.fc.oa.domain.NotifyDO;
import com.fc.oa.domain.NotifyDTO;

import java.util.List;
import java.util.Map;

/**
 * 通知通告
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2017-10-05 17:11:16
 */
public interface NotifyService {

	NotifyDO get(Long id);

	List<NotifyDO> list(Map<String, Object> map);

	int count(Map<String, Object> map);

	int save(NotifyDO notify);

	int update(NotifyDO notify);

	int remove(Long id);

	int batchRemove(Long[] ids);

//	Map<String, Object> message(Long userId);

	List<NotifyDTO> selfList(Map<String, Object> map);

	void saveNotify(List<Long> userIds, Long notifyId);
}
