package com.kfpanda.gmatch.bean;

import java.io.Serializable;
import java.sql.Timestamp;


public class Player implements Serializable{
	private static final long	serialVersionUID	= 770854334136165518L;
	
	private Long id;
	private Timestamp createTime;
	private String cnName;
	private String enName;
	private String gameBest;
	private String favourite;
	private Long pId;
	private Long gId;
	
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
	
	public String getCnName() {
		return cnName;
	}
	
	public void setCnName(String cnName) {
		this.cnName = cnName;
	}
	
	public String getEnName() {
		return enName;
	}
	
	public void setEnName(String enName) {
		this.enName = enName;
	}
	
	public String getGameBest() {
		return gameBest;
	}
	
	public void setGameBest(String gameBest) {
		this.gameBest = gameBest;
	}
	
	public String getFavourite() {
		return favourite;
	}
	
	public void setFavourite(String favourite) {
		this.favourite = favourite;
	}
	
	public Long getPId() {
		return pId;
	}
	
	public void setPId(Long pId) {
		this.pId = pId;
	}
	
	public Long getGId() {
		return gId;
	}
	
	public void setGId(Long gId) {
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
