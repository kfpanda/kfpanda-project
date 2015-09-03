package com.kfpanda.gmatch.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import com.kfpanda.gmatch.bean.People;

public interface PeopleMapper {
	
	@Insert(PeopleSql.SAVE_SQL)
    int save(People people);
	
    @Delete(PeopleSql.DELBYID_SQL)
    int deleteById(Long id);
    
    @Select(PeopleSql.FINDBYID_SQL)
	People findOne(Long id);
    
    @Select(PeopleSql.FINDBYNAME_SQL)
    List<People> findByName(String name);
}