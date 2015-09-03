package com.kfpanda.gmatch.mapper;

import java.sql.Timestamp;
import java.util.List;
import javax.annotation.Resource;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.kfpanda.gmatch.bean.People;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={"/spring/spring-application.xml", "/spring/spring-mvc.xml"})
public class PeopleMapperTest {
	
	@Resource
	private PeopleMapper peopleMapper;
	
	@Test
	public void save(){
		People people = new People();
		people.setCreateTime(new Timestamp(System.currentTimeMillis()));
		people.setUpdateTime(new Timestamp(System.currentTimeMillis()));
		people.setName("钮立人");
		people.setAge(20);
		people.setCountry("中国");
		people.setSex(true);
		people.setCollege("大学");
		
		int result = peopleMapper.save(people);
		
		Assert.assertTrue(result == 1);
	}
	
	@Test
	public void deleteById(){
		
		int result = peopleMapper.deleteById(new Long(2));
		Assert.assertTrue(result == 1);
	}
	
	@Test
	public void findOne(){
		
		People people = peopleMapper.findOne(new Long(1));
		Assert.assertTrue(people != null);
	}
	
	@Test
	public void findByName(){
		List<People> peopleList = peopleMapper.findByName("钮立人");
		Assert.assertTrue(peopleList.size() > 0);
	}
}
