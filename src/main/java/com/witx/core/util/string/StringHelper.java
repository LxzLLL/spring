package com.witx.core.util.string;

public class StringHelper {

	/**
	 * 判断字符串是否为null或者为""
	 * @param str 字符串
	 * @return
	 */
	public static boolean isNoneOrEmpty(String str){
		//默认不为null或""
		boolean bln = false;
		if(str ==null || "".equals(str)){
			bln = true;
		}
		return bln;
	}
}
