package com.kfpanda.gmatch.bean;

import java.sql.Timestamp;


public class HotAgainst {
	private Long id;
	private Timestamp createTime;
	private Long pId1;
	private Long pId2;
	private String occupation1;
	private String occupation2;
	private String cards1;
	private String cards2;
	private String result;
	private String first;
	private String round;
	private String koNum;
	private String videoUrl;
	private Integer num;
	private Long hId;
	
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
	
	public Long getPId1() {
		return pId1;
	}
	
	public void setPId1(Long pId1) {
		this.pId1 = pId1;
	}
	
	public Long getPId2() {
		return pId2;
	}
	
	public void setPId2(Long pId2) {
		this.pId2 = pId2;
	}
	
	public String getOccupation1() {
		return occupation1;
	}
	
	public void setOccupation1(String occupation1) {
		this.occupation1 = occupation1;
	}
	
	public String getOccupation2() {
		return occupation2;
	}
	
	public void setOccupation2(String occupation2) {
		this.occupation2 = occupation2;
	}
	
	public String getCards1() {
		return cards1;
	}
	
	public void setCards1(String cards1) {
		this.cards1 = cards1;
	}
	
	public String getCards2() {
		return cards2;
	}
	
	public void setCards2(String cards2) {
		this.cards2 = cards2;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public String getFirst() {
		return first;
	}
	
	public void setFirst(String first) {
		this.first = first;
	}
	
	public String getRound() {
		return round;
	}
	
	public void setRound(String round) {
		this.round = round;
	}
	public String getKoNum() {
		return koNum;
	}
	public void setKoNum(String koNum) {
		this.koNum = koNum;
	}

	public String getVideoUrl() {
		return videoUrl;
	}
	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	public Integer getNum() {
		return num;
	}
	
	public void setNum(Integer num) {
		this.num = num;
	}
	
	public Long getHId() {
		return hId;
	}
	
	public void setHId(Long hId) {
		this.hId = hId;
	}
	
}
