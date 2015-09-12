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
	
	@RequestMapping(value = "/find")
	public @ResponseBody Object find(
			@RequestParam(value = "gid") long gId,
			@RequestParam(value = "startdate") long startDate,
            @RequestParam(value = "enddate") long endDate,
            @RequestParam(value = "mname",required=false) String mName,
            @PageableDefaults(pageNumber=0, value=5, sort="createTime=desc") Pageable pageable) {
		
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
			@PageableDefaults(pageNumber=0, value=5, sort="gamebest=asc") Pageable pageable
			) {
		score = StringUtils.isBlank(score) ? "-1" : score;
		return this.getResult(hotSiteBiz.playerFind(hId, score, pageable));
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
