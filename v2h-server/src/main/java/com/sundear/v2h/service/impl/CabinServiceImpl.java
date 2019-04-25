package com.sundear.v2h.service.impl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sundear.v2h.dao.CabinDao;
import com.sundear.v2h.model.CabinInfo;
import com.sundear.v2h.service.CabinService;

/**
 * @ClassName: CabinServiceImpl
 * @Description: TODO(小木屋信息处理)
 * @date 2019年4月17日 下午4:28:27
 * @author dlz
 */
@Service
public class CabinServiceImpl implements CabinService {
	
	@Autowired
	private CabinDao cabinDao;

	@Override
	public void analysisCabin(String messager) {
		// 去头，去尾
		messager = messager.substring(6, messager.length() - 5);
		// 计算数据的个数
		String[] split = messager.split(" ");
		int number = Integer.parseInt(split[0], 16);
		System.out.println("数据个数" + number);
		double cabin_pv1_voltage = Integer.parseInt(split[1] + split[2], 16);
		double cabin_pv1_electricity = Integer.parseInt(split[3] + split[4], 16);
		double cabin_pv1_mode = Integer.parseInt(split[5] + split[6], 16);
		double cabin_pv2_voltage = Integer.parseInt(split[7] + split[8], 16);
		double cabin_pv2_electricity = Integer.parseInt(split[9] + split[10], 16);
		double cabin_pv2_mode = Integer.parseInt(split[11] + split[12], 16);
		double battery_voltage = Integer.parseInt(split[13] + split[14], 16);
		double grid_voltage = Integer.parseInt(split[15] + split[16], 16);
		double grid_electricity = Integer.parseInt(split[17] + split[18], 16);
		double grid_power = Integer.parseInt(split[19] + split[20], 16);
		int grid_frequency = Integer.parseInt(split[21] + split[22], 16);
		
		double load_voltage = Integer.parseInt(split[25] + split[26], 16);
		double load_electricity = Integer.parseInt(split[27] + split[28], 16);
		double load_power = Integer.parseInt(split[29] + split[30], 16);
		//现在地址上找不到信息
		int load_frequency = Integer.parseInt(split[21] + split[22], 16);
		
		double feedback_total_eq = Integer.parseInt(split[31] + split[32], 16) * 65536
				+ Integer.parseInt(split[33] + split[34], 16); 
		int feedback_total_time = Integer.parseInt(split[35] + split[36], 16) * 65536
				+ Integer.parseInt(split[37] + split[38], 16); 
		double feedback_daily_eq = Integer.parseInt(split[39] + split[40], 16);
		double load_daily_eq =   Integer.parseInt(split[41] + split[42], 16);
		double load_total_eq = Integer.parseInt(split[43] + split[44], 16) * 65536
				+ Integer.parseInt(split[45] + split[46], 16);
		double inverter_total_power =  Integer.parseInt(split[47] + split[48], 16);
		double cabin_total_outpute = Integer.parseInt(split[49] + split[50], 16) * 65536
				+ Integer.parseInt(split[51] + split[52], 16);
		
		CabinInfo cabinInfo = new CabinInfo();
		cabinInfo.setCabinPv1Voltage(cabin_pv1_voltage);
		cabinInfo.setCabinPv1Electricity(cabin_pv1_electricity);
		cabinInfo.setCabinPv1Mode(cabin_pv1_mode);
		cabinInfo.setCabinPv2Voltage(cabin_pv2_voltage);
		cabinInfo.setCabinPv2Electricity(cabin_pv2_electricity);
		cabinInfo.setCabinPv2Mode(cabin_pv2_mode);
		cabinInfo.setBatteryVoltage(battery_voltage);
		cabinInfo.setGridVoltage(grid_voltage);
		cabinInfo.setGridElectricity(grid_electricity);
		cabinInfo.setGridPower(grid_power);
		cabinInfo.setGridFrequency(grid_frequency);
		cabinInfo.setLoadVoltage(load_voltage);
		cabinInfo.setLoadElectricity(load_electricity);
		cabinInfo.setLoadPower(load_power);
		cabinInfo.setLoadFrequency(load_frequency);
		cabinInfo.setFeedbackTotalEq(feedback_total_eq);
		cabinInfo.setFeedbackTotalTime(feedback_total_time);
		cabinInfo.setFeedbackDailyEq(feedback_daily_eq);
		cabinInfo.setLoadDailyEq(load_daily_eq);
		cabinInfo.setLoadTotalEq(load_total_eq);
		cabinInfo.setInverterTotalPower(inverter_total_power);
		cabinInfo.setCabinTotalOutpute(cabin_total_outpute);
		
		cabinInfo.setInsertDate(LocalDateTime.now());
		
		cabinDao.insertCabin(cabinInfo);
	}

}
