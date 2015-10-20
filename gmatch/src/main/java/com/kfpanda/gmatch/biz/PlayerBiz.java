package com.kfpanda.gmatch.biz;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.kfpanda.gmatch.bean.Player;
import com.kfpanda.gmatch.mapper.PlayerMapper;
import com.util.common.FormatUtil;

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
	
	/**
	 * 游戏选手职业数据查询(接口:1.0.6)
	 * @author 许小满  
	 * @date Sep 20, 2015 4:55:27 PM
	 */
	public List<Map<String, Object>> gamedataFind(Long pId,  Pageable pageable){
		List<Map<String, Object>> dataList = new ArrayList<Map<String,Object>>();
		Map<String,Object> dataMap = new LinkedHashMap<String,Object>();
		NumberFormat percentFormat = NumberFormat.getPercentInstance();
		percentFormat.setMaximumFractionDigits(2);  
		percentFormat.setMinimumFractionDigits(0);  
		dataMap.put("id", pId);//游戏选手id
		//1.查询选手场次胜率
		List<Map<String, Object>> dList = playerMapper.findCRate(pId);
		int maxSize = dList != null ? dList.size() : 0;
		Map<String,Object> map = null;
		java.math.BigDecimal winRateD = null;
		for(int i=0; i<maxSize; i++){
			map = dList.get(i);
			if(map == null)
				continue;
			dataMap.put("battlewin", map.get("win_nums"));//场胜利场次
			dataMap.put("battlelost", map.get("lost_nums"));//场失败场次
			winRateD=  (java.math.BigDecimal)map.get("win_rate");
			dataMap.put("battlelrate", percentFormat.format(winRateD));//场胜率
		}
		//2.查询选手局胜率
		dList = playerMapper.findJRate(pId);
		maxSize = dList != null ? dList.size() : 0;
		for(int i=0; i<maxSize; i++){
			map = dList.get(i);
			if(map == null)
				continue;
			dataMap.put("juwin", map.get("win_nums"));//局胜利场次
			dataMap.put("julost", map.get("lost_nums"));//局失败场次
			winRateD =  (java.math.BigDecimal)map.get("win_rate");
			dataMap.put("jurate", percentFormat.format(winRateD));//局胜率
		}
		//3.查询选手各职业、套牌胜率
		dList = playerMapper.findOCRate(pId, pageable);
		maxSize = dList != null ? dList.size() : 0;
		List<Map<String, Object>> ocList = new ArrayList<Map<String,Object>>();;
		Map<String,Object> ocMap = null;
		for(int i=0; i<maxSize; i++){
			map = dList.get(i);
			ocMap = new LinkedHashMap<String,Object>();
			ocMap.put("ocName", map.get("occupation"));//职业及套牌
			ocMap.put("win", map.get("win_nums"));//胜利场次
			ocMap.put("lost", map.get("lost_nums"));//失败场次
			winRateD =  (java.math.BigDecimal)map.get("win_rate");
			ocMap.put("rate", percentFormat.format(winRateD));//胜率
			ocList.add(ocMap);
		}
		dataMap.put("ocdata", ocList);
		dataList.add(dataMap);
		return dataList;
	}
	
	/**
	 * 游戏选手主要成就查询接口（接口 1.0.7）
	 * @author 许小满  
	 * @date Oct 21, 2015 12:31:06 AM
	 */
	public List<Map<String, Object>> gameDataAchiSearch(Long gId, Long pId, Pageable pageable){
		List<Map<String, Object>> dataList = playerMapper.gameDataAchiSearch(gId, pId, pageable);
		for(Map<String, Object> dataMap : dataList){
			dataMap.put("result", FormatUtil.formatResult((Integer)dataMap.get("num"), (String)dataMap.get("result")));
			dataMap.remove("num");
		}
		return dataList;
	}
}