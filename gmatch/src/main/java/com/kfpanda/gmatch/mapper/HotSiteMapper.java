package com.kfpanda.gmatch.mapper;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.domain.Pageable;
import com.kfpanda.gmatch.bean.HotSite;

public interface HotSiteMapper {
	
	@Insert(HotSiteSql.SAVE_SQL)
    int save(HotSite hotSite);
	
    @Delete(HotSiteSql.DELBYID_SQL)
    int deleteById(Long id);
    
    @Select(HotSiteSql.FINDBYID_SQL)
    HotSite findOne(Long id);
    
    @Select(HotSiteSql.FINDBYGID_SQL)
    List<Map<String, Object>> find(@Param("gId")Long gId, @Param("startDate")Long startDate, 
    		@Param("endDate")Long endDate, @Param("mName")String mName, @Param("pageable")Pageable pageable);
    
    //赛站选手查询
    @Select(HotSiteSql.PLAYERFIND_SQL)
    List<Map<String, Object>> playerFind(@Param("hId")Long hId, @Param("score")String score, @Param("pageable")Pageable pageable);
    
    //赛站奖励查询
    @Select(HotSiteSql.HOTSITERESULT_SQL)
    String resultFind(@Param("hId")Long hId);
}