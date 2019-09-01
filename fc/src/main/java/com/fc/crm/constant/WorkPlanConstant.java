package com.fc.crm.constant;

/**
 * 工作计划常量
 *
 * @author fengchi
 * @email
 * @date 2019-08-26 22:59:56
 */
public class WorkPlanConstant {

    /**
     *
     */
    public static final String id = "id";
    /**
     * 交办事项
     */
    public static final String content = "content";
    /**
     * 部门Id
     */
    public static final String deptId = "deptId";
    /**
     * 部门名称
     */
    public static final String deptName = "deptName";
    /**
     *
     */
    public static final String startTime = "startTime";
    /**
     * 结束时间
     */
    public static final String endTime = "endTime";
    /**
     * 完成进度
     */
    public static final String schedule = "schedule";
    /**
     * 责任人ID
     */
    public static final String personLiable = "personLiable";
    /**
     * 责任人名称
     */
    public static final String personLiableName = "personLiableName";
    /**
     * 协助人ID
     */
    public static final String helper = "helper";
    /**
     * 协助人名称
     */
    public static final String helperName = "helperName";
    /**
     * 备注
     */
    public static final String remarks = "remarks";
    /**
     * 提醒方式，任务开始后，每天提醒？还是如何提醒
     */
    public static final String remindType = "remindType";
    /**
     * 状态：0：草稿，1：发布，2：删除
     */
    public static final String state = "state";
    /**
     * 级别，
     1：已完成绿底、
     2：紧急/重要红字、
     3：未完成/需修改黄底、
     4：蓝底为新增/更新
     */
    public static final String level = "level";
    /**
     * 任务附件名，使用“??”（两个英文的问号）隔开
     */
    public static final String taskAnnex = "taskAnnex";
    /**
     * 任务附件名，使用“??”（两个英文的问号）隔开,
     使用相对路径
     ~~/a/b/c.txt
     */
    public static final String taskAnnexPath = "taskAnnexPath";
    /**
     * 任务附件名，使用“??”（两个英文的问号）隔开
     */
    public static final String executeAnnex = "executeAnnex";
    /**
     * 任务附件名，使用“??”（两个英文的问号）隔开,
     */
    public static final String executeAnnexPath = "executeAnnexPath";

}
