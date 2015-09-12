package com.kfpanda.gmatch.mapper;

public class MatchSql {
	
	public static final String TABLE_NAME = "`match`";
	public static final String FIELDS = "`id`,`createtime`,`name`,`holder`,`size`,`cycle`,`level`,`type`,`gid`";
	public static final String SAVE_FIELD = "`createtime`,`name`,`holder`,`size`,`cycle`,`level`,`type`,`gid`";
	public static final String BEAN_FIELD_NAME = "#{createTime},#{name},#{holder},#{size},#{cycle},#{level},#{type},#{gId}";
	
	public static final String SAVE_SQL = "INSERT INTO " + TABLE_NAME + "(" + SAVE_FIELD + ") VALUES(" + BEAN_FIELD_NAME + ")";
	public static final String DELBYID_SQL = "DELETE FROM " + TABLE_NAME + " WHERE id=#{id}";
	public static final String FINDBYID_SQL = "SELECT " + FIELDS + " FROM " + TABLE_NAME + " WHERE id=#{id}";
	
}
