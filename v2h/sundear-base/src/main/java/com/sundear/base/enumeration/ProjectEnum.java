package com.sundear.base.enumeration;
/**
 * 
 * @author 顾余
 * @功能 用于每个项目自有枚举
 *
 */
public class ProjectEnum {

	public static enum PublishStatusEnum {
		NONE("未发布",1),PUBLISHING("发布中",2),SUCCESS("发布成功",3),FAIL("发布失败",4),CANCEL("取消发布",5); 
		//NONE("等待初审",0),FIRSTTRIAL("初审通过",1),FIRSTTRIALNOPASS("初审未通过",2),PUBLISHING("发布中",3),SUCCESS("发布成功",4),NOTPASS("未通过审核",5),FAIL("发布失败",6); 
	    private String name;  
	    private int value; 
	    private PublishStatusEnum(String name, int value) {  
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
	public static enum DataCountTypeEnum {
		TOTAL("全部",1),VIDEO("视频",2),ACCOUNT("账号",3),BOOK("账号簿",4),ACCOUNTINBOOK("账号簿内的账号",5),COLLECTION("合集",6); 
	    private String name;  
	    private int value; 
	    private DataCountTypeEnum(String name, int value) {  
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
	
	public static enum TodayExcelEnum {
		PLAYS("播放量分析",1),OTHER("互动分析",2),FANS("粉丝趋势分析",3); 
	    private String name;  
	    private int value; 
	    private TodayExcelEnum(String name, int value) {  
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
	public static enum EmailEnum {
		VERIFY("验证码邮件",1),PUBLISHNOTICE("发布信息审核通知",2); 
	    private String name;  
	    private int value; 
	    private EmailEnum(String name, int value) {  
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
	/*
	 * TOTAL=显示全部
	 * NOTALL=未全部发布完
	 * PUBLISHED=发布过一些账户或已全部发布
	 * */
	public static enum VideoIsPublishedEnum {
		TOTAL("全部",1),NOTALL("未发布",2),PUBLISHED("已发布",3); 
	    private String name;  
	    private int value; 
	    private VideoIsPublishedEnum(String name, int value) {  
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
