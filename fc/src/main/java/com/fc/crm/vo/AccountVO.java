package com.fc.crm.vo;

import java.io.Serializable;


/**
 * 
 * 
 * @author fengchi
 * @email 
 * @date 2019-09-28 21:47:46
 */
public class AccountVO  {

	//
	private Integer id;
	//会员id
	private Integer memberId;
	//会员名称
	private String memberName;
	//金额
	private Float account;
	//金额类型
	private String accountType;
	//积分
	private String points;
	//开始时间
	private String startTime;
	//结束时间
	private String endTime;
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
	 * 设置：会员id
	 */
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}
	/**
	 * 获取：会员id
	 */
	public Integer getMemberId() {
		return memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	/**
	 * 设置：金额
	 */
	public void setAccount(Float account) {
		this.account = account;
	}
	/**
	 * 获取：金额
	 */
	public Float getAccount() {
		return account;
	}
	/**
	 * 设置：金额类型
	 */
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	/**
	 * 获取：金额类型
	 */
	public String getAccountType() {
		return accountType;
	}
	/**
	 * 设置：积分
	 */
	public void setPoints(String points) {
		this.points = points;
	}
	/**
	 * 获取：积分
	 */
	public String getPoints() {
		return points;
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
