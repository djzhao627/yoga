package com.fc.crm.service.impl;

import com.fc.common.utils.ShiroUtils;
import com.fc.oa.domain.NotifyDO;
import com.fc.oa.service.NotifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fc.crm.dao.WorkPlanDao;
import com.fc.crm.domain.WorkPlanDO;
import com.fc.crm.service.WorkPlanService;

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
        workPlan.setState("0");
        return workPlanDao.save(workPlan);
    }

    @Override
    public int update(WorkPlanDO workPlan) {
        return workPlanDao.update(workPlan);
    }

    @Override
    public int remove(String id) {
        WorkPlanDO workPlan = workPlanDao.get(id);
        if (workPlan != null && "0".equals(workPlan.getState())) {
            return workPlanDao.remove(id);
        } else {
            // 不可以删除
        }
        return 0;
    }

    @Override
    public int batchRemove(String[] ids) {
        return workPlanDao.batchRemove(ids);
    }

    @Override
    public int publicWorkPlan(String[] ids) {

        int successSum = 0;
        for (String id : ids) {
            WorkPlanDO workPlanDO = new WorkPlanDO();
            workPlanDO.setState("1");
            workPlanDO.setId(id);
            int success = workPlanDao.update(workPlanDO);
            if (success > 0) {
                WorkPlanDO workPlan = workPlanDao.get(id);
                if (workPlan != null) {
                    NotifyDO notify = new NotifyDO();
                    notify.setType("1");
                    notify.setContent(workPlan.getContent());
                    notify.setTitle("工作计划");
                    List<Long> userIdList = new ArrayList<>();
                    if (workPlan.getPersonLiableId() != null) {
                        userIdList.add(workPlan.getPersonLiableId());
                    }
                    if (workPlan.getHelperId() != null) {
                        userIdList.add(workPlan.getHelperId());
                    }
                    notify.setUserIds(userIdList);
                    notify.setCreateBy(ShiroUtils.getUserId());
                    notifyService.save(notify);
                }
                successSum += success;
            }
        }
        return successSum;
    }

}
