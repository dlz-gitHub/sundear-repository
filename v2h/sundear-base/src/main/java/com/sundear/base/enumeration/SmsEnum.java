package com.sundear.base.enumeration;

public class SmsEnum {
	public static enum SmsTypeEnum {
		NONE("未设置", 0),REGISTER("注册验证码", 1), LOGIN("登录验证码", 2), RESETPASSWORD("重置密码", 3);  
	    // 成员变量  
	    private String name;  
	    private int value;  
	    // 构造方法  
	    private SmsTypeEnum(String name, int value) {  
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
