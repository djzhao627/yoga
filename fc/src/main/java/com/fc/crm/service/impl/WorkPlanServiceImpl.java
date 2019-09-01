package com.fc.crm.service.impl;

import com.fc.common.utils.ShiroUtils;
import com.fc.oa.domain.NotifyDO;
import com.fc.oa.service.NotifyService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fc.crm.dao.WorkPlanDao;
import com.fc.crm.domain.WorkPlanDO;
import com.fc.crm.service.WorkPlanService;
import com.github.pagehelper.PageHelper;
import com.fc.common.utils.PageUtils;

@Service
public class WorkPlanServiceImpl implements WorkPlanService {

    @Autowired
    private WorkPlanDao workPlanDao;

    @Autowired
    private NotifyService notifyService;

    @Override
    public WorkPlanDO get(String id) {
        return workPlanDao.get(id);
    }

    @Override
    public List<WorkPlanDO> list(Map<String, Object> map) {
        return workPlanDao.list(map);
    }

    @Override
    public List<Map<String, Object>> findDatas(Map<String, Object> map) {
        List<Map<String, Object>> list = workPlanDao.findDatas(map);
        return list;
    }

    @Override
    public int save(WorkPlanDO workPlan) {
        if (workPlan != null) {
            NotifyDO notify = new NotifyDO();
            notify.setType("1");
            notify.setContent(workPlan.getContent());
            notify.setTitle("工作计划");
            List<Long> userIdList = new ArrayList<>();
            if (StringUtils.isNotEmpty(workPlan.getPersonLiable())) {
                userIdList.add(Long.parseLong(workPlan.getPersonLiable()));
            }
            if (StringUtils.isNotEmpty(workPlan.getHelper())) {
                userIdList.add(Long.parseLong(workPlan.getHelper()));
            }
            notify.setUserIds(userIdList);
            notify.setCreateBy(ShiroUtils.getUserId());
            notifyService.save(notify);
        }
        return workPlanDao.save(workPlan);
    }

    @Override
    public int update(WorkPlanDO workPlan) {
        return workPlanDao.update(workPlan);
    }

    @Override
    public int remove(String id) {
        return workPlanDao.remove(id);
    }

    @Override
    public int batchRemove(String[] ids) {
        return workPlanDao.batchRemove(ids);
    }

}
