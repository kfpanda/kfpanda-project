package com.kfpanda.gmatch.action;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kfpanda.gmatch.biz.HotSiteBiz;


@Controller("hotSiteAction")
@RequestMapping("/hotsite")
public class HotSiteAction extends BaseAction{
	private static final Logger logger = LoggerFactory.getLogger(HotSiteAction.class);
	
	@Resource(name="hotSiteBiz")
	private HotSiteBiz hotSiteBiz;
	
	/**
	 * 赛站查询（接口：1.0.1）
	 * @author kfpanda
	 * @date 2015年9月12日 下午1:09:05
	 */
	@RequestMapping(value = "/find")
	public @ResponseBody Object find(
			@RequestParam(value = "gid") long gId,//默认值为 2014-01-01
			@RequestParam(value = "startdate",required=false, defaultValue="1388534400000") long startDate,
            @RequestParam(value = "enddate",required=false, defaultValue="0") long endDate,
            @RequestParam(value = "mname",required=false) String mName,
            @PageableDefaults(pageNumber=0, value=5, sort="createTime=desc") Pageable pageable) {
		
		endDate = endDate < 1 ? System.currentTimeMillis() : endDate;
		startDate = startDate / 1000;
		endDate = endDate / 1000;  //转换为秒
		mName = StringUtils.isBlank(mName) ? null : mName;
		
		return this.getResult(hotSiteBiz.find(gId, startDate, endDate, mName, pageable));
	}
	
	/**
	 * 赛站选手查询（接口：1.0.2）
	 * @author 许小满  
	 * @date 2015年9月12日 下午1:09:05
	 */
	@RequestMapping(value = "/player/find")
	public @ResponseBody Object playerFind(
			@RequestParam(value = "hid") long hId,
			@RequestParam(value = "score",required=false) String score,
			@RequestParam(value = "keyword",required=false) String keyword,
			@PageableDefaults(pageNumber=0, value=5, sort="gamebest=asc") Pageable pageable
			) {
		score = StringUtils.isBlank(score) ? "-1" : score;
		return this.getResult(hotSiteBiz.playerFind(hId, score, keyword, pageable));
	}
	
	/**
	 * 赛站结果查询（接口：1.0.3）
	 * @author 许小满  
	 * @date 2015年9月12日 下午6:37:55
	 */
	@RequestMapping(value = "/score/find")
	public @ResponseBody Object scoreFind(
			@RequestParam(value = "hid") long hId
			) {
		return this.getResult(hotSiteBiz.scoreFind(hId));
	}
	
}
