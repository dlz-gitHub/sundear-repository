package com.v2h.core.model;
import java.time.LocalDateTime;
import com.sundear.base.annotation.Description;

public class CabinInfo {
	public CabinInfo(){
				this.CabinID = "";
			    	    	    	    	    	    	    	    	    	    	    	    	    	    	    	    	    	    	    	    	    	    	    	    	    	    }
	 
    private String CabinID;
    @Description("CABIN_ID")
	public String getCabinID() {
		return this.CabinID;
	}
	public void setCabinID(String CabinID) {
		this.CabinID = CabinID;
	}
     
    private double CabinPv1Voltage;
    @Description("CABIN_PV1_VOLTAGE")
	public double getCabinPv1Voltage() {
		return this.CabinPv1Voltage;
	}
	public void setCabinPv1Voltage(double CabinPv1Voltage) {
		this.CabinPv1Voltage = CabinPv1Voltage;
	}
     
    private double CabinPv1Electricity;
    @Description("CABIN_PV1_ELECTRICITY")
	public double getCabinPv1Electricity() {
		return this.CabinPv1Electricity;
	}
	public void setCabinPv1Electricity(double CabinPv1Electricity) {
		this.CabinPv1Electricity = CabinPv1Electricity;
	}
     
    private double CabinPv1Mode;
    @Description("CABIN_PV1_MODE")
	public double getCabinPv1Mode() {
		return this.CabinPv1Mode;
	}
	public void setCabinPv1Mode(double CabinPv1Mode) {
		this.CabinPv1Mode = CabinPv1Mode;
	}
     
    private double CabinPv2Voltage;
    @Description("CABIN_PV2_VOLTAGE")
	public double getCabinPv2Voltage() {
		return this.CabinPv2Voltage;
	}
	public void setCabinPv2Voltage(double CabinPv2Voltage) {
		this.CabinPv2Voltage = CabinPv2Voltage;
	}
     
    private double CabinPv2Electricity;
    @Description("CABIN_PV2_ELECTRICITY")
	public double getCabinPv2Electricity() {
		return this.CabinPv2Electricity;
	}
	public void setCabinPv2Electricity(double CabinPv2Electricity) {
		this.CabinPv2Electricity = CabinPv2Electricity;
	}
     
    private double CabinPv2Mode;
    @Description("CABIN_PV2_MODE")
	public double getCabinPv2Mode() {
		return this.CabinPv2Mode;
	}
	public void setCabinPv2Mode(double CabinPv2Mode) {
		this.CabinPv2Mode = CabinPv2Mode;
	}
     
    private double BatteryVoltage;
    @Description("BATTERY_VOLTAGE")
	public double getBatteryVoltage() {
		return this.BatteryVoltage;
	}
	public void setBatteryVoltage(double BatteryVoltage) {
		this.BatteryVoltage = BatteryVoltage;
	}
     
    private double GridVoltage;
    @Description("GRID_VOLTAGE")
	public double getGridVoltage() {
		return this.GridVoltage;
	}
	public void setGridVoltage(double GridVoltage) {
		this.GridVoltage = GridVoltage;
	}
     
    private double GridElectricity;
    @Description("GRID_ELECTRICITY")
	public double getGridElectricity() {
		return this.GridElectricity;
	}
	public void setGridElectricity(double GridElectricity) {
		this.GridElectricity = GridElectricity;
	}
     
    private double GridPower;
    @Description("GRID_POWER")
	public double getGridPower() {
		return this.GridPower;
	}
	public void setGridPower(double GridPower) {
		this.GridPower = GridPower;
	}
     
    private double GridFrequency;
    @Description("GRID_FREQUENCY")
	public double getGridFrequency() {
		return this.GridFrequency;
	}
	public void setGridFrequency(double GridFrequency) {
		this.GridFrequency = GridFrequency;
	}
     
    private double LoadVoltage;
    @Description("LOAD_VOLTAGE")
	public double getLoadVoltage() {
		return this.LoadVoltage;
	}
	public void setLoadVoltage(double LoadVoltage) {
		this.LoadVoltage = LoadVoltage;
	}
     
    private double LoadElectricity;
    @Description("LOAD_ELECTRICITY")
	public double getLoadElectricity() {
		return this.LoadElectricity;
	}
	public void setLoadElectricity(double LoadElectricity) {
		this.LoadElectricity = LoadElectricity;
	}
     
    private double LoadPower;
    @Description("LOAD_POWER")
	public double getLoadPower() {
		return this.LoadPower;
	}
	public void setLoadPower(double LoadPower) {
		this.LoadPower = LoadPower;
	}
     
    private double LoadFrequency;
    @Description("LOAD_FREQUENCY")
	public double getLoadFrequency() {
		return this.LoadFrequency;
	}
	public void setLoadFrequency(double LoadFrequency) {
		this.LoadFrequency = LoadFrequency;
	}
     
    private double FeedbackTotalEq;
    @Description("FEEDBACK_TOTAL_EQ")
	public double getFeedbackTotalEq() {
		return this.FeedbackTotalEq;
	}
	public void setFeedbackTotalEq(double FeedbackTotalEq) {
		this.FeedbackTotalEq = FeedbackTotalEq;
	}
     
    private int FeedbackTotalTime;
    @Description("FEEDBACK_TOTAL_TIME")
	public int getFeedbackTotalTime() {
		return this.FeedbackTotalTime;
	}
	public void setFeedbackTotalTime(int FeedbackTotalTime) {
		this.FeedbackTotalTime = FeedbackTotalTime;
	}
     
    private double FeedbackDailyEq;
    @Description("FEEDBACK_DAILY_EQ")
	public double getFeedbackDailyEq() {
		return this.FeedbackDailyEq;
	}
	public void setFeedbackDailyEq(double FeedbackDailyEq) {
		this.FeedbackDailyEq = FeedbackDailyEq;
	}
     
    private double LoadDailyEq;
    @Description("LOAD_DAILY_EQ")
	public double getLoadDailyEq() {
		return this.LoadDailyEq;
	}
	public void setLoadDailyEq(double LoadDailyEq) {
		this.LoadDailyEq = LoadDailyEq;
	}
     
    private double LoadTotalEq;
    @Description("LOAD_TOTAL_EQ")
	public double getLoadTotalEq() {
		return this.LoadTotalEq;
	}
	public void setLoadTotalEq(double LoadTotalEq) {
		this.LoadTotalEq = LoadTotalEq;
	}
     
    private double InverterTotalPower;
    @Description("INVERTER_TOTAL_POWER")
	public double getInverterTotalPower() {
		return this.InverterTotalPower;
	}
	public void setInverterTotalPower(double InverterTotalPower) {
		this.InverterTotalPower = InverterTotalPower;
	}
     
    private double CabinTotalOutpute;
    @Description("CABIN_TOTAL_OUTPUTE")
	public double getCabinTotalOutpute() {
		return this.CabinTotalOutpute;
	}
	public void setCabinTotalOutpute(double CabinTotalOutpute) {
		this.CabinTotalOutpute = CabinTotalOutpute;
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
