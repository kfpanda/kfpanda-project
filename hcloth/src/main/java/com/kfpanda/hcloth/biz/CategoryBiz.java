package com.kfpanda.hcloth.biz;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.kfpanda.hcloth.bean.Category;
import com.kfpanda.hcloth.mapper.CategoryMapper;

@Repository
public class CategoryBiz {
	private static final Logger logger = LoggerFactory.getLogger(CategoryBiz.class);
	
	@Resource
	private CategoryMapper categoryMapper;
	
	public int savePlayer(Category player){
		return categoryMapper.save(player);
	}
	
	public Category findOne(Long id){
		return categoryMapper.findOne(id);
	}
	
	public List<Category> findAll(){
		return categoryMapper.findAll();
	}
	
}