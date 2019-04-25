package com.v2h.core.model;
import java.time.LocalDateTime;
import com.sundear.base.annotation.Description;

public class BmsInfo {
	public BmsInfo(){
				this.BmsID = "";
			    	    	    	    	    	    	    	    }
	 
    private String BmsID;
    @Description("BMS_ID")
	public String getBmsID() {
		return this.BmsID;
	}
	public void setBmsID(String BmsID) {
		this.BmsID = BmsID;
	}
     
    private double BmsTotalVoltage;
    @Description("BMS_TOTAL_VOLTAGE")
	public double getBmsTotalVoltage() {
		return this.BmsTotalVoltage;
	}
	public void setBmsTotalVoltage(double BmsTotalVoltage) {
		this.BmsTotalVoltage = BmsTotalVoltage;
	}
     
    private double BmsTemperature;
    @Description("BMS_TEMPERATURE")
	public double getBmsTemperature() {
		return this.BmsTemperature;
	}
	public void setBmsTemperature(double BmsTemperature) {
		this.BmsTemperature = BmsTemperature;
	}
     
    private int BmsSoc;
    @Description("BMS_SOC")
	public int getBmsSoc() {
		return this.BmsSoc;
	}
	public void setBmsSoc(int BmsSoc) {
		this.BmsSoc = BmsSoc;
	}
     
    private int BmsNumber;
    @Description("BMS_NUMBER")
	public int getBmsNumber() {
		return this.BmsNumber;
	}
	public void setBmsNumber(int BmsNumber) {
		this.BmsNumber = BmsNumber;
	}
     
    private LocalDateTime InsertDate;
    @Description("INSERT_DATE")
	public LocalDateTime getInsertDate() {
		return this.InsertDate;
	}
	public void setInsertDate(LocalDateTime InsertDate) {
		this.InsertDate = InsertDate;
	}
     
    private int Status;
    @Description("STATUS")
	public int getStatus() {
		return this.Status;
	}
	public void setStatus(int Status) {
		this.Status = Status;
	}
    	
}
