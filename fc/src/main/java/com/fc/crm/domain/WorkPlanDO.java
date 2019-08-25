package com.fc.crm.domain;

import com.fc.crm.bases.dao.BaseDao;

import java.io.Serializable;
import java.util.Date;


/**
 * @author fengchi
 * @email
 * @date 2019-08-24 18:23:38
 */
public class WorkPlanDO extends BaseDao implements Serializable {
    private static final long serialVersionUID = 1L;

    //主键
    private Integer id;
    //交办事项
    private String content;
    //部门Id
    private String deptId;
    //部门名称
    private String deptName;
    //开始时间
    private Date startTime;
    //结束时间
    private Date endTime;
    //责任人
    private String personLiable;
    //协助人
    private String helper;
    //备注
    private String remarks;
    //提醒方式，任务开始后，每天提醒？还是如何提醒
    private String remindType;

    /**
     * 设置：主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取：主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 交办事项
     * @return
     */
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
     * 设置：开始时间
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * 获取：开始时间
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * 设置：结束时间
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * 获取：结束时间
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * 设置：责任人
     */
    public void setPersonLiable(String personLiable) {
        this.personLiable = personLiable;
    }

    /**
     * 获取：责任人
     */
    public String getPersonLiable() {
        return personLiable;
    }

    /**
     * 设置：协助人
     */
    public void setHelper(String helper) {
        this.helper = helper;
    }

    /**
     * 获取：协助人
     */
    public String getHelper() {
        return helper;
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
     * 获取：提醒方式，任务开始后，每天提醒？好事如何提醒
     */
    public String getRemindType() {
        return remindType;
    }
}
