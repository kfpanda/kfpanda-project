package com.kfpanda.hcloth.mapper;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import com.kfpanda.hcloth.bean.Cloth;

public interface ClothMapper {
	
	@Insert(ClothSql.SAVE_SQL)
    int save(Cloth player);
	
    @Delete(ClothSql.DELBYID_SQL)
    int deleteById(Long id);
    
    @Select(ClothSql.FINDBYID_SQL)
	Cloth findOne(Long id);
    
    @Select(ClothSql.FINDBYCID_SQL)
    List<Map<String, Object>> findByCID(@Param("cId")Long cId);
    
}