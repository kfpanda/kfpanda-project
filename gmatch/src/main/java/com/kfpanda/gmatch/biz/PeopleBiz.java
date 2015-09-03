package com.kfpanda.gmatch.biz;

import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import com.kfpanda.gmatch.bean.People;
import com.kfpanda.gmatch.mapper.PeopleMapper;

@Repository
public class PeopleBiz {
	private static final Logger logger = LoggerFactory.getLogger(PeopleBiz.class);
	
	@Resource
	private PeopleMapper peopleMapper;
	
	public int savePeople(People people){
		return peopleMapper.save(people);
	}
	
	public List<People> findByName(String name){
		return peopleMapper.findByName(name);
	}
	
	public People findOne(Long id){
		return peopleMapper.findOne(id);
	}
}
