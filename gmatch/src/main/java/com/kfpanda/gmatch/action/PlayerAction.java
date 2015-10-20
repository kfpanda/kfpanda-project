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
	
	/**
	 * 游戏选手职业数据查询(接口:1.0.6)
	 * @author 许小满  
	 * @date Sep 20, 2015 4:53:41 PM
	 */
	@RequestMapping(value = "/gamedata/find")
	public @ResponseBody Object gamedataFind(
			     @RequestParam(value = "pid") long pId,
				@PageableDefaults(pageNumber=0, value=5, sort="win_rate=desc") Pageable pageable) {
		return this.getResult(playerBiz.gamedataFind(pId,  pageable));
	}
	
	/**
	 * 游戏选手主要成就查询接口（接口 1.0.7）
	 * @param gId 游戏ID
	 * @param pid 游戏选手ID
	 * @param pageable
	 * @return
	 * @author 许小满  
	 * @date Oct 21, 2015 12:27:20 AM
	 */
	@RequestMapping(value = "/gamedata/achi")
	public @ResponseBody Object gameDataAchiSearch(
			     @RequestParam(value = "gid") long gId,
			     @RequestParam(value = "pid") long pId,
				@PageableDefaults(pageNumber=0, value=5, sort="createTime=desc") Pageable pageable) {
		return this.getResult(playerBiz.gameDataAchiSearch(gId, pId, pageable));
	}
	
}