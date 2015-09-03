package com.kfpanda.gmatch.action;

import java.sql.Timestamp;
import java.util.List;
import javax.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.kfpanda.gmatch.bean.People;
import com.kfpanda.gmatch.biz.PeopleBiz;

@Controller("peopleAction")
@RequestMapping("/people")
public class PeopleAction extends BaseAction{
	private static final Logger logger = LoggerFactory.getLogger(PeopleAction.class);
	
	@Resource(name="peopleBiz")
	private PeopleBiz peopleBiz;
	
	@RequestMapping(value = "/save")
	public @ResponseBody Object msgSend(@RequestParam(value = "name") String name,
			@RequestParam(value = "age", required=false) int age, @RequestParam(value = "country", required=false) String country,
			@RequestParam(value = "sex", required=false) int sex, @RequestParam(value = "college", required=false) String college) {
		
		if(StringUtils.isBlank(name)){
			return this.getResult(-1, "name is not empty or null.");
		}
		
		People people = new People();
		people.setCreateTime(new Timestamp(System.currentTimeMillis()));
		people.setUpdateTime(new Timestamp(System.currentTimeMillis()));
		people.setName(name);
		people.setAge(age);
		people.setCountry(country);
		if(sex == 1){
			people.setSex(true);
		}else{
			people.setSex(false);
		}
		people.setCollege(college);
		return this.getResult(peopleBiz.savePeople(people));
	}
	
	@RequestMapping(value = "/find")
	public @ResponseBody Object msgSearch(@RequestParam(value = "name") String name) {
		
		List<People> data = null;
		if(StringUtils.isBlank(name)){
			return this.getResult(-1, "name不能为空!");
		}
		data = peopleBiz.findByName(name);
		return this.getResult(data);
	}
	
}