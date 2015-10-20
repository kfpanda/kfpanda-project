package com.kfpanda.gmatch.mapper;

public class HotAgainstSql {
	
	public static final String TABLE_NAME = "hotagainst";
	public static final String FIELDS = "`id`,`createtime`,`pid1`,`pid2`,`occupation1`,`occupation2`,`cards1`,`cards2`,`result`,`first`,`round`,`konum`,`videourl`,`hid`,`num`";
	public static final String SAVE_FIELD = "`createtime`,`pid1`,`pid2`,`occupation1`,`occupation2`,`cards1`,`cards2`,`result`,`first`,`round`,`konum`,`videourl`,`hid`,`num`";
	public static final String BEAN_FIELD_NAME = "#{createTime},#{pId1},#{pId2},#{occupation1},#{occupation2},#{cards1},#{cards2},#{result},#{first},#{round},#{koNum},#{videoUrl},#{hId},#{num}";
	
	public static final String SAVE_SQL = "INSERT INTO " + TABLE_NAME + "(" + SAVE_FIELD + ") VALUES(" + BEAN_FIELD_NAME + ")";
	public static final String DELBYID_SQL = "DELETE FROM " + TABLE_NAME + " WHERE id=#{id}";
	public static final String FINDBYID_SQL = "SELECT " + FIELDS + " FROM " + TABLE_NAME + " WHERE id=#{id}";
	
}
