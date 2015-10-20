package com.kfpanda.gmatch.bean;

import java.sql.Timestamp;


public class HotSiteScore {
	private Long id;
	private Timestamp createTime;
	private Long pId;
	private Long hId;
	private String desc;
	
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
	
	public Long getPId() {
		return pId;
	}
	
	public void setPId(Long pId) {
		this.pId = pId;
	}
	
	public Long getHId() {
		return hId;
	}
	
	public void setHId(Long hId) {
		this.hId = hId;
	}
	
	public String getDesc() {
		return desc;
	}
	
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
}
