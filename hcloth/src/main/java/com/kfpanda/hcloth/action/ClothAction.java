package com.kfpanda.hcloth.action;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kfpanda.hcloth.biz.ClothBiz;

@Controller("clothAction")
@RequestMapping("/cloth")
public class ClothAction extends BaseAction{
	private static final Logger logger = LoggerFactory.getLogger(ClothAction.class);
	
	@Resource(name="clothBiz")
	private ClothBiz clothBiz;
	
	@RequestMapping(value = "/list")
	public @ResponseBody Object list(@RequestParam("cid")Long cId) {
		return this.getResult(clothBiz.findByCID(cId.longValue()));
	}
	
	@RequestMapping(value = "/info")
	public @ResponseBody Object info(@RequestParam("clid")Long id) {
		return this.getResult(clothBiz.findOne(id));
	}
	
}