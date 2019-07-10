package com.oracle.shop.model.javabean;

import java.io.Serializable;

/**
 * 用户表 儌僨儖僋儔僗.
 * 
 * @author generated by ERMaster
 * @version $Id$
 */
public class Users implements Serializable {

	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** 用户编号. */
	private Integer userid;

	/** 用户名. */
	private String username;

	/** 密码. */
	private String password;

	/** 电话号码. */
	private String phone;

	/** 头像. */
	private String image;

	/** 找回码. */
	private Integer findcode;

	/**
	 * 僐儞僗僩儔僋僞.
	 */
	public Users() {
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
	 * 用户名 傪愝掕偟傑偡.
	 * 
	 * @param username
	 *            用户名
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * 用户名 傪庢摼偟傑偡.
	 * 
	 * @return 用户名
	 */
	public String getUsername() {
		return this.username;
	}

	/**
	 * 密码 傪愝掕偟傑偡.
	 * 
	 * @param password
	 *            密码
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 密码 傪庢摼偟傑偡.
	 * 
	 * @return 密码
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 * 电话号码 傪愝掕偟傑偡.
	 * 
	 * @param phone
	 *            电话号码
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * 电话号码 傪庢摼偟傑偡.
	 * 
	 * @return 电话号码
	 */
	public String getPhone() {
		return this.phone;
	}

	/**
	 * 头像 傪愝掕偟傑偡.
	 * 
	 * @param image
	 *            头像
	 */
	public void setImage(String image) {
		this.image = image;
	}

	/**
	 * 头像 傪庢摼偟傑偡.
	 * 
	 * @return 头像
	 */
	public String getImage() {
		return this.image;
	}

	/**
	 * 找回码 傪愝掕偟傑偡.
	 * 
	 * @param findcode
	 *            找回码
	 */
	public void setFindcode(Integer findcode) {
		this.findcode = findcode;
	}

	/**
	 * 找回码 傪庢摼偟傑偡.
	 * 
	 * @return 找回码
	 */
	public Integer getFindcode() {
		return this.findcode;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userid == null) ? 0 : userid.hashCode());

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
		Users other = (Users) obj;
		if (userid == null) {
			if (other.userid != null) {
				return false;
			}
		} else if (!userid.equals(other.userid)) {
			return false;
		}

		return true;
	}

}
