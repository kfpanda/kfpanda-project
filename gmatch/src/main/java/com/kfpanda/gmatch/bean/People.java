package com.kfpanda.gmatch.bean;

import java.io.Serializable;
import java.sql.Timestamp;


public class People implements Serializable{
	private static final long	serialVersionUID	= -2623360343381933074L;
	
	private Long id;
	private Timestamp createTime;
	private Timestamp updateTime;
	private String name;
	private int age;
	private String country;
	private Boolean sex;
	private String college;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Timestamp getCreateTime() {
		return createTime;
	}
	
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	
	public Timestamp getUpdateTime() {
		return updateTime;
	}
	
	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	public Boolean getSex() {
		return sex;
	}
	
	public void setSex(Boolean sex) {
		this.sex = sex;
	}
	
	public String getCollege() {
		return college;
	}
	
	public void setCollege(String college) {
		this.college = college;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
}
