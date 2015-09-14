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
import com.kfpanda.gmatch.bean.Player;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={"/spring/spring-application.xml", "/spring/spring-mvc.xml"})
public class PlayerMapperTest {
	
	@Resource
	private PlayerMapper playerMapper;
	
	@Test
	public void save(){
		Player player = new Player();
		player.setCreateTime(new Timestamp(System.currentTimeMillis()));
		player.setCnName("狂人");
		player.setEnName("kfpanda");
		player.setGameBest("中国区第一名");
		player.setFavourite("炉石传说");
		player.setPId(new Long(1));
		player.setGId(new Long(1));
		
		int result = playerMapper.save(player);
		
		Assert.assertTrue(result == 1);
	}
	
	@Test
	public void deleteById(){
		
		int result = playerMapper.deleteById(new Long(2));
		Assert.assertTrue(result == 1);
	}
	
	@Test
	public void findOne(){
		
		Player player = playerMapper.findOne(new Long(1));
		Assert.assertTrue(player != null);
	}
	
	@Test
	public void findByGidName(){
		Pageable pageable = new PageRequest(0, 10);
		List<Map<String, Object>> playerList = playerMapper.findByGidName(new Long(1), null, null, pageable);
		Assert.assertTrue(playerList.size() > 0);
	}
}
