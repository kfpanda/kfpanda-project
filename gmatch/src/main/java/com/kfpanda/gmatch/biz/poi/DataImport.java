package com.kfpanda.gmatch.biz.poi;

import java.io.File;
import java.sql.Timestamp;
import java.util.Collection;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.kfpanda.gmatch.bean.HotAgainst;
import com.kfpanda.gmatch.bean.Player;
import com.kfpanda.gmatch.bean.PlayerHotSite;
import com.kfpanda.gmatch.bean.poi.HotAgainstPoi;
import com.kfpanda.gmatch.mapper.HotAgainstMapper;
import com.kfpanda.gmatch.mapper.PlayerHotSiteMapper;
import com.kfpanda.gmatch.mapper.PlayerMapper;
import com.util.common.poi.ExcelUtil;

@Repository
public class DataImport {
	private static final Logger logger = LoggerFactory.getLogger(DataImport.class);
	
	@Resource
	private HotAgainstMapper hotAgainstMapper;
	@Resource
	private PlayerMapper playerMapper;
	@Resource
	private PlayerHotSiteMapper playerHotSiteMapper;
	
	@Transactional
	public void hotAgainstImport(String filePath){
		ExcelUtil<HotAgainstPoi> util = new ExcelUtil(HotAgainstPoi.class);
		Collection<HotAgainstPoi> list = null;
		try {
			list = util.importExcel(new File(filePath), "yyyy.MM.dd");
		} catch (Exception e) {
			logger.error("数据导入失败，", e);
			return ;
		}
		int num = 0;
		for(HotAgainstPoi poi : list){
			if(poi.getRound() != null && poi.getNum() != null){
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				num++;
				//游戏玩家添加
				Player player1 = playerMapper.findByName(poi.getP1Name(), null);
				if(player1 == null){
					player1 = new Player();
					player1.setCnName(poi.getP1Name());
					player1.setCreateTime(new Timestamp(System.currentTimeMillis()));
					player1.setGId(new Long(1));
					player1.setPId(new Long(1));
					playerMapper.save(player1);
				}
				Player player2 = playerMapper.findByName(poi.getP1Name(), null);
				if(player2 == null){
					player2 = new Player();
					player2.setCnName(poi.getP1Name());
					player2.setCreateTime(new Timestamp(System.currentTimeMillis()));
					player2.setGId(new Long(1));
					player2.setPId(new Long(1));
					playerMapper.save(player2);
				}
				poi.setPId1(player1.getId());
				poi.setPId2(player2.getId());
				
				//创建玩家 和 游戏关系
				PlayerHotSite playerHotSite1 = playerHotSiteMapper.findByHidPid(poi.getHId(), player1.getId());
				if(playerHotSite1 != null){
					playerHotSite1.sethId(poi.getHId());
					playerHotSite1.setpId(player1.getId());
					playerHotSiteMapper.save(playerHotSite1);
				}
				PlayerHotSite playerHotSite2 = playerHotSiteMapper.findByHidPid(poi.getHId(), player2.getId());
				if(playerHotSite2 != null){
					playerHotSite2.sethId(poi.getHId());
					playerHotSite2.setpId(player2.getId());
					playerHotSiteMapper.save(playerHotSite2);
				}
				
				//添加赛站对战记录
				HotAgainst hotAgainst = parseHotAgainst(poi);
				hotAgainstMapper.save(hotAgainst);
				
				System.out.println("导入记录数：" + num);
			}
		}
		System.out.println("导入记录数：" + num);
	}
	
	public HotAgainst parseHotAgainst(HotAgainstPoi poi){
		HotAgainst hotAgainst = new HotAgainst();
		hotAgainst.setId(poi.getId());
		hotAgainst.setCreateTime(new Timestamp(System.currentTimeMillis()));
		hotAgainst.setPId1(poi.getPId1());
		hotAgainst.setPId2(poi.getPId2());
		hotAgainst.setOccupation1(poi.getOccupation1());
		hotAgainst.setOccupation2(poi.getOccupation2());
		hotAgainst.setCards1(poi.getCards1());
		hotAgainst.setCards2(poi.getCards2());
		hotAgainst.setResult(poi.getResult());
		hotAgainst.setFirst(poi.getFirst());
		hotAgainst.setRound(poi.getRound());
		hotAgainst.setKoNum(poi.getKoNum());
		hotAgainst.setVideoUrl(poi.getVideoUrl());
		hotAgainst.setHId(poi.getHId());
		hotAgainst.setNum(poi.getNum());
		
		return hotAgainst;
	}
	
	public static void main(String[] args) throws Exception {
		String filePath = "C:/workspace/second/kfpanda-project/gmatch/docs/数据源文件-20151009/2015炉石黄金赛福州站1.0.xls";
//		DataImport.hotAgainstImport(filePath);
	}
}
