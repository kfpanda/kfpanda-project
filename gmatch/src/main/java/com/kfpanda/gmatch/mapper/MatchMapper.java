package com.kfpanda.gmatch.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import com.kfpanda.gmatch.bean.HotSite;

public interface MatchMapper {
	
	@Insert(HotSiteSql.SAVE_SQL)
    int save(HotSite hotSite);
	
    @Delete(HotSiteSql.DELBYID_SQL)
    int deleteById(Long id);
    
    @Select(HotSiteSql.FINDBYID_SQL)
    HotSite findOne(Long id);
    
}