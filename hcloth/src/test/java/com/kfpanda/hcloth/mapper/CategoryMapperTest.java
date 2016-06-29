package com.kfpanda.hcloth.mapper;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.kfpanda.hcloth.bean.Category;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={"/spring/spring-application.xml", "/spring/spring-mvc.xml"})
public class CategoryMapperTest {
	
	@Resource
	private CategoryMapper categoryMapper;
	
	@Test
	public void save(){
		Category category = new Category();
		category.setCreateTime(new Timestamp(System.currentTimeMillis()));
		category.setName("name1");
		category.setCategory("category1");
		
		int result = categoryMapper.save(category);
		Assert.assertTrue(result == 1);
	}
	
	@Test
	public void deleteById(){
		
		int result = categoryMapper.deleteById(new Long(2));
		Assert.assertTrue(result == 1);
	}
	
	@Test
	public void findOne(){
		
		Category player = categoryMapper.findOne(new Long(1));
		Assert.assertTrue(player != null);
	}
	
	@Test
	public void findAll(){
		List<Category> playerList = categoryMapper.findAll();
		Assert.assertTrue(playerList.size() > 0);
	}
}
