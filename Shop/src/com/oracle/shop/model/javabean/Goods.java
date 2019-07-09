package com.oracle.shop.model.javabean;

import java.io.Serializable;

/**
 * 商品表 儌僨儖僋儔僗.
 * 
 * @author generated by ERMaster
 * @version $Id$
 */
public class Goods implements Serializable {

	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** 商品编号. */
	private Integer goodsid;

	/** 商品名. */
	private String goodsname;

	/** 品牌名. */
	private String brandname;

	/** 价格. */
	private Double price;

	/** 库存. */
	private Integer stock;

	/** 商品图片. */
	private String picture;

	/** 是否打折. */
	private String sale;

	/** 折扣. */
	private Double discount;

	/**
	 * 僐儞僗僩儔僋僞.
	 */
	public Goods() {
	}

	/**
	 * 商品编号 傪愝掕偟傑偡.
	 * 
	 * @param goodsid
	 *            商品编号
	 */
	public void setGoodsid(Integer goodsid) {
		this.goodsid = goodsid;
	}

	/**
	 * 商品编号 傪庢摼偟傑偡.
	 * 
	 * @return 商品编号
	 */
	public Integer getGoodsid() {
		return this.goodsid;
	}

	/**
	 * 商品名 傪愝掕偟傑偡.
	 * 
	 * @param goodsname
	 *            商品名
	 */
	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}

	/**
	 * 商品名 傪庢摼偟傑偡.
	 * 
	 * @return 商品名
	 */
	public String getGoodsname() {
		return this.goodsname;
	}

	/**
	 * 品牌名 傪愝掕偟傑偡.
	 * 
	 * @param brandname
	 *            品牌名
	 */
	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}

	/**
	 * 品牌名 傪庢摼偟傑偡.
	 * 
	 * @return 品牌名
	 */
	public String getBrandname() {
		return this.brandname;
	}

	/**
	 * 价格 傪愝掕偟傑偡.
	 * 
	 * @param price
	 *            价格
	 */
	public void setPrice(Double price) {
		this.price = price;
	}

	/**
	 * 价格 傪庢摼偟傑偡.
	 * 
	 * @return 价格
	 */
	public Double getPrice() {
		return this.price;
	}

	/**
	 * 库存 傪愝掕偟傑偡.
	 * 
	 * @param stock
	 *            库存
	 */
	public void setStock(Integer stock) {
		this.stock = stock;
	}

	/**
	 * 库存 傪庢摼偟傑偡.
	 * 
	 * @return 库存
	 */
	public Integer getStock() {
		return this.stock;
	}

	/**
	 * 商品图片 傪愝掕偟傑偡.
	 * 
	 * @param picture
	 *            商品图片
	 */
	public void setPicture(String picture) {
		this.picture = picture;
	}

	/**
	 * 商品图片 傪庢摼偟傑偡.
	 * 
	 * @return 商品图片
	 */
	public String getPicture() {
		return this.picture;
	}

	/**
	 * 是否打折 傪愝掕偟傑偡.
	 * 
	 * @param sale
	 *            是否打折
	 */
	public void setSale(String sale) {
		this.sale = sale;
	}

	/**
	 * 是否打折 傪庢摼偟傑偡.
	 * 
	 * @return 是否打折
	 */
	public String getSale() {
		return this.sale;
	}

	/**
	 * 折扣 傪愝掕偟傑偡.
	 * 
	 * @param discount
	 *            折扣
	 */
	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	/**
	 * 折扣 傪庢摼偟傑偡.
	 * 
	 * @return 折扣
	 */
	public Double getDiscount() {
		return this.discount;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((goodsid == null) ? 0 : goodsid.hashCode());

		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Goods other = (Goods) obj;
		if (goodsid == null) {
			if (other.goodsid != null) {
				return false;
			}
		} else if (!goodsid.equals(other.goodsid)) {
			return false;
		}

		return true;
	}

}
