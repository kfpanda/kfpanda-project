package com.kfpanda.hcloth.bean;

import java.io.Serializable;
import java.sql.Timestamp;


public class Cloth implements Serializable{
	private static final long	serialVersionUID	= 770854334136165518L;
	
	private Long id;
	private Long cId;
	private Timestamp createTime;
	private String name;
	private String img;
	private String design;
	private String composition;
	private String width;
	private String weight;
	private String country;
	private String resistance;
	private String flammability;
	private String shrinkage;
	private String washload;
	private String colour;
	private String environment;
	
	public Long getId() {
    	return id;
    }

	public void setId(Long id) {
    	this.id = id;
    }



	public Long getcId() {
    	return cId;
    }



	public void setcId(Long cId) {
    	this.cId = cId;
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



	public String getImg() {
    	return img;
    }



	public void setImg(String img) {
    	this.img = img;
    }



	public String getDesign() {
    	return design;
    }



	public void setDesign(String design) {
    	this.design = design;
    }



	public String getComposition() {
    	return composition;
    }



	public void setComposition(String composition) {
    	this.composition = composition;
    }



	public String getWidth() {
    	return width;
    }



	public void setWidth(String width) {
    	this.width = width;
    }



	public String getWeight() {
    	return weight;
    }



	public void setWeight(String weight) {
    	this.weight = weight;
    }



	public String getCountry() {
    	return country;
    }



	public void setCountry(String country) {
    	this.country = country;
    }



	public String getResistance() {
    	return resistance;
    }



	public void setResistance(String resistance) {
    	this.resistance = resistance;
    }



	public String getFlammability() {
    	return flammability;
    }



	public void setFlammability(String flammability) {
    	this.flammability = flammability;
    }



	public String getShrinkage() {
    	return shrinkage;
    }



	public void setShrinkage(String shrinkage) {
    	this.shrinkage = shrinkage;
    }



	public String getWashload() {
    	return washload;
    }



	public void setWashload(String washload) {
    	this.washload = washload;
    }



	public String getColour() {
    	return colour;
    }



	public void setColour(String colour) {
    	this.colour = colour;
    }



	public String getEnvironment() {
    	return environment;
    }



	public void setEnvironment(String environment) {
    	this.environment = environment;
    }



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
}
