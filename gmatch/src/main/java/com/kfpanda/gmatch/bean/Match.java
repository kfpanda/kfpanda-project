package com.kfpanda.gmatch.bean;

import java.io.Serializable;
import java.sql.Timestamp;


public class Match implements Serializable{
	private static final long	serialVersionUID	= -8599557616308877157L;
	
	private Long id;
	private Timestamp createTime;
	private String name;
	private String holder;
	private String size;
	private Integer cycle;
	private String level;
	private String type;
	private String gId;
	
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
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getHolder() {
		return holder;
	}
	
	public void setHolder(String holder) {
		this.holder = holder;
	}
	
	public String getSize() {
		return size;
	}
	
	public void setSize(String size) {
		this.size = size;
	}
	
	public Integer getCycle() {
		return cycle;
	}
	
	public void setCycle(Integer cycle) {
		this.cycle = cycle;
	}
	
	public String getLevel() {
		return level;
	}
	
	public void setLevel(String level) {
		this.level = level;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getGId() {
		return gId;
	}
	
	public void setGId(String gId) {
		this.gId = gId;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
}
