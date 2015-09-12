package com.kfpanda.gmatch.mapper;

public class HotSiteSql {
	
	public static final String TABLE_NAME = "hotsite";
	public static final String FIELDS = "`id`,`createtime`,`name`,`startdate`,`enddate`,`address`,`playernum`,`rule`,`registration`,`bonus`,`intro`,`result`,`mid`";
	public static final String SAVE_FIELD = "`createtime`,`createtime`,`name`,`startdate`,`enddate`,`address`,`playernum`,`rule`,`registration`,`bonus`,`intro`,`result`,`mid`";
	public static final String BEAN_FIELD_NAME = "#{createTime},#{name},#{startDate},#{endDate},#{address},#{playerNum},#{rule},#{registration},#{bonus},#{intro},#{result},#{mId}";
	
	public static final String SAVE_SQL = "INSERT INTO " + TABLE_NAME + "(" + SAVE_FIELD + ") VALUES(" + BEAN_FIELD_NAME + ")";
	public static final String DELBYID_SQL = "DELETE FROM " + TABLE_NAME + " WHERE id=#{id}";
	public static final String FINDBYID_SQL = "SELECT " + FIELDS + " FROM " + TABLE_NAME + " WHERE id=#{id}";
	
	public static final String FINDBYGID_SQL = "SELECT hs.*, m.id as mid, m.name as mname, m.holder as mholder, m.size as msize, m.cycle as mcycle, m.level as mlevel, m.type as mtype," 
			+ " m.gid as gid FROM hotsite hs, `match` m WHERE hs.mid=m.id AND m.gid=#{gId} AND m.name LIKE CONCAT('%',#{mName},'%') " 
			+ "AND hs.startdate > FROM_UNIXTIME(#{startDate}, '%Y-%m-%d %H:%i:%S') AND hs.enddate < FROM_UNIXTIME(#{endDate}, '%Y-%m-%d %H:%i:%S') " 
			+ " order by hs.startdate desc limit #{pageable.offset},#{pageable.pageSize}";
	
}
