package com.kfpanda.gmatch.mapper;

public class PlayerHotSiteSql {
	
	public static final String TABLE_NAME = "player_hotsite";
	public static final String FIELDS = "`id`,`hid`,`pid`";
	public static final String SAVE_FIELD = "`hid`,`pid`";
	public static final String BEAN_FIELD_NAME = "#{hid},#{pid}";
	
	public static final String SAVE_SQL = "INSERT INTO " + TABLE_NAME + "(" + SAVE_FIELD + ") VALUES(" + BEAN_FIELD_NAME + ")";
	public static final String DELBYID_SQL = "DELETE FROM " + TABLE_NAME + " WHERE id=#{id}";
	public static final String FINDBYID_SQL = "SELECT " + FIELDS + " FROM " + TABLE_NAME + " WHERE id=#{id}";
	
	public static final String FINDBYHIDPID_SQL = "SELECT " + FIELDS + " FROM " + TABLE_NAME + " WHERE hid=#{hId} AND pid=#{pId}";
}
