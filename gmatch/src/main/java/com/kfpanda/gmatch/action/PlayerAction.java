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
import com.kfpanda.gmatch.biz.PlayerBiz;

@Controller("playerAction")
@RequestMapping("/player")
public class PlayerAction extends BaseAction{
	private static final Logger logger = LoggerFactory.getLogger(PlayerAction.class);
	
	@Resource(name="playerBiz")
	private PlayerBiz playerBiz;
	
	/**
	 * 游戏选手查询（接口：1.0.4）
	 * @author kfpanda
	 * @date 2015年9月14日 下午1:09:05
	 */
	@RequestMapping(value = "/game/find")
	public @ResponseBody Object msgSearch(@RequestParam(value = "gid") long gId,
				@RequestParam(value = "cnname", required=false) String cnName, 
				@RequestParam(value = "enname", required=false) String enName,
				@PageableDefaults(pageNumber=0, value=5, sort="createTime=desc") Pageable pageable) {
		
		cnName = StringUtils.isBlank(cnName) ? null : cnName;
		enName = StringUtils.isBlank(enName) ? null : enName;
		
		return this.getResult(playerBiz.findByGidName(gId, cnName, enName, pageable));
	}
	
}