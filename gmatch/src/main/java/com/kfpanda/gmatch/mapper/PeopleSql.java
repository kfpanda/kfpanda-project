package com.kfpanda.gmatch.mapper;


public class PeopleSql {
	
	public static final String TABLE_NAME = "people";
	public static final String FIELDS = "`id`,`createtime`,`updatetime`,`name`,`age`,`country`,`sex`,`college`";
	public static final String SAVE_FIELD = "`createtime`,`updatetime`,`name`,`age`,`country`,`sex`,`college`";
	public static final String BEAN_FIELD_NAME = "#{createTime},#{updateTime},#{name},#{age},#{country},#{sex},#{college}";
	
	public static final String SAVE_SQL = "INSERT INTO " + TABLE_NAME + "(" + SAVE_FIELD + ") VALUES(" + BEAN_FIELD_NAME + ")";
	public static final String DELBYID_SQL = "DELETE FROM " + TABLE_NAME + " WHERE id=#{id}";
	public static final String FINDBYID_SQL = "SELECT " + FIELDS + " FROM " + TABLE_NAME + " WHERE id=#{id}";
	public static final String FINDBYNAME_SQL = "SELECT " + FIELDS + " FROM " + TABLE_NAME + " WHERE name=#{name}";
	
}
