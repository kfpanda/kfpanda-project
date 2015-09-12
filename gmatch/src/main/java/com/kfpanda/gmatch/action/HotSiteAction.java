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
            @PageableDefaults(pageNumber=1, value=5, sort="createTime=desc") Pageable pageable) {
		
		mName = StringUtils.isBlank(mName) ? null : mName;
		
		return this.getResult(hotSiteBiz.find(gId, startDate, endDate, mName, pageable));
	}
}
