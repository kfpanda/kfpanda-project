package com.kfpanda.gmatch.biz;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
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
}
