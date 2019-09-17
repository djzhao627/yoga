package com.fc.crm.domain;

import java.io.Serializable;



/**
 * 
 * 
 * @author fengchi
 * @email 
 * @date 2019-09-14 15:03:04
 */
public class SomatometricRecordDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//会员id
	private Integer memberId;
	//测量时间
	private String  measureTime;
	//体重
	private Float weight;
	//体脂率
	private Float bodyFatRate;
	//水分率
	private Float moistureDatio;
	//肌肉率
	private Float muscleRate;
	//体型判断
	private String bodyShapeJudgment;
	//代谢年龄
	private String metabolicAge;
	//骨含量
	private Float boneContent;
	//内脂含量
	private Float lactoneContent;
	//体测对比
	private String somatometricComparison;

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
	/**
	 * 设置：测量时间
	 */
	public void setMeasureTime(String  measureTime) {
		this. measureTime =  measureTime;
	}
	/**
	 * 获取：测量时间
	 */
	public String getMeasureTime() {
		return  measureTime;
	}
	/**
	 * 设置：体重
	 */
	public void setWeight(Float weight) {
		this.weight = weight;
	}
	/**
	 * 获取：体重
	 */
	public Float getWeight() {
		return weight;
	}
	/**
	 * 设置：体脂率
	 */
	public void setBodyFatRate(Float bodyFatRate) {
		this.bodyFatRate = bodyFatRate;
	}
	/**
	 * 获取：体脂率
	 */
	public Float getBodyFatRate() {
		return bodyFatRate;
	}
	/**
	 * 设置：水分率
	 */
	public void setMoistureDatio(Float moistureDatio) {
		this.moistureDatio = moistureDatio;
	}
	/**
	 * 获取：水分率
	 */
	public Float getMoistureDatio() {
		return moistureDatio;
	}
	/**
	 * 设置：肌肉率
	 */
	public void setMuscleRate(Float muscleRate) {
		this.muscleRate = muscleRate;
	}
	/**
	 * 获取：肌肉率
	 */
	public Float getMuscleRate() {
		return muscleRate;
	}
	/**
	 * 设置：体型判断
	 */
	public void setBodyShapeJudgment(String bodyShapeJudgment) {
		this.bodyShapeJudgment = bodyShapeJudgment;
	}
	/**
	 * 获取：体型判断
	 */
	public String getBodyShapeJudgment() {
		return bodyShapeJudgment;
	}
	/**
	 * 设置：代谢年龄
	 */
	public void setMetabolicAge(String metabolicAge) {
		this.metabolicAge = metabolicAge;
	}
	/**
	 * 获取：代谢年龄
	 */
	public String getMetabolicAge() {
		return metabolicAge;
	}
	/**
	 * 设置：骨含量
	 */
	public void setBoneContent(Float boneContent) {
		this.boneContent = boneContent;
	}
	/**
	 * 获取：骨含量
	 */
	public Float getBoneContent() {
		return boneContent;
	}
	/**
	 * 设置：内脂含量
	 */
	public void setLactoneContent(Float lactoneContent) {
		this.lactoneContent = lactoneContent;
	}
	/**
	 * 获取：内脂含量
	 */
	public Float getLactoneContent() {
		return lactoneContent;
	}
	/**
	 * 设置：体测对比
	 */
	public void setSomatometricComparison(String somatometricComparison) {
		this.somatometricComparison = somatometricComparison;
	}
	/**
	 * 获取：体测对比
	 */
	public String getSomatometricComparison() {
		return somatometricComparison;
	}
}
