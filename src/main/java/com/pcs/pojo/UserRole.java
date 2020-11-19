package com.pcs.pojo;

import java.io.Serializable;

public class UserRole implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3261168710191061920L;

	private Integer urId;

	private Integer uId;

	private Integer rId;

	private Integer status;

	public UserRole() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserRole(Integer urId, Integer uId, Integer rId, Integer status) {
		super();
		this.urId = urId;
		this.uId = uId;
		this.rId = rId;
		this.status = status;
	}

	public Integer getUrId() {
		return urId;
	}

	public void setUrId(Integer urId) {
		this.urId = urId;
	}

	public Integer getuId() {
		return uId;
	}

	public void setuId(Integer uId) {
		this.uId = uId;
	}

	public Integer getrId() {
		return rId;
	}

	public void setrId(Integer rId) {
		this.rId = rId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}