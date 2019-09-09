package com.fc.crm.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author fengchi
 * @email 
 * @date 2019-09-08 14:56:31
 */
public class StockDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//商品id
	private Integer goodsId;
	//库存量
	private Integer stock;

	/**
	 * 设置：商品id
	 */
	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}
	/**
	 * 获取：商品id
	 */
	public Integer getGoodsId() {
		return goodsId;
	}
	/**
	 * 设置：库存量
	 */
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	/**
	 * 获取：库存量
	 */
	public Integer getStock() {
		return stock;
	}
}
