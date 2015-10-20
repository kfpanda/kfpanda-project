package com.kfpanda.gmatch.mapper;

import java.util.Map;

public class PlayerSql {
	
	public static final String TABLE_NAME = "player";
	public static final String FIELDS = "`id`,`createtime`,`cnname`,`enname`,`gamebest`,`favourite`,`pid`,`gid`";
	public static final String SAVE_FIELD = "`createtime`,`cnname`,`enname`,`gamebest`,`favourite`,`pid`,`gid`";
	public static final String BEAN_FIELD_NAME = "#{createTime},#{cnName},#{enName},#{gameBest},#{favourite},#{pId},#{gId}";
	
	public static final String SAVE_SQL = "INSERT INTO " + TABLE_NAME + "(" + SAVE_FIELD + ") VALUES(" + BEAN_FIELD_NAME + ")";
	public static final String DELBYID_SQL = "DELETE FROM " + TABLE_NAME + " WHERE id=#{id}";
	public static final String FINDBYID_SQL = "SELECT " + FIELDS + " FROM " + TABLE_NAME + " WHERE id=#{id}";
	
	/*public String findByGidName(Map<String, Object> param){
		String sql = "SELECT p.*, aa.scorenum, aa.sname, " 
				+" (SELECT h.name FROM player_hotsite ph, hotsite h WHERE ph.pid=p.id AND ph.hid=h.id ORDER BY startdate DESC LIMIT 0,1) AS lastsname"
				+ " FROM " + TABLE_NAME + " p, (SELECT MAX(hs.num) AS scorenum, h.name AS sname, hs.pid AS pid FROM hotsite_score hs, hotsite h WHERE hs.pid='1' AND hs.hid=h.id )aa WHERE p.id=aa.pid AND p.gid=#{gId} ";
		if(param.get("cnName") != null){
			sql += " AND p.cnname like CONCAT('%',#{cnName},'%') ";
		}
		if(param.get("enName") != null){
			sql += " AND p.enname like CONCAT('%',#{enName},'%') ";
		}
		sql += " order by p.createtime desc limit #{pageable.offset},#{pageable.pageSize}";
		return sql;
	}*/
	
	public String findByGidName(Map<String, Object> param){
		String sql = " SELECT MIN(hs.num) AS scorenum, h.name AS sname, p.*, (SELECT h.name FROM hotsite_score hs, hotsite h" 
					+" WHERE hs.pid=pid AND hs.hid=h.id ORDER BY h.startdate DESC LIMIT 0,1) AS lastsname"
					+" FROM player p LEFT JOIN hotsite_score hs ON p.id=hs.pid LEFT JOIN hotsite h ON hs.hid=h.id "
					+" WHERE p.gid=#{gId} ";
		if(param.get("cnName") != null){
			sql += " AND p.cnname like CONCAT('%',#{cnName},'%') ";
		}
		if(param.get("enName") != null){
			sql += " AND p.enname like CONCAT('%',#{enName},'%') ";
		}
		sql += " GROUP BY p.id,h.name ORDER BY h.createtime DESC, hs.num limit #{pageable.offset},#{pageable.pageSize}";
		return sql;
	}
	
	public String findByName(Map<String, Object> param){
		String sql = "SELECT * FROM player WHERE 1=1 ";
		if(param.get("cnName") != null){
			sql += " AND cnname=#{cnName} ";
		}
		if(param.get("enName") != null){
			sql += " AND enname=#{enName} ";
		}
		return sql;
	}
	
	//游戏选手主要成就查询接口（接口 1.0.7）
		public static final String PLAYEROCRATE_SQL = "SELECT h.name,h.result,hs.num,hs.createtime  "
				+ "FROM `match` m INNER JOIN hotsite h on m.id=h.mid INNER JOIN hotsite_score hs on h.id=hs.hid "
				+ "WHERE m.gid=#{gId} AND hs.pid=#{pId} ORDER BY hs.createtime desc limit #{pageable.offset},#{pageable.pageSize}";
	
}
