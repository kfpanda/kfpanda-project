package com.kfpanda.gmatch.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import com.kfpanda.gmatch.bean.Match;

public interface MatchMapper {
	
	@Insert(MatchSql.SAVE_SQL)
    int save(Match match);
	
    @Delete(MatchSql.DELBYID_SQL)
    int deleteById(Long id);
    
    @Select(MatchSql.FINDBYID_SQL)
    Match findOne(Long id);
    
}