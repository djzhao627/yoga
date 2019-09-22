package com.fc.crm.vo;

public class CurriculumVO {
    //
    private Integer id;
    //课程id
    private Integer courseId;
    //教练id
    private Integer memberId;
    //教室id
    private Integer classroomId;
    //开始日期
    private String startDate;
    //结束日期
    private String endDate;
    //开始时间
    private String startTime;
    //结束时间
    private String endTime;
    //最小开课人数
    private Integer minNum;
    //最大开课人数
    private Integer maxMun;
    //课程表状态
    private String status;
    //学员ids
    private String ids;
    //学员names
    private String members;

    public String getMembers() {
        return members;
    }

    public void setMembers(String members) {
        this.members = members;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public Integer getClassroomId() {
        return classroomId;
    }

    public void setClassroomId(Integer classroomId) {
        this.classroomId = classroomId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Integer getMinNum() {
        return minNum;
    }

    public void setMinNum(Integer minNum) {
        this.minNum = minNum;
    }

    public Integer getMaxMun() {
        return maxMun;
    }

    public void setMaxMun(Integer maxMun) {
        this.maxMun = maxMun;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }
}
