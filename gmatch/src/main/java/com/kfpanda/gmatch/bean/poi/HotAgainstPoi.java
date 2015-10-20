package com.kfpanda.gmatch.bean.poi;

import java.sql.Timestamp;
import com.kfpanda.gmatch.bean.HotAgainst;
import com.util.common.poi.ExcelAnnotation;


public class HotAgainstPoi{
	@ExcelAnnotation(exportName="id（可空）")
	private Long id;
	@ExcelAnnotation(exportName="创建时间（可空）")
	private Timestamp createTime;
	private Long pId1;
	private Long pId2;
	@ExcelAnnotation(exportName="A的职业")
	private String occupation1;
	@ExcelAnnotation(exportName="B的职业")
	private String occupation2;
	@ExcelAnnotation(exportName="A的套牌")
	private String cards1;
	@ExcelAnnotation(exportName="B的套牌")
	private String cards2;
	@ExcelAnnotation(exportName="结果(胜)")
	private String result;
	@ExcelAnnotation(exportName="先手")
	private String first;
	@ExcelAnnotation(exportName="轮次")
	private String round;
	@ExcelAnnotation(exportName="几费终结")
	private String koNum;
	@ExcelAnnotation(exportName="URL")
	private String videoUrl;
	@ExcelAnnotation(exportName="序号")
	private Integer num;
	@ExcelAnnotation(exportName="赛站ID")
	private Integer hId;
	
	@ExcelAnnotation(exportName="A选手名称")
	private String p1Name;
	@ExcelAnnotation(exportName="B选手名称")
	private String p2Name;
	
	
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
	
	public Integer getNum() {
		return num;
	}
	
	public void setNum(Integer num) {
		this.num = num;
	}
	
	public Long getHId() {
		return hId.longValue();
	}
	
	public void setHId(Integer hId) {
		this.hId = hId;
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

	public String getP1Name() {
		return p1Name;
	}
	public void setP1Name(String p1Name) {
		this.p1Name = p1Name;
	}
	public String getP2Name() {
		return p2Name;
	}
	public void setP2Name(String p2Name) {
		this.p2Name = p2Name;
	}
	
	
	
}
