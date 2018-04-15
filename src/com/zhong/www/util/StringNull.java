package com.zhong.www.util;
/**
 * 判断输入是否为空
 * @author zhong
 *
 */
public class StringNull {
	/*
	 * 判断是否为空
	 */
	public static boolean isEmply(String str) {
		//字符串为空或者去掉空格后为空
		if(str == null || "".equals(str.trim())) {
			return true;
		}else {
			return false;
		}
	}
	
	/*
	 * 判断是否不为空	
	 */
	public static boolean isNoEmply(String str) {
		if(str != null && !"".equals(str.trim())) {
			return true;
		}else {
			return false;
		}
	}
}
