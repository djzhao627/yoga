package com.bootdo.pfd.person.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-09-26 20:31:21
 */
public class PersonDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private String id;
	//
	private String name;
	//
	private String gx;
	//
	private String xb;

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
	/**
	 * 设置：
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：
	 */
	public void setGx(String gx) {
		this.gx = gx;
	}
	/**
	 * 获取：
	 */
	public String getGx() {
		return gx;
	}
	/**
	 * 设置：
	 */
	public void setXb(String xb) {
		this.xb = xb;
	}
	/**
	 * 获取：
	 */
	public String getXb() {
		return xb;
	}
}
