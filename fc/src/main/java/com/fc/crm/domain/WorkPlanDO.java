package com.fc.crm.domain;

import com.fc.crm.bases.dao.BaseDao;

import java.io.Serializable;


/**
 * 工作计划
 *
 * @author fengchi
 * @email
 * @date 2019-08-26 22:59:56
 */
public class WorkPlanDO extends BaseDao implements Serializable {
    private static final long serialVersionUID = 1L;

    // ID
    private String id;

    //交办事项
    private String content;

    //部门Id
    private String deptId;

    //部门名称
    private String deptName;

    //开始时间
    private String startTime;

    //结束时间
    private String endTime;

    //完成进度
    private String schedule;

    //责任人
    private Long personLiableId;

    //责任人名称
    private String personLiableName;

    //协助人
    private Long helperId;

    //协助人名称
    private String helperName;

    //备注
    private String remarks;

    //提醒方式，任务开始后，每天提醒？还是如何提醒
    private String remindType;

    //状态：0：草稿，1：发布，2：删除
    private String state;
    /**
     * 级别，
     * 1：已完成绿底、
     * 2：紧急/重要红字、
     * 3：未完成/需修改黄底、
     * 4：蓝底为新增/更新
     */
    private String level;

    //任务附件名，使用“??”（两个英文的问号）隔开
    private String taskAnnex;

    /**
     * 任务附件名，使用“??”（两个英文的问号）隔开,
     * 使用相对路径
     * ~~/a/b/c.txt
     */
    private String taskAnnexPath;

    //任务附件名，使用“??”（两个英文的问号）隔开
    private String executeAnnex;
    //任务附件名，使用“??”（两个英文的问号）隔开,
    private String executeAnnexPath;

    public WorkPlanDO() {
        super();
    }

    public WorkPlanDO(String id) {
        this.id = id;
    }

    /**
     * 设置：
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取：
     */
    public String getId() {
        return id;
    }

    public String getPersonLiableName() {
        return personLiableName;
    }

    public void setPersonLiableName(String personLiableName) {
        this.personLiableName = personLiableName;
    }

    public String getHelperName() {
        return helperName;
    }

    public void setHelperName(String helperName) {
        this.helperName = helperName;
    }

    /**
     * 设置：交办事项
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 获取：交办事项
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置：部门Id
     */
    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    /**
     * 获取：部门Id
     */
    public String getDeptId() {
        return deptId;
    }

    /**
     * 设置：部门名称
     */
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    /**
     * 获取：部门名称
     */
    public String getDeptName() {
        return deptName;
    }

    /**
     * 设置：
     */
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    /**
     * 获取：
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * 设置：结束时间
     */
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    /**
     * 获取：结束时间
     */
    public String getEndTime() {
        return endTime;
    }

    /**
     * 设置：完成进度
     */
    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    /**
     * 获取：完成进度
     */
    public String getSchedule() {
        return schedule;
    }

    /**
     * 设置：责任人
     */
    public void setPersonLiableId(Long personLiableId) {
        this.personLiableId = personLiableId;
    }

    /**
     * 获取：责任人
     */
    public Long getPersonLiableId() {
        return personLiableId;
    }

    /**
     * 设置：协助人
     */
    public void setHelperId(Long helperId) {
        this.helperId = helperId;
    }

    /**
     * 获取：协助人
     */
    public Long getHelperId() {
        return helperId;
    }

    /**
     * 设置：备注
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    /**
     * 获取：备注
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 设置：提醒方式，任务开始后，每天提醒？还是如何提醒
     */
    public void setRemindType(String remindType) {
        this.remindType = remindType;
    }

    /**
     * 获取：提醒方式，任务开始后，每天提醒？还是如何提醒
     */
    public String getRemindType() {
        return remindType;
    }

    /**
     * 设置：状态：0：草稿，1：发布，2：删除
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * 获取：状态：0：草稿，1：发布，2：删除
     */
    public String getState() {
        return state;
    }

    /**
     * 设置：级别，
     * 1：已完成绿底、
     * 2：紧急/重要红字、
     * 3：未完成/需修改黄底、
     * 4：蓝底为新增/更新
     */
    public void setLevel(String level) {
        this.level = level;
    }

    /**
     * 获取：级别，
     * 1：已完成绿底、
     * 2：紧急/重要红字、
     * 3：未完成/需修改黄底、
     * 4：蓝底为新增/更新
     */
    public String getLevel() {
        return level;
    }

    /**
     * 设置：任务附件名，使用“??”（两个英文的问号）隔开
     */
    public void setTaskAnnex(String taskAnnex) {
        this.taskAnnex = taskAnnex;
    }

    /**
     * 获取：任务附件名，使用“??”（两个英文的问号）隔开
     */
    public String getTaskAnnex() {
        return taskAnnex;
    }

    /**
     * 设置：任务附件名，使用“??”（两个英文的问号）隔开,
     * 使用相对路径
     * ~~/a/b/c.txt
     */
    public void setTaskAnnexPath(String taskAnnexPath) {
        this.taskAnnexPath = taskAnnexPath;
    }

    /**
     * 获取：任务附件名，使用“??”（两个英文的问号）隔开,
     * 使用相对路径
     * ~~/a/b/c.txt
     */
    public String getTaskAnnexPath() {
        return taskAnnexPath;
    }

    /**
     * 设置：任务附件名，使用“??”（两个英文的问号）隔开
     */
    public void setExecuteAnnex(String executeAnnex) {
        this.executeAnnex = executeAnnex;
    }

    /**
     * 获取：任务附件名，使用“??”（两个英文的问号）隔开
     */
    public String getExecuteAnnex() {
        return executeAnnex;
    }

    /**
     * 设置：任务附件名，使用“??”（两个英文的问号）隔开,
     */
    public void setExecuteAnnexPath(String executeAnnexPath) {
        this.executeAnnexPath = executeAnnexPath;
    }

    /**
     * 获取：任务附件名，使用“??”（两个英文的问号）隔开,
     */
    public String getExecuteAnnexPath() {
        return executeAnnexPath;
    }
}
