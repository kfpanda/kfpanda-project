package com.kfpanda.gmatch.mapper;

import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Pageable;


public class PlayerSql {
	
	public static final String TABLE_NAME = "player";
	public static final String FIELDS = "`id`,`createtime`,`cnname`,`enname`,`gamebest`,`favourite`,`pid`,`gid`";
	public static final String SAVE_FIELD = "`createtime`,`cnname`,`enname`,`gamebest`,`favourite`,`pid`,`gid`";
	public static final String BEAN_FIELD_NAME = "#{createTime},#{cnName},#{enName},#{gameBest},#{favourite},#{pId},#{gId}";
	
	public static final String SAVE_SQL = "INSERT INTO " + TABLE_NAME + "(" + SAVE_FIELD + ") VALUES(" + BEAN_FIELD_NAME + ")";
	public static final String DELBYID_SQL = "DELETE FROM " + TABLE_NAME + " WHERE id=#{id}";
	public static final String FINDBYID_SQL = "SELECT " + FIELDS + " FROM " + TABLE_NAME + " WHERE id=#{id}";
	
	public String findByGidName(Map<String, Object> param){
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
	}
	
}
