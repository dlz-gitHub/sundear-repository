package com.sundear.base.enumeration;

public class DbColumnEnum {
	public static enum StatusEnum {
		NONE("未设置", 0),ACTIVE("启用", 1), INACTIVE("禁用", 2);  
	    // 成员变量  
	    private String name;  
	    private int value;  
	    // 构造方法  
	    private StatusEnum(String name, int value) {  
	        this.name = name;  
	        this.value = value;  
	    }
	    // get set 方法  
	    public String getName() {  
	        return name;  
	    }  
	    public void setName(String name) {  
	        this.name = name;  
	    }  
	    public int getValue() {  
	        return value;  
	    }  
	    public void setValue(int value) {  
	        this.value = value;  
	    }
	}
}
