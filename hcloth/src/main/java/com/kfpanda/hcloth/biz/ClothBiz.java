package com.kfpanda.hcloth.biz;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.kfpanda.hcloth.bean.Cloth;
import com.kfpanda.hcloth.mapper.ClothMapper;

@Repository
public class ClothBiz {
	
	private static final Logger logger = LoggerFactory.getLogger(ClothBiz.class);
	
	@Resource
	private ClothMapper clothMapper;
	
	public int saveHotSite(Cloth cloth){
		return clothMapper.save(cloth);
	}
	
	public Cloth findOne(Long id){
		return clothMapper.findOne(id);
	}
	
	public List<Map<String, Object>> findByCID(Long cId){
		return clothMapper.findByCID(cId);
	}
}
