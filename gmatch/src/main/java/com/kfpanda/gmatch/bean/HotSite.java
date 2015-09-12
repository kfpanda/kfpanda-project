package com.kfpanda.gmatch.bean;

import java.io.Serializable;
import java.sql.Timestamp;


public class HotSite implements Serializable{
	private static final long	serialVersionUID	= -7358499588297114647L;
	
	private Long id;
	private Timestamp createTime;
	private String name;
	private Timestamp startDate;
	private Timestamp endDate;
	private String address;
	private Integer playerNum;
	private String rule;
	private String registration;
	private String bonus;
	private String intro;
	private String result;
	private Long mId;
	
	private Match match;
	
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
	
	public Timestamp getStartDate() {
		return startDate;
	}
	
	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}
	
	public Timestamp getEndDate() {
		return endDate;
	}
	
	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public Integer getPlayerNum() {
		return playerNum;
	}
	
	public void setPlayerNum(Integer playerNum) {
		this.playerNum = playerNum;
	}
	
	public String getRule() {
		return rule;
	}
	
	public void setRule(String rule) {
		this.rule = rule;
	}
	
	public String getRegistration() {
		return registration;
	}
	
	public void setRegistration(String registration) {
		this.registration = registration;
	}
	
	public String getBonus() {
		return bonus;
	}
	
	public void setBonus(String bonus) {
		this.bonus = bonus;
	}
	
	public String getIntro() {
		return intro;
	}
	
	public void setIntro(String intro) {
		this.intro = intro;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public Long getMId() {
		return mId;
	}
	
	public void setMId(Long mId) {
		this.mId = mId;
	}

	
	public Match getMatch() {
		return match;
	}
	public void setMatch(Match match) {
		this.match = match;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
}
