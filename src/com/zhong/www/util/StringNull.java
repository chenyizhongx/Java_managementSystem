package com.zhong.www.util;
/**
 * �ж������Ƿ�Ϊ��
 * @author zhong
 *
 */
public class StringNull {
	/*
	 * �ж��Ƿ�Ϊ��
	 */
	public static boolean isEmply(String str) {
		//�ַ���Ϊ�ջ���ȥ���ո��Ϊ��
		if(str == null || "".equals(str.trim())) {
			return true;
		}else {
			return false;
		}
	}
	
	/*
	 * �ж��Ƿ�Ϊ��	
	 */
	public static boolean isNoEmply(String str) {
		if(str != null && !"".equals(str.trim())) {
			return true;
		}else {
			return false;
		}
	}
}
