package com.sundear.v2h.model;

import java.time.LocalDateTime;

import org.springframework.context.annotation.Description;

public class PcsDetailInfo {
	public PcsDetailInfo(){
				this.PcsDetailID = "";
			    	    	    	    	    	    	    	    	    	    }
	 
    private String PcsDetailID;
    @Description("PCS_DETAIL_ID")
	public String getPcsDetailID() {
		return this.PcsDetailID;
	}
	public void setPcsDetailID(String PcsDetailID) {
		this.PcsDetailID = PcsDetailID;
	}
     
    private double PcsDetailPower;
    @Description("PCS_DETAIL_POWER")
	public double getPcsDetailPower() {
		return this.PcsDetailPower;
	}
	public void setPcsDetailPower(double PcsDetailPower) {
		this.PcsDetailPower = PcsDetailPower;
	}
     
    private double PcsDetailVoltage;
    @Description("PCS_DETAIL_VOLTAGE")
	public double getPcsDetailVoltage() {
		return this.PcsDetailVoltage;
	}
	public void setPcsDetailVoltage(double PcsDetailVoltage) {
		this.PcsDetailVoltage = PcsDetailVoltage;
	}
     
    private double PcsDetailElectricity;
    @Description("PCS_DETAIL_ELECTRICITY")
	public double getPcsDetailElectricity() {
		return this.PcsDetailElectricity;
	}
	public void setPcsDetailElectricity(double PcsDetailElectricity) {
		this.PcsDetailElectricity = PcsDetailElectricity;
	}
     
    private int PcsDetailInpute;
    @Description("PCS_DETAIL_INPUTE")
	public int getPcsDetailInpute() {
		return this.PcsDetailInpute;
	}
	public void setPcsDetailInpute(int PcsDetailInpute) {
		this.PcsDetailInpute = PcsDetailInpute;
	}
     
    private int PcsDetailOutpute;
    @Description("PCS_DETAIL_OUTPUTE")
	public int getPcsDetailOutpute() {
		return this.PcsDetailOutpute;
	}
	public void setPcsDetailOutpute(int PcsDetailOutpute) {
		this.PcsDetailOutpute = PcsDetailOutpute;
	}
     
    private int PcsDetailNumber;
    @Description("PCS_DETAIL_NUMBER")
	public int getPcsDetailNumber() {
		return this.PcsDetailNumber;
	}
	public void setPcsDetailNumber(int PcsDetailNumber) {
		this.PcsDetailNumber = PcsDetailNumber;
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