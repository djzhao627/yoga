package com.fc.crm.scheduled;

import com.fc.crm.domain.WorkPlanDO;
import com.fc.crm.service.WorkPlanService;
import com.fc.oa.dao.NotifyRecordDao;
import com.fc.oa.domain.NotifyRecordDO;
import com.fc.oa.service.NotifyService;
import com.fc.system.domain.UserDO;
import com.fc.system.service.SessionService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Component
@Configuration      //1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling   // 2.开启定时任务
public class WorkPlanDynamicScheduleTask implements SchedulingConfigurer {

    @Autowired
    private SimpMessagingTemplate template;

    @Autowired
    private WorkPlanService workPlanService;

    @Autowired
    private SessionService sessionService;

    @Autowired
    private NotifyService notifyService;

    /**
     * 执行定时任务.
     */
    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.addTriggerTask(
                //1.添加任务内容(Runnable)
                () -> {

                    List<WorkPlanDO> WorkPlanDOList = workPlanService.list(null);
                    addRecordOfWorkPlan(WorkPlanDOList);
                    ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>());
                    executor.execute(new Runnable() {
                        @Override
                        public void run() {
                            for (UserDO userDO : sessionService.listOnlineUser()) {
                                for (WorkPlanDO workPlanDO : WorkPlanDOList) {
                                    if (workPlanDO.getPersonLiable().equals(userDO.getUserId()+"")) {
                                        template.convertAndSendToUser(userDO.toString(), "/queue/notifications", "新消息：工作计划（责任人）");
                                    }
                                    /*if (workPlanDO.getHelper().equals(userDO.getUserId()+"")) {
                                        template.convertAndSendToUser(userDO.toString(), "/queue/notifications", "新消息：工作计划（协助人）");
                                    }*/
                                }
                            }
                        }
                    });
                    executor.shutdown();

                },
                //2.设置执行周期(Trigger)
                triggerContext -> {
                    //2.1 从数据库获取执行周期
                    //String cron = "0/5 * 1 * * ?";
//                    String cron = "0 0/1 * * * ?";
                    String cron = "0/10 * * * * ?";
                    //2.2 合法性校验.
                    if (StringUtils.isEmpty(cron)) {
                        // Omitted Code ..
                    }
                    //2.3 返回执行周期(Date)
                    return new CronTrigger(cron).nextExecutionTime(triggerContext);
                }
        );
    }

    private void addRecordOfWorkPlan(List<WorkPlanDO> WorkPlanDOList) {
        List<Long> userList = new ArrayList<>();
        for (WorkPlanDO workPlanDO : WorkPlanDOList) {
            userList.add(Long.parseLong(workPlanDO.getPersonLiable()));
        }
        notifyService.saveNotify(userList,1L);
    }
}
