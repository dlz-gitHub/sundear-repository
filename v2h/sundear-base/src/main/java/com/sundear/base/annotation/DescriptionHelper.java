package com.sundear.base.annotation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class DescriptionHelper {
	public static <T> String GetDescriptionName(T type){
        Class<?> c = type.getClass();
		if (c.isAnnotationPresent(Description.class)) {
			Description t = (Description) c.getAnnotation(Description.class);
			return t.value();
		}
		return "";
	}
	public static <T> String GetDescriptionName(T type,String name){
        Class<?> c = type.getClass();

        try {  
            Method getMethod=c.getDeclaredMethod(name);  
    		if (getMethod!=null&&getMethod.isAnnotationPresent(Description.class)) {
    			Description t = (Description) getMethod.getAnnotation(Description.class);
    			return t.value();
    		}  
        } catch (Exception e) {   
        }  
        try {  
            Field getField=c.getDeclaredField(name);  
    		if (getField!=null&&getField.isAnnotationPresent(Description.class)) {
    			Description t = (Description) getField.getAnnotation(Description.class);
    			return t.value();
    		}  
        } catch (Exception e) {   
        }  
		return "";
	}
	public static <T> String GetEnumDescription(T enumm){
        Class<?> c = enumm.getClass();
		Field[] fields = c.getDeclaredFields();//拿到它定义的所有字段
        for(Field field:fields){
            if(field.isAnnotationPresent(Description.class)&&field.getName().equals(enumm.toString())){
    			Description t = (Description) field.getAnnotation(Description.class);
    			return t.value();
            }
        }
	    return "";  
	}
}
