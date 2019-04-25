package com.sundear.base.common;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class EnumHelper {
	/**
	 * 根据反射，通过方法名称获取方法值，忽略大小写的
	 * 
	 * @param methodName
	 * @param obj
	 * @param args
	 * @return return value
	 */
	private static <T> Object getMethodValue(String methodName, T obj, Object... args) {
		Object resut = "";
		try {
			/********************************* start *****************************************/
			Method[] methods = obj.getClass().getMethods(); // 获取方法数组，这里只要共有的方法
			if (methods.length <= 0) {
				return resut;
			}
			Method method = null;
			for (int i = 0, len = methods.length; i < len; i++) {
				if (methods[i].getName().equalsIgnoreCase(methodName)) { // 忽略大小写取方法
					// isHas = true;
					methodName = methods[i].getName(); // 如果存在，则取出正确的方法名称
					method = methods[i];
					break;
				}
			}
			if (method == null) {
				return resut;
			}
			resut = method.invoke(obj, args); // 方法执行
			if (resut == null) {
				resut = "";
			}
			return resut; // 返回结果
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resut;
	}

	/**
	 * 通过value值获取对应的描述信息
	 * 
	 * @param value
	 * @param enumT
	 * @param method
	 * @return enum description
	 */
	public static <T> Object getEnumNameByValue(Object value, Class<T> enumT, String... methodNames) {
		if (!enumT.isEnum()) { // 不是枚举则返回""
			return "";
		}
		T[] enums = enumT.getEnumConstants(); // 获取枚举的所有枚举属性，似乎这几句也没啥用，一般既然用枚举，就一定会添加枚举属性
		if (enums == null || enums.length <= 0) {
			return "";
		}
		int count = methodNames.length;
		String valueMathod = "getValue"; // 默认获取枚举value方法，与接口方法一致
		String nameMathod = "getName"; // 默认获取枚举description方法
		if (count >= 1 && !"".equals(methodNames[0])) {
			valueMathod = methodNames[0];
		}
		if (count == 2 && !"".equals(methodNames[1])) {
			nameMathod = methodNames[1];
		}
		for (int i = 0, len = enums.length; i < len; i++) {
			T t = enums[i];
			try {
				Object resultValue = getMethodValue(valueMathod, t);// 获取枚举对象value
				if (resultValue.toString().equals(value + "")) {
					Object resultDes = getMethodValue(nameMathod, t); // 存在则返回对应描述
					return resultDes;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "";
	}

	/**
	 * 通过枚举value或者自定义值及方法获取枚举属性值
	 * 
	 * @param value
	 * @param enumT
	 * @param method
	 * @return enum key
	 */
	public static <T> String getEnumKeyByValue(Object value, Class<T> enumT, String... methodNames) {
		if (!enumT.isEnum()) {
			return "";
		}
		T[] enums = enumT.getEnumConstants();
		if (enums == null || enums.length <= 0) {
			return "";
		}
		int count = methodNames.length;
		String valueMathod = "getValue"; // 默认方法
		if (count >= 1 && !"".equals(methodNames[0])) { // 独立方法
			valueMathod = methodNames[0];
		}
		for (int i = 0, len = enums.length; i < len; i++) {
			T tobj = enums[i];
			try {
				Object resultValue = getMethodValue(valueMathod, tobj);
				if (resultValue != null && resultValue.toString().equals(value + "")) { // 存在则返回对应值
					return tobj + "";
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "";
	}

	/**
	 * 枚举转map结合value作为map的key,description作为map的value
	 * 
	 * @param enumT
	 * @param method
	 * @return  Map<Object, String>
	 */
	public static <T> Map<Object, String> EnumToMap(Class<T> enumT, String... methodNames) {
		Map<Object, String> enummap = new HashMap<Object, String>();
		if (!enumT.isEnum()) {
			return enummap;
		}
		T[] enums = enumT.getEnumConstants();
		if (enums == null || enums.length <= 0) {
			return enummap;
		}
		int count = methodNames.length;
		String valueMathod = "getValue"; // 默认接口value方法
		String nameMathod = "getName";// 默认接口description方法
		if (count >= 1 && !"".equals(methodNames[0])) { // 扩展方法
			valueMathod = methodNames[0];
		}
		if (count == 2 && !"".equals(methodNames[1])) {
			nameMathod = methodNames[1];
		}
		for (int i = 0, len = enums.length; i < len; i++) {
			T tobj = enums[i];
			try {
				Object resultValue = getMethodValue(valueMathod, tobj); // 获取value值
				if ("".equals(resultValue)) {
					continue;
				}
				Object resultDes = getMethodValue(nameMathod, tobj); // 获取description描述值
				if ("".equals(resultDes)) { // 如果描述不存在获取属性值
					resultDes = tobj;
				}
				enummap.put(resultValue, resultDes + "");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return enummap;
	}
	/**
	 * 将枚举转换成map
	 * 
	 * @param enumT
	 * @param method
	 * @return Map<String, String>
	 */
	public static <T> Map<String, String> EnumToMapString(Class<T> enumT, String... methodNames) {
		Map<String, String> enummap = new HashMap<String, String>();
		if (!enumT.isEnum()) {
			return enummap;
		}
		T[] enums = enumT.getEnumConstants();
		if (enums == null || enums.length <= 0) {
			return enummap;
		}
		int count = methodNames.length;
		String valueMathod = "getValue"; // 默认接口value方法
		String nameMathod = "getName";// 默认接口description方法
		if (count >= 1 && !"".equals(methodNames[0])) { // 扩展方法
			valueMathod = methodNames[0];
		}
		if (count == 2 && !"".equals(methodNames[1])) {
			nameMathod = methodNames[1];
		}
		for (int i = 0, len = enums.length; i < len; i++) {
			T tobj = enums[i];
			try {
				Object resultValue = getMethodValue(valueMathod, tobj); // 获取value值
				if ("".equals(resultValue)) {
					continue;
				}
				Object resultDes = getMethodValue(nameMathod, tobj); // 获取description描述值
				if ("".equals(resultDes)) { // 如果描述不存在获取属性值
					resultDes = tobj;
				}
				enummap.put(resultValue.toString(), resultDes + "");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return enummap;
	}
	
	/**
	 * 将枚举转换成json字符串
	 * 
	 * @param enumT
	 * @return String
	 */
	public static <T> String EnumToJsonString(Class<T> enumT) {
		StringBuilder sb = new StringBuilder(); 
		if (!enumT.isEnum()) {
			return "{}";
		}
		T[] enums = enumT.getEnumConstants();
		if (enums == null || enums.length <= 0) {
			return "{}";
		}
		String valueMathod = "getValue"; // 默认接口value方法
		String nameMathod = "getName";// 默认接口description方法
		for (int i = 0, len = enums.length; i < len; i++) {
			T tobj = enums[i];
			try {
				Object resultValue = getMethodValue(valueMathod, tobj); // 获取value值
				if ("".equals(resultValue)) {
					continue;
				}
				Object resultDes = getMethodValue(nameMathod, tobj); // 获取description描述值
				if ("".equals(resultDes)) { // 如果描述不存在获取属性值
					resultDes = tobj;
				}
				sb.append(",{\"key\":\""+resultValue.toString()+"\",\"value\":\""+resultDes+"\"}");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		String sbStr=sb.toString();
		if(sbStr.indexOf(",")>=0){
			sbStr=sbStr.substring(1);
		}
		return "{\""+enumT.getSimpleName()+"\":["+sbStr+"]}";
	}
	/**
	 * 通过key获得value
	 * 
	 * @param key
	 * @param enumT
	 * @return enum value
	 */
	public static <T> String getEnumValueByName(Object name, Class<T> enumT) {
		if (!enumT.isEnum()) {
			return "";
		}
		T[] enums = enumT.getEnumConstants();
		if (enums == null || enums.length <= 0) {
			return "";
		}
		String valueMathod = "getValue"; // 默认接口value方法
		for (int i = 0, len = enums.length; i < len; i++) {
			T tobj = enums[i];
			try {
				if (tobj.toString().equals(name.toString())) { // 如果描述不存在获取属性值
					Object resultValue = getMethodValue(valueMathod, tobj); // 获取value值
					if (!"".equals(resultValue)) {
						return resultValue+"";
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "";
	}
}
