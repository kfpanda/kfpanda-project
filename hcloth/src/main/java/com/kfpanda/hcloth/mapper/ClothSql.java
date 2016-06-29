package com.kfpanda.hcloth.mapper;

public class ClothSql {
	
	public static final String TABLE_NAME = "cloth";
	public static final String FIELDS = "`id`,`cid`,`createtime`,`name`,`img`,`design`,`composition`,`width`,`weight`,`country`,`resistance`,`flammability`,`shrinkage`,`washload`,`colour`,`environment`";
	public static final String SAVE_FIELD = "`cid`,`createtime`,`name`,`img`,`design`,`composition`,`width`,`weight`,`country`,`resistance`,`flammability`,`shrinkage`,`washload`,`colour`,`environment`";
	public static final String BEAN_FIELD_NAME = "#{cId},#{createTime},#{name},#{img},#{design},#{composition},#{width},#{weight},#{country},#{resistance},#{flammability},#{shrinkage},#{washload},#{colour},#{environment}";
	
	public static final String SAVE_SQL = "INSERT INTO " + TABLE_NAME + "(" + SAVE_FIELD + ") VALUES(" + BEAN_FIELD_NAME + ")";
	public static final String DELBYID_SQL = "DELETE FROM " + TABLE_NAME + " WHERE id=#{id}";
	public static final String FINDBYID_SQL = "SELECT " + FIELDS + " FROM " + TABLE_NAME + " WHERE id=#{id}";
	
	public static final String FINDBYCID_SQL = "SELECT " + FIELDS + " FROM " + TABLE_NAME + " WHERE cid=#{cId}";
	
}
