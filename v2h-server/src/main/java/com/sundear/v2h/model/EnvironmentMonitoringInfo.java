package com.sundear.v2h.model;
import java.time.LocalDateTime;

import org.springframework.context.annotation.Description;



public class EnvironmentMonitoringInfo {
	public EnvironmentMonitoringInfo(){
				this.EmID = "";
			    	    	    	    	    	    	    }
	 
    private String EmID;
    @Description("EM_ID")
	public String getEmID() {
		return this.EmID;
	}
	public void setEmID(String EmID) {
		this.EmID = EmID;
	}
     
    private int EnvironmentTemperature;
    @Description("ENVIRONMENT_TEMPERATURE")
	public int getEnvironmentTemperature() {
		return this.EnvironmentTemperature;
	}
	public void setEnvironmentTemperature(int EnvironmentTemperature) {
		this.EnvironmentTemperature = EnvironmentTemperature;
	}
     
    private int TotalRadiation;
    @Description("TOTAL_RADIATION")
	public int getTotalRadiation() {
		return this.TotalRadiation;
	}
	public void setTotalRadiation(int TotalRadiation) {
		this.TotalRadiation = TotalRadiation;
	}
     
    private float DailyRadiation;
    @Description("DAILY_RADIATION")
	public float getDailyRadiation() {
		return this.DailyRadiation;
	}
	public void setDailyRadiation(float DailyRadiation) {
		this.DailyRadiation = DailyRadiation;
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
