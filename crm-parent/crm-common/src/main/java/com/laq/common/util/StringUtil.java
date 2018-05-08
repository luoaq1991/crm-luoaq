package com.laq.common.util;

import org.apache.commons.lang3.StringUtils;

/**
 *  字符串 工具类
 * @author Mr.YongGan.Zhang
 * @version 1.0.0
 * 
 */
public final class StringUtil {
	
	private StringUtil(){}

	/*
	 * 判断字符串是否为空
	 */
	public static boolean isEmpty(String str) {
		if (str != null) {
			str = str.trim();
		}
		return StringUtils.isEmpty(str);
	}

	/*
	 * 判断字符串是否非空
	 */
	public static boolean isNotEmpty(String str) {
		return !isEmpty(str);
	}

	/**
	 * 字符串切割
	 * @param str
	 * @param regex
	 * @return
	 */
	public  static synchronized String[] splitString (final String str, String regex) {
		if (isNotEmpty(str)) {
			return  str.split(regex);
		}
		return  null;
	}
	
}
