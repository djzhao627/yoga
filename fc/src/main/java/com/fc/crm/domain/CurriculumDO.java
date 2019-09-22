package com.fc.crm.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author fengchi
 * @email 
 * @date 2019-09-22 14:55:13
 */
public class CurriculumDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
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
	 * 设置：课程id
	 */
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
	/**
	 * 获取：课程id
	 */
	public Integer getCourseId() {
		return courseId;
	}
	/**
	 * 设置：教练id
	 */
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}
	/**
	 * 获取：教练id
	 */
	public Integer getMemberId() {
		return memberId;
	}
	/**
	 * 设置：教室id
	 */
	public void setClassroomId(Integer classroomId) {
		this.classroomId = classroomId;
	}
	/**
	 * 获取：教室id
	 */
	public Integer getClassroomId() {
		return classroomId;
	}
	/**
	 * 设置：开始日期
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	/**
	 * 获取：开始日期
	 */
	public String getStartDate() {
		return startDate;
	}
	/**
	 * 设置：结束日期
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	/**
	 * 获取：结束日期
	 */
	public String getEndDate() {
		return endDate;
	}
	/**
	 * 设置：开始时间
	 */
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	/**
	 * 获取：开始时间
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
	 * 设置：最小开课人数
	 */
	public void setMinNum(Integer minNum) {
		this.minNum = minNum;
	}
	/**
	 * 获取：最小开课人数
	 */
	public Integer getMinNum() {
		return minNum;
	}
	/**
	 * 设置：最大开课人数
	 */
	public void setMaxMun(Integer maxMun) {
		this.maxMun = maxMun;
	}
	/**
	 * 获取：最大开课人数
	 */
	public Integer getMaxMun() {
		return maxMun;
	}
	/**
	 * 设置：课程表状态
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 获取：课程表状态
	 */
	public String getStatus() {
		return status;
	}
}
