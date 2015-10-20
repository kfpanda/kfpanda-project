package com.kfpanda.gmatch.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import com.kfpanda.gmatch.bean.HotAgainst;

public interface HotAgainstMapper {
	
	@Insert(HotAgainstSql.SAVE_SQL)
    int save(HotAgainst hotAgainst);
	
    @Delete(HotAgainstSql.DELBYID_SQL)
    int deleteById(Long id);
    
    @Select(HotAgainstSql.FINDBYID_SQL)
    HotAgainst findOne(Long id);
    
}