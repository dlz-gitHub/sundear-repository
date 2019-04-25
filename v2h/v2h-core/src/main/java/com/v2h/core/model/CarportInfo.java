package com.v2h.core.model;

import java.time.LocalDateTime;
import com.sundear.base.annotation.Description;

public class CarportInfo {
	public CarportInfo() {
		this.CarportID = "";
	}

	private String CarportID;

	@Description("CARPORT_ID")
	public String getCarportID() {
		return this.CarportID;
	}

	public void setCarportID(String CarportID) {
		this.CarportID = CarportID;
	}

	private int InverterTrafficStatus;

	@Description("INVERTER_TRAFFIC_STATUS")
	public int getInverterTrafficStatus() {
		return this.InverterTrafficStatus;
	}

	public void setInverterTrafficStatus(int InverterTrafficStatus) {
		this.InverterTrafficStatus = InverterTrafficStatus;
	}

	private int InverterFaultStatus;

	@Description("INVERTER_FAULT_STATUS")
	public int getInverterFaultStatus() {
		return this.InverterFaultStatus;
	}

	public void setInverterFaultStatus(int InverterFaultStatus) {
		this.InverterFaultStatus = InverterFaultStatus;
	}

	private int InverterBypassInput;

	@Description("INVERTER_BYPASS_INPUT")
	public int getInverterBypassInput() {
		return this.InverterBypassInput;
	}

	public void setInverterBypassInput(int InverterBypassInput) {
		this.InverterBypassInput = InverterBypassInput;
	}

	private double InverterOutputVoltage;

	@Description("INVERTER_OUTPUT_VOLTAGE")
	public double getInverterOutputVoltage() {
		return this.InverterOutputVoltage;
	}

	public void setInverterOutputVoltage(double InverterOutputVoltage) {
		this.InverterOutputVoltage = InverterOutputVoltage;
	}

	private double InverterTemperrature;

	@Description("INVERTER_TEMPERRATURE")
	public double getInverterTemperrature() {
		return this.InverterTemperrature;
	}

	public void setInverterTemperrature(double InverterTemperrature) {
		this.InverterTemperrature = InverterTemperrature;
	}

	private double InverterOutpute;

	@Description("INVERTER_OUTPUTE")
	public double getInverterOutpute() {
		return this.InverterOutpute;
	}

	public void setInverterOutpute(double InverterOutpute) {
		this.InverterOutpute = InverterOutpute;
	}

	private double InverterOutPower;

	@Description("INVERTER_OUT_POWER")
	public double getInverterOutPower() {
		return this.InverterOutPower;
	}

	public void setInverterOutPower(double InverterOutPower) {
		this.InverterOutPower = InverterOutPower;
	}

	private double InverterPowerFactor;

	@Description("INVERTER_POWER_FACTOR")
	public double getInverterPowerFactor() {
		return this.InverterPowerFactor;
	}

	public void setInverterPowerFactor(double InverterPowerFactor) {
		this.InverterPowerFactor = InverterPowerFactor;
	}

	private double BmsVoltage;

	@Description("BMS_VOLTAGE")
	public double getBmsVoltage() {
		return this.BmsVoltage;
	}

	public void setBmsVoltage(double BmsVoltage) {
		this.BmsVoltage = BmsVoltage;
	}

	private int BatterySoc;

	@Description("BATTERY_SOC")
	public int getBatterySoc() {
		return this.BatterySoc;
	}

	public void setBatterySoc(int BatterySoc) {
		this.BatterySoc = BatterySoc;
	}

	private double BatteryElectricity;

	@Description("BATTERY_ELECTRICITY")
	public double getBatteryElectricity() {
		return this.BatteryElectricity;
	}

	public void setBatteryElectricity(double BatteryElectricity) {
		this.BatteryElectricity = BatteryElectricity;
	}

	private int FlotrolTrafficStatus;

	@Description("FLOTROL_TRAFFIC_STATUS")
	public int getFlotrolTrafficStatus() {
		return this.FlotrolTrafficStatus;
	}

	public void setFlotrolTrafficStatus(int FlotrolTrafficStatus) {
		this.FlotrolTrafficStatus = FlotrolTrafficStatus;
	}

	private int FlotrolRunningStatus;

	@Description("FLOTROL_RUNNING_STATUS")
	public int getFlotrolRunningStatus() {
		return this.FlotrolRunningStatus;
	}

	public void setFlotrolRunningStatus(int FlotrolRunningStatus) {
		this.FlotrolRunningStatus = FlotrolRunningStatus;
	}

	private double FlotrolOutputVoltage;

	@Description("FLOTROL_OUTPUT_VOLTAGE")
	public double getFlotrolOutputVoltage() {
		return this.FlotrolOutputVoltage;
	}

	public void setFlotrolOutputVoltage(double FlotrolOutputVoltage) {
		this.FlotrolOutputVoltage = FlotrolOutputVoltage;
	}

	private double FlotrolOutputElectricity;

	@Description("FLOTROL_OUTPUT_ELECTRICITY")
	public double getFlotrolOutputElectricity() {
		return this.FlotrolOutputElectricity;
	}

	public void setFlotrolOutputElectricity(double FlotrolOutputElectricity) {
		this.FlotrolOutputElectricity = FlotrolOutputElectricity;
	}

	private int AscTrafficStatus;

	@Description("ASC_TRAFFIC_STATUS")
	public int getAscTrafficStatus() {
		return this.AscTrafficStatus;
	}

	public void setAscTrafficStatus(int AscTrafficStatus) {
		this.AscTrafficStatus = AscTrafficStatus;
	}

	private int AscRunningStatus;

	@Description("ASC_RUNNING_STATUS")
	public int getAscRunningStatus() {
		return this.AscRunningStatus;
	}

	public void setAscRunningStatus(int AscRunningStatus) {
		this.AscRunningStatus = AscRunningStatus;
	}

	private int AscConnectionStatus;

	@Description("ASC_CONNECTION_STATUS")
	public int getAscConnectionStatus() {
		return this.AscConnectionStatus;
	}

	public void setAscConnectionStatus(int AscConnectionStatus) {
		this.AscConnectionStatus = AscConnectionStatus;
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