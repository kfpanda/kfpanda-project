package com.kfpanda.hcloth.mapper;

public class CategorySql {
	
	public static final String TABLE_NAME = "category";
	public static final String FIELDS = "`id`,`createtime`,`name`,`category`";
	public static final String SAVE_FIELD = "`createtime`,`name`,`category`";
	public static final String BEAN_FIELD_NAME = "#{createTime},#{name},#{category}";
	
	public static final String SAVE_SQL = "INSERT INTO " + TABLE_NAME + "(" + SAVE_FIELD + ") VALUES(" + BEAN_FIELD_NAME + ")";
	public static final String DELBYID_SQL = "DELETE FROM " + TABLE_NAME + " WHERE id=#{id}";
	public static final String FINDBYID_SQL = "SELECT " + FIELDS + " FROM " + TABLE_NAME + " WHERE id=#{id}";
//	public static final String FINDBYCATEGORY_SQL = "SELECT " + FIELDS + " FROM " + TABLE_NAME + " WHERE category like concat('%',#{category},'%')";
	//public static final String FINDALL_SQL = "SELECT " + FIELDS + " FROM " + TABLE_NAME;
	public static final String FINDBYCATEGORY_SQL = "SELECT a.*, b.img AS thumb FROM category a,\n" +
		"(SELECT cid, MIN(`name`), img FROM cloth GROUP BY cid )b\n" +
		" WHERE a.id=b.cid and a.category like concat('%',#{category},'%')";
	
	public static final String FINDALL_SQL = "SELECT a.*, b.img AS thumb FROM category a,\n" +
			"(SELECT cid, MIN(`name`), img FROM cloth GROUP BY cid )b\n" +
			"WHERE a.id=b.cid";
}
