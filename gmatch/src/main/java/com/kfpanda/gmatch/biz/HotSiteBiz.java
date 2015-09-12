package com.kfpanda.gmatch.biz;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.kfpanda.gmatch.bean.HotSite;
import com.kfpanda.gmatch.mapper.HotSiteMapper;

@Repository
public class HotSiteBiz {
	
	private static final Logger logger = LoggerFactory.getLogger(HotSiteBiz.class);
	
	@Resource
	private HotSiteMapper hotSiteMapper;
	
	public int saveHotSite(HotSite hotSite){
		return hotSiteMapper.save(hotSite);
	}
	
	public HotSite findOne(Long id){
		return hotSiteMapper.findOne(id);
	}
	
	public List<Map<String, Object>> find(Long gId, Long startDate, Long endDate, String mName, Pageable pageable){
		return hotSiteMapper.find(gId, startDate, endDate, mName, pageable);
	}
	
	/**
	 * 赛站选手查询
	 * @param hId 赛站id 
	 * @param score 成绩 -- 查询条件
	 * @param pageable 分页
	 * @author 许小满  
	 * @date 2015年9月12日 下午5:33:03
	 */
	public List<Map<String, Object>> playerFind(Long hId, String score, Pageable pageable){
		return hotSiteMapper.playerFind(hId, score, pageable);
	}
	
	/**
	 * 赛站比赛结果查询
	 * @author 许小满  
	 * @date 2015年9月12日 下午6:21:59
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Map<String, Object>> scoreFind(Long hId, Pageable pageable){
		//return hotSiteMapper.playerFind(hId, score, pageable);
		String result = hotSiteMapper.resultFind(hId);//赛站奖励
		System.out.println("result= "  + result);
		if(StringUtils.isBlank(result)){
			return new ArrayList();
		}
		String[] resultArray = result.split(";");
		int maxLength = resultArray != null ? resultArray.length : 0;
		for(int i=0; i<maxLength; i++){
			String resultItem = resultArray[i];
			//String[] resultItemArray = StringUtils.isno
		}
		
		return null;
	}
	
}
