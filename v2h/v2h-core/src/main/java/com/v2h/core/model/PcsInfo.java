package com.v2h.core.model;
import java.time.LocalDateTime;
import com.sundear.base.annotation.Description;

public class PcsInfo {
	public PcsInfo(){
				this.PcsID = "";
			    	    	    	    	    	    	    	    	    	    	    	    }
	 
    private String PcsID;
    @Description("PCS_ID")
	public String getPcsID() {
		return this.PcsID;
	}
	public void setPcsID(String PcsID) {
		this.PcsID = PcsID;
	}
     
    private double PcsBusbarVoltage;
    @Description("PCS_BUSBAR_VOLTAGE")
	public double getPcsBusbarVoltage() {
		return this.PcsBusbarVoltage;
	}
	public void setPcsBusbarVoltage(double PcsBusbarVoltage) {
		this.PcsBusbarVoltage = PcsBusbarVoltage;
	}
     
    private double PcsBusbarElectricity;
    @Description("PCS_BUSBAR_ELECTRICITY")
	public double getPcsBusbarElectricity() {
		return this.PcsBusbarElectricity;
	}
	public void setPcsBusbarElectricity(double PcsBusbarElectricity) {
		this.PcsBusbarElectricity = PcsBusbarElectricity;
	}
     
    private double PcsBusbarPower;
    @Description("PCS_BUSBAR_POWER")
	public double getPcsBusbarPower() {
		return this.PcsBusbarPower;
	}
	public void setPcsBusbarPower(double PcsBusbarPower) {
		this.PcsBusbarPower = PcsBusbarPower;
	}
     
    private double PcsTotalActivepower;
    @Description("PCS_TOTAL_ACTIVEPOWER")
	public double getPcsTotalActivepower() {
		return this.PcsTotalActivepower;
	}
	public void setPcsTotalActivepower(double PcsTotalActivepower) {
		this.PcsTotalActivepower = PcsTotalActivepower;
	}
     
    private double PcsTotalReactivepower;
    @Description("PCS_TOTAL_REACTIVEPOWER")
	public double getPcsTotalReactivepower() {
		return this.PcsTotalReactivepower;
	}
	public void setPcsTotalReactivepower(double PcsTotalReactivepower) {
		this.PcsTotalReactivepower = PcsTotalReactivepower;
	}
     
    private double PcsPowerFactor;
    @Description("PCS_POWER_FACTOR")
	public double getPcsPowerFactor() {
		return this.PcsPowerFactor;
	}
	public void setPcsPowerFactor(double PcsPowerFactor) {
		this.PcsPowerFactor = PcsPowerFactor;
	}
     
    private double PcsCharge;
    @Description("PCS_CHARGE")
	public double getPcsCharge() {
		return this.PcsCharge;
	}
	public void setPcsCharge(double PcsCharge) {
		this.PcsCharge = PcsCharge;
	}
     
    private double PcsDischarge;
    @Description("PCS_DISCHARGE")
	public double getPcsDischarge() {
		return this.PcsDischarge;
	}
	public void setPcsDischarge(double PcsDischarge) {
		this.PcsDischarge = PcsDischarge;
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