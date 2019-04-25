package com.v2h.core.model;
import java.time.LocalDateTime;
import com.sundear.base.annotation.Description;

public class InverterInfo {
	public InverterInfo(){
				this.InverterID = "";
			    	    	    	    	    	    	    	    	    	    	    	    	    }
	 
    private String InverterID;
    @Description("INVERTER_ID")
	public String getInverterID() {
		return this.InverterID;
	}
	public void setInverterID(String InverterID) {
		this.InverterID = InverterID;
	}
     
    private float DailyOutpute;
    @Description("DAILY_OUTPUTE")
	public float getDailyOutpute() {
		return this.DailyOutpute;
	}
	public void setDailyOutpute(float DailyOutpute) {
		this.DailyOutpute = DailyOutpute;
	}
     
    private float TotalOutpute;
    @Description("TOTAL_OUTPUTE")
	public float getTotalOutpute() {
		return this.TotalOutpute;
	}
	public void setTotalOutpute(float TotalOutpute) {
		this.TotalOutpute = TotalOutpute;
	}
     
    private int TotalOutputeTime;
    @Description("TOTAL_OUTPUTE_TIME")
	public int getTotalOutputeTime() {
		return this.TotalOutputeTime;
	}
	public void setTotalOutputeTime(int TotalOutputeTime) {
		this.TotalOutputeTime = TotalOutputeTime;
	}
     
    private int RunningStatus;
    @Description("RUNNING_STATUS")
	public int getRunningStatus() {
		return this.RunningStatus;
	}
	public void setRunningStatus(int RunningStatus) {
		this.RunningStatus = RunningStatus;
	}
     
    private float InverterTemperature;
    @Description("INVERTER_TEMPERATURE")
	public float getInverterTemperature() {
		return this.InverterTemperature;
	}
	public void setInverterTemperature(float InverterTemperature) {
		this.InverterTemperature = InverterTemperature;
	}
     
    private float BusVoltage;
    @Description("BUS_VOLTAGE")
	public float getBusVoltage() {
		return this.BusVoltage;
	}
	public void setBusVoltage(float BusVoltage) {
		this.BusVoltage = BusVoltage;
	}
     
    private int TotalOutPower;
    @Description("TOTAL_OUT_POWER")
	public int getTotalOutPower() {
		return this.TotalOutPower;
	}
	public void setTotalOutPower(int TotalOutPower) {
		this.TotalOutPower = TotalOutPower;
	}
     
    private double PowerFactor;
    @Description("POWER_FACTOR")
	public double getPowerFactor() {
		return this.PowerFactor;
	}
	public void setPowerFactor(double PowerFactor) {
		this.PowerFactor = PowerFactor;
	}
     
    private int InverterNumber;
    @Description("INVERTER_NUMBER")
	public int getInverterNumber() {
		return this.InverterNumber;
	}
	public void setInverterNumber(int InverterNumber) {
		this.InverterNumber = InverterNumber;
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