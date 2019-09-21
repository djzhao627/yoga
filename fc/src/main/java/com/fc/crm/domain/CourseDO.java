package com.fc.crm.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author fengchi
 * @email 
 * @date 2019-09-17 21:39:23
 */
public class CourseDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//门店id
	private String deptId;
	//课程名称
	private String courseName;
	//单价
	private Integer price;
	//课程描述
	private String courseDetail;
	//课程类型
	private String courseType;
	//课时
	private Integer lessonPeriod;
	//成本价
	private Integer costPrice;

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
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	/**
	 * 获取：门店id
	 */
	public String getDeptId() {
		return deptId;
	}
	/**
	 * 设置：课程名称
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	/**
	 * 获取：课程名称
	 */
	public String getCourseName() {
		return courseName;
	}
	/**
	 * 设置：单价
	 */
	public void setPrice(Integer price) {
		this.price = price;
	}
	/**
	 * 获取：单价
	 */
	public Integer getPrice() {
		return price;
	}
	/**
	 * 设置：课程描述
	 */
	public void setCourseDetail(String courseDetail) {
		this.courseDetail = courseDetail;
	}
	/**
	 * 获取：课程描述
	 */
	public String getCourseDetail() {
		return courseDetail;
	}
	/**
	 * 设置：课程类型
	 */
	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}
	/**
	 * 获取：课程类型
	 */
	public String getCourseType() {
		return courseType;
	}
	/**
	 * 设置：课时
	 */
	public void setLessonPeriod(Integer lessonPeriod) {
		this.lessonPeriod = lessonPeriod;
	}
	/**
	 * 获取：课时
	 */
	public Integer getLessonPeriod() {
		return lessonPeriod;
	}
	/**
	 * 设置：成本价
	 */
	public void setCostPrice(Integer costPrice) {
		this.costPrice = costPrice;
	}
	/**
	 * 获取：成本价
	 */
	public Integer getCostPrice() {
		return costPrice;
	}
}
