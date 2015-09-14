package com.kfpanda.gmatch.biz;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import com.kfpanda.gmatch.bean.Player;
import com.kfpanda.gmatch.mapper.PlayerMapper;

@Repository
public class PlayerBiz {
	private static final Logger logger = LoggerFactory.getLogger(PlayerBiz.class);
	
	@Resource
	private PlayerMapper playerMapper;
	
	public int savePlayer(Player player){
		return playerMapper.save(player);
	}
	
	public Player findOne(Long id){
		return playerMapper.findOne(id);
	}
	
	public List<Map<String, Object>> findByGidName(Long gId, String cnName, String enName, Pageable pageable){
		return playerMapper.findByGidName(gId, cnName, enName, pageable);
	}
	
	
}
