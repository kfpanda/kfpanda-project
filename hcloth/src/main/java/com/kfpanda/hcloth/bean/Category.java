package com.kfpanda.hcloth.bean;

import java.io.Serializable;
import java.sql.Timestamp;


public class Category implements Serializable{
	private static final long	serialVersionUID	= 770854334136165518L;
	
	private Long id;
	private Timestamp createTime;
	private String name;
	private String category;
	private String thumb;
	
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
	public String getCategory() {
    	return category;
    }
	public void setCategory(String category) {
    	this.category = category;
    }
	public String getThumb() {
		return thumb;
	}
	public void setThumb(String thumb) {
		this.thumb = thumb;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
}
