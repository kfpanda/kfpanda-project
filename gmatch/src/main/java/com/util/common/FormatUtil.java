package com.util.common;

import com.kfpanda.util.StringUtils;

/**   
* @Description:  数据格式化工具类
* @Title: FormatUtil.java 
* @Package com.util.common 
* @author 许小满 
* @date Oct 21, 2015 1:05:57 AM
* @version V1.0   
*/
public class FormatUtil {

	/**
	 * 格式化比赛结果
	 * @param  例如：1 冠军 50，000RMB;2 亚军 10，000RMB;3 季军 8，000RMB;4 殿军 5000RMB;8 8强 5000RMB
	 * @author 许小满  
	 * @date Oct 21, 2015 1:07:14 AM
	 */
	public static String formatResult(Integer num, String result){
		if(num == null)
			return StringUtils.EMPTY;
		if(StringUtils.isBlank(result)){
			return num +"强";
		}
		String[] resultArray = result.split(";");
		int maxLength = resultArray != null ? resultArray.length : 0;
		for(int i=0; i<maxLength; i++){
			String[] itemArray = resultArray[i].split(" ");
			if(num == Integer.parseInt(itemArray[0])){
				return itemArray[1];
			}
		}
		return num +"强";
	}
	
}
