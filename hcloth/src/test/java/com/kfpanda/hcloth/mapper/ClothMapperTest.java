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
import com.kfpanda.hcloth.bean.Cloth;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={"/spring/spring-application.xml", "/spring/spring-mvc.xml"})
public class ClothMapperTest {
	
	@Resource
	private ClothMapper clothMapper;
	
	@Test
	public void save(){
		Cloth cloth = new Cloth();
		cloth.setCreateTime(new Timestamp(System.currentTimeMillis()));
		cloth.setcId(new Long(1));
		cloth.setName("name1");
		cloth.setColour("colour");
		cloth.setComposition("composition");
		cloth.setCountry("country");
		cloth.setDesign("design");
		cloth.setEnvironment("environment");
		cloth.setFlammability("flammability");
		cloth.setImg("/imgs/test.png");
		cloth.setResistance("resistance");
		cloth.setShrinkage("shrinkage");
		cloth.setWashload("washload");
		cloth.setWeight("100cm");
		cloth.setWidth("200cm");
		
		int result = clothMapper.save(cloth);
		Assert.assertTrue(result == 1);
	}
	
	@Test
	public void deleteById(){
		
		int result = clothMapper.deleteById(new Long(2));
		Assert.assertTrue(result == 1);
	}
	
	@Test
	public void findOne(){
		
		Map<String, Object> cloth = clothMapper.findOne(new Long(1));
		Assert.assertTrue(cloth != null);
	}
	
	@Test
	public void findByCID(){
		List<Map<String, Object>> clothList = clothMapper.findByCID(new Long(1));
		Assert.assertTrue(clothList.size() > 0);
	}
}
