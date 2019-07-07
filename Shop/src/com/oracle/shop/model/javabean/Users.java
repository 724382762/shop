package com.oracle.shop.model.javabean;

import java.io.Serializable;

/**
 * �û��� ���f���N���X.
 * 
 * @author generated by ERMaster
 * @version $Id$
 */
public class Users implements Serializable {

	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** �û����. */
	private Integer userid;

	/** �û���. */
	private String username;

	/** ����. */
	private String password;

	/** �Ա�. */
	private String sex;

	/** ����. */
	private Integer age;

	/** �绰����. */
	private String phone;

	/**
	 * �R���X�g���N�^.
	 */
	public Users() {
	}

	/**
	 * �û���� ��ݒ肵�܂�.
	 * 
	 * @param userid
	 *            �û����
	 */
	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	/**
	 * �û���� ���擾���܂�.
	 * 
	 * @return �û����
	 */
	public Integer getUserid() {
		return this.userid;
	}

	/**
	 * �û��� ��ݒ肵�܂�.
	 * 
	 * @param username
	 *            �û���
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * �û��� ���擾���܂�.
	 * 
	 * @return �û���
	 */
	public String getUsername() {
		return this.username;
	}

	/**
	 * ���� ��ݒ肵�܂�.
	 * 
	 * @param password
	 *            ����
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * ���� ���擾���܂�.
	 * 
	 * @return ����
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 * �Ա� ��ݒ肵�܂�.
	 * 
	 * @param sex
	 *            �Ա�
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}

	/**
	 * �Ա� ���擾���܂�.
	 * 
	 * @return �Ա�
	 */
	public String getSex() {
		return this.sex;
	}

	/**
	 * ���� ��ݒ肵�܂�.
	 * 
	 * @param age
	 *            ����
	 */
	public void setAge(Integer age) {
		this.age = age;
	}

	/**
	 * ���� ���擾���܂�.
	 * 
	 * @return ����
	 */
	public Integer getAge() {
		return this.age;
	}

	/**
	 * �绰���� ��ݒ肵�܂�.
	 * 
	 * @param phone
	 *            �绰����
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * �绰���� ���擾���܂�.
	 * 
	 * @return �绰����
	 */
	public String getPhone() {
		return this.phone;
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