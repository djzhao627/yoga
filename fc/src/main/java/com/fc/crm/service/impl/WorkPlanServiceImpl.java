package com.fc.crm.service.impl;

import com.fc.common.utils.ShiroUtils;
import com.fc.oa.domain.NotifyDO;
import com.fc.oa.service.NotifyService;
import com.fc.system.domain.UserDO;
import com.fc.system.service.SessionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fc.crm.dao.WorkPlanDao;
import com.fc.crm.domain.WorkPlanDO;
import com.fc.crm.service.WorkPlanService;

@Service
public class WorkPlanServiceImpl implements WorkPlanService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private WorkPlanDao workPlanDao;

    @Autowired
    private NotifyService notifyService;

    @Autowired
    private SimpMessagingTemplate template;

    @Autowired
    private SessionService sessionService;

    @Override
    public WorkPlanDO get(String id) {
        return workPlanDao.get(id);
    }

    @Override
    public List<WorkPlanDO> list(Map<String, Object> map) {
        return workPlanDao.list(map);
    }

    @Override
    public List<Map<String, Object>> findDataList(Map<String, Object> map) {
        List<Map<String, Object>> list = workPlanDao.findDataList(map);
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
            try {
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
                        List<WorkPlanDO> workPlanDOList = new ArrayList<>();
                        workPlanDOList.add(workPlan);
                        runWorPlanSendToUser(workPlanDOList);
                    }
                    successSum += success;
                }
            } catch (Exception e){
                logger.error(e.getMessage());
            }
        }
        return successSum;
    }

    private void runWorPlanSendToUser(List<WorkPlanDO> workPlanDOList) {
        for (UserDO userDO : sessionService.listOnlineUser()) {
            for (WorkPlanDO workPlanDO : workPlanDOList) {
                if (workPlanDO.getPersonLiableId() != null && workPlanDO.getPersonLiableId().equals(userDO.getUserId())) {
                    template.convertAndSendToUser(userDO.toString(), "/queue/notifications", "新消息：工作计划（责任人）");
                }
                if (workPlanDO.getHelperId() != null && workPlanDO.getHelperId().equals(userDO.getUserId())) {
                    template.convertAndSendToUser(userDO.toString(), "/queue/notifications", "新消息：工作计划（协助人）");
                }
            }
        }
    }
}
