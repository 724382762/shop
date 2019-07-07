package com.oracle.shop.model.javabean;

import java.io.Serializable;

/**
 * 订单表 儌僨儖僋儔僗.
 * 
 * @author generated by ERMaster
 * @version $Id$
 */
public class Orders implements Serializable {

	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** 订单号. */
	private Integer orderid;

	/** 下单时间. */
	private String time;

	/** 订单状态. */
	private String status;

	/** 收货地址. */
	private String address;

	/** 备注. */
	private String note;

	/** 用户编号. */
	private Integer userid;

	/**
	 * 僐儞僗僩儔僋僞.
	 */
	public Orders() {
	}

	/**
	 * 订单号 傪愝掕偟傑偡.
	 * 
	 * @param orderid
	 *            订单号
	 */
	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}

	/**
	 * 订单号 傪庢摼偟傑偡.
	 * 
	 * @return 订单号
	 */
	public Integer getOrderid() {
		return this.orderid;
	}

	/**
	 * 下单时间 傪愝掕偟傑偡.
	 * 
	 * @param time
	 *            下单时间
	 */
	public void setTime(String time) {
		this.time = time;
	}

	/**
	 * 下单时间 傪庢摼偟傑偡.
	 * 
	 * @return 下单时间
	 */
	public String getTime() {
		return this.time;
	}

	/**
	 * 订单状态 傪愝掕偟傑偡.
	 * 
	 * @param status
	 *            订单状态
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * 订单状态 傪庢摼偟傑偡.
	 * 
	 * @return 订单状态
	 */
	public String getStatus() {
		return this.status;
	}

	/**
	 * 收货地址 傪愝掕偟傑偡.
	 * 
	 * @param address
	 *            收货地址
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * 收货地址 傪庢摼偟傑偡.
	 * 
	 * @return 收货地址
	 */
	public String getAddress() {
		return this.address;
	}

	/**
	 * 备注 傪愝掕偟傑偡.
	 * 
	 * @param note
	 *            备注
	 */
	public void setNote(String note) {
		this.note = note;
	}

	/**
	 * 备注 傪庢摼偟傑偡.
	 * 
	 * @return 备注
	 */
	public String getNote() {
		return this.note;
	}

	/**
	 * 用户编号 傪愝掕偟傑偡.
	 * 
	 * @param userid
	 *            用户编号
	 */
	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	/**
	 * 用户编号 傪庢摼偟傑偡.
	 * 
	 * @return 用户编号
	 */
	public Integer getUserid() {
		return this.userid;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orderid == null) ? 0 : orderid.hashCode());

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
		Orders other = (Orders) obj;
		if (orderid == null) {
			if (other.orderid != null) {
				return false;
			}
		} else if (!orderid.equals(other.orderid)) {
			return false;
		}

		return true;
	}

}
