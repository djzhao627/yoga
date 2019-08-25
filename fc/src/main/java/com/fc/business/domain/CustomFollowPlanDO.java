package com.fc.business.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author fengchi
 * @email 
 * @date 2019-08-23 22:38:51
 */
public class CustomFollowPlanDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//客户id
	private String customId;
	//沟通时间
	private String talkDate;
	//沟通记录或计划
	private String recordOrPlan;
	//插入时间
	private Date insertTime;
	//插入操作人
	private Integer insertOperator;
	//更新时间
	private Date updateTime;
	//更新操作人
	private Integer updateOperator;

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
	 * 设置：客户id
	 */
	public void setCustomId(String customId) {
		this.customId = customId;
	}
	/**
	 * 获取：客户id
	 */
	public String getCustomId() {
		return customId;
	}
	/**
	 * 设置：沟通时间
	 */
	public void setTalkDate(String talkDate) {
		this.talkDate = talkDate;
	}
	/**
	 * 获取：沟通时间
	 */
	public String getTalkDate() {
		return talkDate;
	}
	/**
	 * 设置：沟通记录或计划
	 */
	public void setRecordOrPlan(String recordOrPlan) {
		this.recordOrPlan = recordOrPlan;
	}
	/**
	 * 获取：沟通记录或计划
	 */
	public String getRecordOrPlan() {
		return recordOrPlan;
	}
	/**
	 * 设置：插入时间
	 */
	public void setInsertTime(Date insertTime) {
		this.insertTime = insertTime;
	}
	/**
	 * 获取：插入时间
	 */
	public Date getInsertTime() {
		return insertTime;
	}
	/**
	 * 设置：插入操作人
	 */
	public void setInsertOperator(Integer insertOperator) {
		this.insertOperator = insertOperator;
	}
	/**
	 * 获取：插入操作人
	 */
	public Integer getInsertOperator() {
		return insertOperator;
	}
	/**
	 * 设置：更新时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：更新时间
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
	/**
	 * 设置：更新操作人
	 */
	public void setUpdateOperator(Integer updateOperator) {
		this.updateOperator = updateOperator;
	}
	/**
	 * 获取：更新操作人
	 */
	public Integer getUpdateOperator() {
		return updateOperator;
	}
}
