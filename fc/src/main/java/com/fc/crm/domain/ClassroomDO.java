package com.fc.crm.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author fengchi
 * @email 
 * @date 2019-09-22 14:55:12
 */
public class ClassroomDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//门店id
	private Long deptId;
	//教室名称
	private String roomName;
	//最大容纳人数
	private Integer maxNum;
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
	 * 设置：门店id
	 */
	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}
	/**
	 * 获取：门店id
	 */
	public Long getDeptId() {
		return deptId;
	}
	/**
	 * 设置：教室名称
	 */
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	/**
	 * 获取：教室名称
	 */
	public String getRoomName() {
		return roomName;
	}
	/**
	 * 设置：最大容纳人数
	 */
	public void setMaxNum(Integer maxNum) {
		this.maxNum = maxNum;
	}
	/**
	 * 获取：最大容纳人数
	 */
	public Integer getMaxNum() {
		return maxNum;
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
