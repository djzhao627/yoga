package com.fc.crm.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author fengchi
 * @email 
 * @date 2019-09-17 21:39:22
 */
public class CampaignDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//活动名称
	private String activityName;
	//活动内容
	private String activityContent;
	//活动场地
	private String activityAddr;
	//活动开始日期
	private String startDate;
	//活动结束日期
	private String endDate;
	//报名人员
	private String activityEnrollees;
	//状态
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
	 * 设置：活动名称
	 */
	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}
	/**
	 * 获取：活动名称
	 */
	public String getActivityName() {
		return activityName;
	}
	/**
	 * 设置：活动内容
	 */
	public void setActivityContent(String activityContent) {
		this.activityContent = activityContent;
	}
	/**
	 * 获取：活动内容
	 */
	public String getActivityContent() {
		return activityContent;
	}
	/**
	 * 设置：活动场地
	 */
	public void setActivityAddr(String activityAddr) {
		this.activityAddr = activityAddr;
	}
	/**
	 * 获取：活动场地
	 */
	public String getActivityAddr() {
		return activityAddr;
	}
	/**
	 * 设置：活动开始日期
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	/**
	 * 获取：活动开始日期
	 */
	public String getStartDate() {
		return startDate;
	}
	/**
	 * 设置：活动结束日期
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	/**
	 * 获取：活动结束日期
	 */
	public String getEndDate() {
		return endDate;
	}
	/**
	 * 设置：报名人员
	 */
	public void setActivityEnrollees(String activityEnrollees) {
		this.activityEnrollees = activityEnrollees;
	}
	/**
	 * 获取：报名人员
	 */
	public String getActivityEnrollees() {
		return activityEnrollees;
	}
	/**
	 * 设置：状态
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 获取：状态
	 */
	public String getStatus() {
		return status;
	}
}
