package com.sundear.base.enumeration;

public class FileEnum {

	public static enum ImageTypeEnum {
		NONE("未知", 0),JPG("jpg格式", 1), BMP("bmp格式", 2), GIF("gif格式", 3), PNG("png格式", 4), ICO("ico格式", 5),JPEG("jpeg格式", 6);  
	    // 成员变量  
	    private String name;  
	    private int value;  
	    // 构造方法  
	    private ImageTypeEnum(String name, int value) {  
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

	public static enum ImageRefferTypeEnum {
		PLATFORM_ICON("合作平台图标",1),VIDEO_SCREENSHOT("视频截图",2); 
	    private String name;  
	    private int value; 
	    private ImageRefferTypeEnum(String name, int value) {  
	        this.name = name;  
	        this.value = value;  
	    } 
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
	
	public static enum VideoTypeEnum {
		NONE("未知", 0),MPFOUR("mp4格式", 1), MOV("mov格式", 2), RMVB("rmvb格式", 3), AVI("avi格式", 4), TREEGP("3gp格式", 5),TS("ts格式", 6),MTS("mts格式", 7),MKV("mkv格式", 8),RM("rm格式", 9);  
	    // 成员变量  
	    private String name;  
	    private int value;  
	    // 构造方法  
	    private VideoTypeEnum(String name, int value) {  
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
	

	public static enum VideoStatusEnum {
		EFFECTIVE("有效",1),OVERDUE("已过期",2); 
	    private String name;  
	    private int value; 
	    private VideoStatusEnum(String name, int value) {  
	        this.name = name;  
	        this.value = value;  
	    } 
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
