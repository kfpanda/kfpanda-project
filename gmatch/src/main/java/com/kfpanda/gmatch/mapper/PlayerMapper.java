package com.kfpanda.gmatch.mapper;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.data.domain.Pageable;
import com.kfpanda.gmatch.bean.Player;

public interface PlayerMapper {
	
	@Insert(PlayerSql.SAVE_SQL)
    int save(Player player);
	
    @Delete(PlayerSql.DELBYID_SQL)
    int deleteById(Long id);
    
    @Select(PlayerSql.FINDBYID_SQL)
	Player findOne(Long id);
    
    @SelectProvider(type = PlayerSql.class, method = "findByGidName")
    List<Map<String, Object>> findByGidName(@Param("gId")Long gId, @Param("cnName")String cnName, 
    		@Param("enName")String enName, @Param("pageable")Pageable pageable);
    
	//选手查询
    @SelectProvider(type = PlayerSql.class, method = "findByName")
    Player findByName(@Param("cnName")String cnName, @Param("enName")String enName);
    
    //选手比赛场次胜率
    @Select(HotSiteSql.PLAYERCRATE_SQL)
    List<Map<String, Object>> findCRate(@Param("pId")Long pId);
    
   //选手比赛局数胜率
    @Select(HotSiteSql.PLAYERJRATE_SQL)
    List<Map<String, Object>> findJRate(@Param("pId")Long pId);
    
    //选手各职业、套牌胜率
    @Select(HotSiteSql.PLAYEROCRATE_SQL)
    List<Map<String, Object>> findOCRate(@Param("pId")Long pId, @Param("pageable")Pageable pageable);
    
}