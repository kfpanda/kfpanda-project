package com.kfpanda.gmatch.mapper;

import java.util.Map;

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
	
	public String findByGidName(Map<String, Object> param){
		String sql = "SELECT hs.*, m.id as mid, m.name as mname, m.holder as mholder, m.size as msize, m.cycle as mcycle, m.level as mlevel, m.type as mtype," 
				+ " m.gid as gid FROM hotsite hs, `match` m WHERE hs.mid=m.id AND m.gid=#{gId} ";
		if(param.get("mName") != null){
			sql += " AND m.name LIKE CONCAT('%',#{mName},'%')";
		}
		sql += " AND hs.startdate > FROM_UNIXTIME(#{startDate}, '%Y-%m-%d %H:%i:%S') AND hs.enddate < FROM_UNIXTIME(#{endDate}, '%Y-%m-%d %H:%i:%S') " 
				+ " order by hs.startdate desc limit #{pageable.offset},#{pageable.pageSize}";
		return sql;
	}
	
	//赛站选手查询
	public static final String PLAYERFIND_SQL = "select * from (select h.id as hid,p.id as pid,p.cnname,(select count(m1.id) from `match` m1 inner join hotsite h1 on m1.id=h1.mid "
			+ "inner join player_hotsite ph1 on h1.id=ph1.hid where m1.id=h.mid and ph1.pid=p.id) as gametime,(select h2.name from `match` m2 "
			+ "inner join hotsite h2 on m2.id=h2.mid inner join hotsite_score hs2 on hs2.hid=h2.id where hs2.pid=p.id order by hs2.num limit 1 ) as sitebest,(select hs2.num from `match` m2 "
			+ "inner join hotsite h2 on m2.id=h2.mid inner join hotsite_score hs2 on hs2.hid=h2.id where hs2.pid=p.id order by hs2.num limit 1 ) as gamebest from hotsite h "
			+ "inner join player_hotsite ph on h.id=ph.hid inner join player p on ph.pid=p.id where h.id=#{hId} and (#{score}='-1' or exists(select hs.id from hotsite_score hs "
			+ "where hs.pid=p.id and hs.num in (${score}))) )v order by v.gamebest limit #{pageable.offset},#{pageable.pageSize}";
	
	//赛站奖励查询
	public static final String HOTSITERESULT_SQL = "select result from hotsite where id=#{hId}";
	
	//指定赛站成绩查询对应的选手
	public static final String PLAYERBYNUM_SQL = "select p.cnname from hotsite h inner join player_hotsite ph on ph.hid=h.id inner join player p on ph.pid=p.id "
			+ "inner join hotsite_score hs on (h.id=hs.hid and hs.pid=p.id) where h.id=#{hId} and hs.num=#{num}";
}
