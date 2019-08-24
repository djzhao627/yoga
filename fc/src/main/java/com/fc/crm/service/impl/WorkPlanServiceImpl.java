package com.fc.crm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public WorkPlanDO get(Integer id) {
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
        return workPlanDao.save(workPlan);
    }

    @Override
    public int update(WorkPlanDO workPlan) {
        return workPlanDao.update(workPlan);
    }

    @Override
    public int remove(Integer id) {
        return workPlanDao.remove(id);
    }

    @Override
    public int batchRemove(Integer[] ids) {
        return workPlanDao.batchRemove(ids);
    }

}
