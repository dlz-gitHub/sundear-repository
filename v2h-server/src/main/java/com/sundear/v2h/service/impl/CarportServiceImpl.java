package com.sundear.v2h.service.impl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sundear.v2h.dao.CarportDao;
import com.sundear.v2h.model.CarportInfo;
import com.sundear.v2h.service.CarportService;

/**
 * @ClassName: CarportServiceImpl
 * @Description: TODO(解析移动车棚信息)
 * @date 2019年4月17日 下午4:29:46
 * @author dlz
 */
@Service
public class CarportServiceImpl implements CarportService {
	
	@Autowired
	private CarportDao carportDao;

	@Override
	public void analysisCarport(String messager,int carportNumber) {
		// 去头，去尾
		messager = messager.substring(6, messager.length() - 5);
		// 计算数据的个数
		String[] split = messager.split(" ");
		int number = Integer.parseInt(split[0], 16);
		System.out.println("数据个数" + number);
		int inverter_traffic_status = Integer.parseInt(split[1] + split[2], 16);
		int inverter_fault_status = Integer.parseInt(split[3] + split[4], 16);
		
		int inverter_bypass_input = Integer.parseInt(split[9] + split[10], 16);
		double inverter_output_voltage = Integer.parseInt(split[13] + split[14], 16);
		
		double inverter_temperature = Integer.parseInt(split[19] + split[20], 16);
		
		double inverter_out_power = Integer.parseInt(split[21] + split[22], 16);
		
		double inverter_outpute = Integer.parseInt(split[25] + split[26], 16);
		
		double inverter_power_factor = Integer.parseInt(split[27] + split[28], 16);
		
		double bms_voltage = Integer.parseInt(split[41] + split[42], 16);
		int battery_soc = Integer.parseInt(split[43] + split[44], 16);
		
		double battery_electricity = Integer.parseInt(split[57] + split[58], 16);
		
		int flotrol_traffic_status= Integer.parseInt(split[61] + split[62], 16);
		int flotrol_running_status = Integer.parseInt(split[63] + split[64], 16);
		double flotrol_output_voltage = Integer.parseInt(split[65] + split[66], 16);
		double flotrol_output_electricity = Integer.parseInt(split[67] + split[68], 16);
		int asc_traffic_status = Integer.parseInt(split[69] + split[70], 16);
		int asc_running_status = Integer.parseInt(split[71] + split[72], 16);
		int asc_connection_status = Integer.parseInt(split[73] + split[74], 16);
		
		CarportInfo carportInfo = new CarportInfo();
		carportInfo.setInverterTrafficStatus(inverter_traffic_status);
		carportInfo.setInverterFaultStatus(inverter_fault_status);
		carportInfo.setInverterBypassInput(inverter_bypass_input);
		carportInfo.setInverterOutputVoltage(inverter_output_voltage);
		carportInfo.setInverterOutpute(inverter_outpute);
		carportInfo.setInverterOutPower(inverter_out_power);
		carportInfo.setInverterTemperrature(inverter_temperature);
		carportInfo.setInverterPowerFactor(inverter_power_factor);
		carportInfo.setBmsVoltage(bms_voltage);
		carportInfo.setBatterySoc(battery_soc);
		carportInfo.setBatteryElectricity(battery_electricity);
		carportInfo.setFlotrolTrafficStatus(flotrol_traffic_status);
		carportInfo.setFlotrolRunningStatus(flotrol_running_status);
		carportInfo.setFlotrolOutputVoltage(flotrol_output_voltage);
		carportInfo.setFlotrolOutputElectricity(flotrol_output_electricity);
		carportInfo.setAscTrafficStatus(asc_traffic_status);
		carportInfo.setAscRunningStatus(asc_running_status);
		carportInfo.setAscConnectionStatus(asc_connection_status);
		
		carportInfo.setInsertDate(LocalDateTime.now());
		
		carportDao.insertCarport(carportInfo);
	}

}
