package com.kfpanda.gmatch.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import com.kfpanda.gmatch.bean.PlayerHotSite;

public interface PlayerHotSiteMapper {
	
	@Insert(PlayerHotSiteSql.SAVE_SQL)
    int save(PlayerHotSite playerHotSite);
	
    @Delete(PlayerHotSiteSql.DELBYID_SQL)
    int deleteById(Long id);
    
    @Select(PlayerHotSiteSql.FINDBYID_SQL)
    PlayerHotSite findOne(Long id);
    
    @Select(PlayerHotSiteSql.FINDBYHIDPID_SQL)
    PlayerHotSite findByHidPid(@Param("hId")Long hId, @Param("pId")Long pId);
}