package com.v2h.core.model;
import java.time.LocalDateTime;
import com.sundear.base.annotation.Description;

public class PowergridLoadInfo {
	public PowergridLoadInfo(){
				this.PglID = "";
			    	    	    	    	    	    	    	    	    	    }
	 
    private String PglID;
    @Description("PGL_ID")
	public String getPglID() {
		return this.PglID;
	}
	public void setPglID(String PglID) {
		this.PglID = PglID;
	}
     
    private double PowergridPower;
    @Description("POWERGRID_POWER")
	public double getPowergridPower() {
		return this.PowergridPower;
	}
	public void setPowergridPower(double PowergridPower) {
		this.PowergridPower = PowergridPower;
	}
     
    private double PowergridInpute;
    @Description("POWERGRID_INPUTE")
	public double getPowergridInpute() {
		return this.PowergridInpute;
	}
	public void setPowergridInpute(double PowergridInpute) {
		this.PowergridInpute = PowergridInpute;
	}
     
    private double PowergridOutpute;
    @Description("POWERGRID_OUTPUTE")
	public double getPowergridOutpute() {
		return this.PowergridOutpute;
	}
	public void setPowergridOutpute(double PowergridOutpute) {
		this.PowergridOutpute = PowergridOutpute;
	}
     
    private double LoadPower;
    @Description("LOAD_POWER")
	public double getLoadPower() {
		return this.LoadPower;
	}
	public void setLoadPower(double LoadPower) {
		this.LoadPower = LoadPower;
	}
     
    private double LoadInpute;
    @Description("LOAD_INPUTE")
	public double getLoadInpute() {
		return this.LoadInpute;
	}
	public void setLoadInpute(double LoadInpute) {
		this.LoadInpute = LoadInpute;
	}
     
    private double LoadOutpute;
    @Description("LOAD_OUTPUTE")
	public double getLoadOutpute() {
		return this.LoadOutpute;
	}
	public void setLoadOutpute(double LoadOutpute) {
		this.LoadOutpute = LoadOutpute;
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