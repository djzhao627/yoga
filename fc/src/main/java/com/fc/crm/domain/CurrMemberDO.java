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
public class CurrMemberDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//课程表id
	private Integer curriculumId;
	//学员id（会员id）
	private Integer memberId;
	//
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
	 * 设置：课程表id
	 */
	public void setCurriculumId(Integer curriculumId) {
		this.curriculumId = curriculumId;
	}
	/**
	 * 获取：课程表id
	 */
	public Integer getCurriculumId() {
		return curriculumId;
	}
	/**
	 * 设置：学员id（会员id）
	 */
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}
	/**
	 * 获取：学员id（会员id）
	 */
	public Integer getMemberId() {
		return memberId;
	}
	/**
	 * 设置：
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 获取：
	 */
	public String getStatus() {
		return status;
	}
}
