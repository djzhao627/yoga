package com.fc.crm.domain;

import java.io.Serializable;
import java.util.Date;


/**
 * @author fengchi
 * @email
 * @date 2019-09-05 22:39:01
 */
public class WorkPlanFollowUpDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    private Integer id;
    //工作计划ID
    private String workPlanId;
    //根据情况内容
    private String followUp;
    //任务附件名，使用“??”（两个英文的问号）隔开
    private String taskAnnex;
    /**
     * 任务附件名，使用“??”（两个英文的问号）隔开,
     * 使用相对路径
     * ~~/a/b/c.txt
     */
    private String taskAnnexPath;
    //执行情况附件名，使用“??”（两个英文的问号）隔开
    private String executeAnnex;
    //执行情况附件名，使用“??”（两个英文的问号）隔开,
    private String executeAnnexPath;
    //创建时间
    private String createTime;
    //创建人ID
    private Integer createAuthor;
    //最后更改时间
    private String lastModifyTime;
    //最后更改人ID
    private Integer lastModifyAuthor;

    /**
     * 设置：
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取：
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置：工作计划ID
     */
    public void setWorkPlanId(String workPlanId) {
        this.workPlanId = workPlanId;
    }

    /**
     * 获取：工作计划ID
     */
    public String getWorkPlanId() {
        return workPlanId;
    }

    /**
     * 设置：根据情况内容
     */
    public void setFollowUp(String followUp) {
        this.followUp = followUp;
    }

    /**
     * 获取：根据情况内容
     */
    public String getFollowUp() {
        return followUp;
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
     * 设置：执行情况附件名，使用“??”（两个英文的问号）隔开
     */
    public void setExecuteAnnex(String executeAnnex) {
        this.executeAnnex = executeAnnex;
    }

    /**
     * 获取：执行情况附件名，使用“??”（两个英文的问号）隔开
     */
    public String getExecuteAnnex() {
        return executeAnnex;
    }

    /**
     * 设置：执行情况附件名，使用“??”（两个英文的问号）隔开,
     */
    public void setExecuteAnnexPath(String executeAnnexPath) {
        this.executeAnnexPath = executeAnnexPath;
    }

    /**
     * 获取：执行情况附件名，使用“??”（两个英文的问号）隔开,
     */
    public String getExecuteAnnexPath() {
        return executeAnnexPath;
    }

    /**
     * 设置：创建时间
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取：创建时间
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * 设置：创建人ID
     */
    public void setCreateAuthor(Integer createAuthor) {
        this.createAuthor = createAuthor;
    }

    /**
     * 获取：创建人ID
     */
    public Integer getCreateAuthor() {
        return createAuthor;
    }

    /**
     * 设置：最后更改时间
     */
    public void setLastModifyTime(String lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }

    /**
     * 获取：最后更改时间
     */
    public String getLastModifyTime() {
        return lastModifyTime;
    }

    /**
     * 设置：最后更改人ID
     */
    public void setLastModifyAuthor(Integer lastModifyAuthor) {
        this.lastModifyAuthor = lastModifyAuthor;
    }

    /**
     * 获取：最后更改人ID
     */
    public Integer getLastModifyAuthor() {
        return lastModifyAuthor;
    }
}
