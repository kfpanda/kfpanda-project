package com.kfpanda.hcloth.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.kfpanda.hcloth.bean.Category;

public interface CategoryMapper {
	
	@Insert(CategorySql.SAVE_SQL)
    int save(Category player);
	
    @Delete(CategorySql.DELBYID_SQL)
    int deleteById(Long id);
    
    @Select(CategorySql.FINDBYID_SQL)
	Category findOne(Long id);

    @Select(CategorySql.FINDBYCATEGORY_SQL)
    List<Category> findByCategory(String category);
    
    @Select(CategorySql.FINDALL_SQL)
	List<Category> findAll();
    
}