package com.sundear.base.enumeration;

public class CommonEnum {
	public static enum YesOrNoEnum {
		YES("是",1),NO("否",2); 
	    private String name;  
	    private int value; 
	    private YesOrNoEnum(String name, int value) {  
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

	public static enum ApproveStatusEnum {
		APPROVING("未审核",1),APPROVED("审核通过",2),DENNY("审核不通过",3); 
	    private String name;  
	    private int value; 
	    private ApproveStatusEnum(String name, int value) {  
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
