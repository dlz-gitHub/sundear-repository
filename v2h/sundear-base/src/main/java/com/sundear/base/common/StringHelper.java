package com.sundear.base.common;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 顾余
 *
 */
public class StringHelper {

	public static String textareaToHtml(String str) {
		str = str.replaceAll("\r\n", "<br>");
		str = str.replaceAll("\n\r", "<br>");
		str = str.replaceAll("\r\n", "<br>");
		str = str.replaceAll("\r", "<br>");
		str = str.replaceAll("\n", "<br>");
		str = str.replaceAll("\t", "    ");
		return str;
	}

	public static boolean isStringNull(String name) {
		if (name == null || name.trim().equals("")) {
			return true;
		} else {

		}

		return false;
	}

	public static String request2String(String string) {
		String str = "";

		if (string == null) {
			return str;
		} else {
			str = string;
		}
		return str.trim();
	}

	/**
	 * @param 传入值
	 * @return 过滤后的字符串
	 */
	public static String request2SafeString(String string) {
		if (string == null||string.equals("")) {
			return "";
		} else {
	        string=repalceUnSafeSql(string,"update");
	        string=repalceUnSafeSql(string,"insert");
	        string=repalceUnSafeSql(string,"delete");
	        
			return string;
		}
	}

	/**
	 * @param 生成字符串的长度
	 * @return 随机最非常
	 */
	public static String getRandomString(int length) {
		String ku = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "";
		StringBuilder newStr = new StringBuilder();
		Random r = new Random();
		for (int j = 0; j < length; j++) {
			int r2 = r.nextInt(ku.length());
			newStr.append(ku.charAt(r2));
		}
		return newStr.toString();

	}

	public static String getRandomNum(int length) {
		String ku = "0123456789" + "";
		StringBuilder newStr = new StringBuilder();
		Random r = new Random();
		for (int j = 0; j < length; j++) {
			int r2 = r.nextInt(ku.length());
			newStr.append(ku.charAt(r2));
		}
		return newStr.toString();
	}
	/**预防sql注入攻击的单词替换
	 * 
	 * @param string
	 * @param regex
	 * @return
	 */
	public static String repalceUnSafeSql(String string,String regex) {
		if (string == null||regex==null||string.equals("")||regex.equals("")) {
			return "";
		} else {
	        regex = "\\s*(?i)"+regex+"\\s*";
	        Pattern p = Pattern.compile(regex);  
	        Matcher m = p.matcher( string );
	        while (m.find()) {
		        string = string.replaceAll(regex, m.group(0).replace(" ", ""));
	        } 
			return string;
		}
	}

}
