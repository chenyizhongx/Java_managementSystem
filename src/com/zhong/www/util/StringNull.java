package com.zhong.www.util;
/**
 * �жϵ�¼ʱ������û����������Ƿ�Ϊ�գ���Ϊ���򵯳�������ʾ
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
