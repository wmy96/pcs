package com.pcs.pojo;

import java.io.Serializable;

public class PersonCourse implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7712114150602089703L;

	private Integer pcId;

	private Integer peId;

	private Integer cId;

	private Integer value;

	private Integer status;

	private String cName;

	private String term;

	private String peNumber;

	private String peName;

	public PersonCourse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PersonCourse(Integer pcId, Integer peId, Integer cId, Integer value, Integer status) {
		super();
		this.pcId = pcId;
		this.peId = peId;
		this.cId = cId;
		this.value = value;
		this.status = status;
	}

	public Integer getPcId() {
		return pcId;
	}

	public void setPcId(Integer pcId) {
		this.pcId = pcId;
	}

	public Integer getPeId() {
		return peId;
	}

	public void setPeId(Integer peId) {
		this.peId = peId;
	}

	public Integer getcId() {
		return cId;
	}

	public void setcId(Integer cId) {
		this.cId = cId;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public String getPeNumber() {
		return peNumber;
	}

	public void setPeNumber(String peNumber) {
		this.peNumber = peNumber;
	}

	public String getPeName() {
		return peName;
	}

	public void setPeName(String peName) {
		this.peName = peName;
	}

}