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
	
	public static final String FINDFROMID_SQL = "SELECT hs.*, m.id as mid, m.name as mname, m.holder as mholder, m.size as msize, m.cycle as mcycle, m.level as mlevel, m.type as mtype," 
			+ " m.gid as gid FROM " + TABLE_NAME + " hs, `match` m WHERE hs.id=#{id} AND hs.mid=m.id";
	
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
	private static String PLAYERFIND_SQL = null;;
	public String getPlayFindSql(){
		if(PLAYERFIND_SQL != null){
			return PLAYERFIND_SQL;
		}
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT * FROM(")
					.append("SELECT h.id AS hid,p.id AS pid,p.cnname,")
					.append("(SELECT count(m1.id) FROM `match` m1 INNER JOIN hotsite h1 ON m1.id = h1.mid INNER JOIN player_hotsite ph1 ON h1.id = ph1.hid WHERE m1.id = h.mid AND ph1.pid = p.id) AS gametime,")
					.append("(SELECT h2. NAME FROM `match` m2 INNER JOIN hotsite h2 ON m2.id = h2.mid INNER JOIN hotsite_score hs2 ON hs2.hid = h2.id WHERE hs2.pid = p.id ORDER BY hs2.num LIMIT 1) AS sitebest,")
					.append("(SELECT hs2.num FROM `match` m2 INNER JOIN hotsite h2 ON m2.id = h2.mid INNER JOIN hotsite_score hs2 ON hs2.hid = h2.id WHERE hs2.pid = p.id ORDER BY hs2.num LIMIT 1) AS gamebest ")
				.append("FROM hotsite h INNER JOIN player_hotsite ph ON h.id = ph.hid INNER JOIN player p ON ph.pid = p.id ")
				.append("WHERE h.id =#{hId} ")
			.append("AND (#{score}= '-1' OR EXISTS (SELECT hs.id FROM hotsite_score hs WHERE hs.pid = p.id AND hs.num IN (#{score}) )) ")
			.append("AND (#{keyword} IS NULL OR p.cnname like concat('%',ifnull(#{keyword},''),'%') ) ")
		.append(") v ORDER BY v.gamebest LIMIT #{pageable.offset},#{pageable.pageSize}") ;
		//System.out.println("sql= "+sql.toString());
		PLAYERFIND_SQL = sql.toString();
		return PLAYERFIND_SQL;
	}
	
	//赛站奖励查询
	public static final String HOTSITERESULT_SQL = "select result from hotsite where id=#{hId}";
	
	//指定赛站成绩查询对应的选手
	public static final String PLAYERBYNUM_SQL = "select p.cnname from hotsite h inner join player_hotsite ph on ph.hid=h.id inner join player p on ph.pid=p.id "
			+ "inner join hotsite_score hs on (h.id=hs.hid and hs.pid=p.id) where h.id=#{hId} and hs.num=#{num}";
	
	//选手比赛场次胜率
	public static final String PLAYERCRATE_SQL = "select sum(v2.win_num) win_nums,sum(v2.lost_num) lost_nums,sum(v2.win_num)/count(v2.win_num)  as win_rate "
				+ "from (select case when v1.win_pid = #{pId}  then 1 else 0 end as win_num,case when v1.win_pid != #{pId}  then 1 else 0 end as lost_num "
				+ "from (select v.hid,v.round,v.pid1,v.pid2,case when v.a_win_num > v.b_win_num then v.pid1 else v.pid2 end as win_pid "
				+ "from (select ha.hid,ha.round,ha.pid1,ha.pid2,sum(case  when ha.result='A' then 1 else 0 end) as a_win_num,"
				+ "sum(case  when ha.result='B' then 1 else 0 end) as b_win_num from hotagainst ha where (ha.pid1 = #{pId} or ha.pid2 = #{pId} )group by ha.hid,ha.round,ha.pid1,ha.pid2)v)v1)v2";
	
	//选手比赛局数胜率
	public static final String PLAYERJRATE_SQL = "select sum(v1.win_num) win_nums,sum(v1.lost_num) lost_nums,sum(v1.win_num)/count(v1.win_num)  as win_rate "
					+ "from (select case when v.win_pid = #{pId}  then 1 else 0 end as win_num,case when v.win_pid != #{pId}  then 1 else 0 end as lost_num "
					+ "from (select ha.pid1,ha.pid2,case  when ha.result='A' then ha.pid1 else ha.pid2 end as win_pid from hotagainst ha where ha.pid1=#{pId}  or ha.pid2=#{pId} )v)v1";
	
	//选手各职业、套牌胜率
	public static final String PLAYEROCRATE_SQL = "select * from (select v1.occupation,sum(v1.win_num) win_nums,sum(v1.lost_num) lost_nums,sum(v1.win_num)/count(v1.win_num)  as win_rate "
				+ "from(select v.occupation,case when v.win_pid = #{pId}  then 1 else 0 end as win_num,case when v.win_pid != #{pId}  then 1 else 0 end as lost_num "
				+ "from (select case when ha.pid1=2 then concat(ha.occupation1,'（',ha.cards1,'）') else concat(ha.occupation2,'（',ha.cards2,'）') end as occupation,"
				+ "case  when ha.result='A' then ha.pid1 else ha.pid2 end as win_pid from hotagainst ha where ha.pid1=#{pId}  or ha.pid2=#{pId} )v)v1 "
				+ "group by v1.occupation)v2 order by v2.win_rate desc limit #{pageable.offset},#{pageable.pageSize}";
	
	
}
