package com.v2h.core.model;
import java.time.LocalDateTime;
import com.sundear.base.annotation.Description;

public class SystemStatusInfo {
	public SystemStatusInfo(){
				this.SsID = "";
			    	    	    	    	    	    	    	    }
	 
    private String SsID;
    @Description("SS_ID")
	public String getSsID() {
		return this.SsID;
	}
	public void setSsID(String SsID) {
		this.SsID = SsID;
	}
     
    private double SystemElectricity;
    @Description("SYSTEM_ELECTRICITY")
	public double getSystemElectricity() {
		return this.SystemElectricity;
	}
	public void setSystemElectricity(double SystemElectricity) {
		this.SystemElectricity = SystemElectricity;
	}
     
    private double SystemVoltage;
    @Description("SYSTEM_VOLTAGE")
	public double getSystemVoltage() {
		return this.SystemVoltage;
	}
	public void setSystemVoltage(double SystemVoltage) {
		this.SystemVoltage = SystemVoltage;
	}
     
    private double BusbarVoltage;
    @Description("BUSBAR_VOLTAGE")
	public double getBusbarVoltage() {
		return this.BusbarVoltage;
	}
	public void setBusbarVoltage(double BusbarVoltage) {
		this.BusbarVoltage = BusbarVoltage;
	}
     
    private double ModuleCapacity;
    @Description("MODULE_CAPACITY")
	public double getModuleCapacity() {
		return this.ModuleCapacity;
	}
	public void setModuleCapacity(double ModuleCapacity) {
		this.ModuleCapacity = ModuleCapacity;
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