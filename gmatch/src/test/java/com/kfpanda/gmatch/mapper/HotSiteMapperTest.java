package com.kfpanda.gmatch.mapper;

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
import com.kfpanda.gmatch.bean.HotSite;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={"/spring/spring-application.xml", "/spring/spring-mvc.xml"})
public class HotSiteMapperTest {
	
	@Resource
	private HotSiteMapper hotSiteMapper;
	
	@Test
	public void save(){
		HotSite hotSite = new HotSite();
		hotSite.setCreateTime(new Timestamp(System.currentTimeMillis()));
		hotSite.setName("钮立人");
		hotSite.setStartDate(new Timestamp(System.currentTimeMillis()));
		hotSite.setEndDate(new Timestamp(System.currentTimeMillis()));
		hotSite.setAddress("浙江杭州");
		hotSite.setPlayerNum(10);
		hotSite.setRule("");
		hotSite.setRegistration("");
		hotSite.setBonus("");
		hotSite.setIntro("");
		hotSite.setResult("");
		hotSite.setMId(new Long(111));
		
		int result = hotSiteMapper.save(hotSite);
		
		Assert.assertTrue(result == 1);
	}
	
	@Test
	public void deleteById(){
		
		int result = hotSiteMapper.deleteById(new Long(2));
		Assert.assertTrue(result == 1);
	}
	
	@Test
	public void findOne(){
		
		HotSite hotSite = hotSiteMapper.findOne(new Long(1));
		Assert.assertTrue(hotSite != null);
	}
	
	@Test
	public void find(){
		Pageable pageable = new PageRequest(0, 10);
		List<Map<String, Object>> hotSiteList = hotSiteMapper.find(new Long(1), new Long(32), new Long(34), "", pageable);
		Assert.assertTrue(hotSiteList.size() > 0);
	}
}
