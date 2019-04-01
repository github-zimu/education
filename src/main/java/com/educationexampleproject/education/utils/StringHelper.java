package com.educationexampleproject.education.utils;


/**
 * 本类作为注释类说明类
 * 字符处理常用方法
 * @author @author 张志高
 */
public class StringHelper {
	/**
	 * 判断字符串是否为空
	 * 
	 * <pre>
	 * boolean isEmpty = StringUtil.isEmpty(string);
	 * </pre>
	 * @param string
	 *            需要判断的字符串
	 * @return false不为空，true为空
	 */
	public static boolean isEmpty(String string) {
		return isEmpty(string, false);
	}

	/**
	 * 判断字符串是否为空，判空前是否先去除前后空格
	 * @param string
	 * @param trim
	 *            是否去除前后空格
	 * @return
	 */
	public static boolean isEmpty(String string,boolean trim) {
		if(string == null)
			return true;
		if(trim) {
			return "".equals(string.trim());
		} else {
			return "".equals(string);
		}
	}

	/**
	 * 判断字符串是否不为空
	 * @param string
	 *            需要判断的字符串
	 * @return false为空，true不为空
	 */
	public static boolean isNotEmpty(String string) {
		return !isEmpty(string);

	}

	/**
	 * 判断字符串是否不为空，判空前是否先去除前后空格
	 * @param string
	 * @param trim
	 * @return
	 */
	public static boolean isNotEmpty(String string,boolean trim) {
		return !isEmpty(string, trim);
	}

	/**
	 * 将字符串解析成int值，如果解析不成功则返回默认值
	 * @param string
	 *            字符串
	 * @param value
	 *            默认值
	 * @return 解析后的值
	 */
	public static int parseInt(String string,int value) {
		try {
			return Integer.parseInt(string);
		} catch (NumberFormatException e) {
			return value;
		}
	}
}
