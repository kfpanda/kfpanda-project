package com.kfpanda.gmatch.mapper;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.data.domain.Pageable;
import com.kfpanda.gmatch.bean.HotSite;

public interface HotSiteMapper {
	
	@Insert(HotSiteSql.SAVE_SQL)
    int save(HotSite hotSite);
	
    @Delete(HotSiteSql.DELBYID_SQL)
    int deleteById(Long id);
    
    @Select(HotSiteSql.FINDBYID_SQL)
    HotSite findOne(Long id);
    
    @SelectProvider(type = HotSiteSql.class, method = "findByGidName")
    List<Map<String, Object>> find(@Param("gId")Long gId, @Param("startDate")Long startDate, 
    		@Param("endDate")Long endDate, @Param("mName")String mName, @Param("pageable")Pageable pageable);
    
    //赛站选手查询
    @SelectProvider(type=HotSiteSql.class, method="getPlayFindSql")
    List<Map<String, Object>> playerFind(@Param("hId")Long hId, @Param("score")String score,@Param("keyword")String keyword, @Param("pageable")Pageable pageable);
    
    //赛站奖励查询
    @Select(HotSiteSql.HOTSITERESULT_SQL)
    String resultFind(@Param("hId")Long hId);
    
    //通过名称查询选手姓名
    @Select(HotSiteSql.PLAYERBYNUM_SQL)
    List<String> findPlayerNameByNum(@Param("hId")Long hId, @Param("num")Integer num);
    
    @Select(HotSiteSql.FINDFROMID_SQL)
    Map<String, Object> findById(Long id);
}