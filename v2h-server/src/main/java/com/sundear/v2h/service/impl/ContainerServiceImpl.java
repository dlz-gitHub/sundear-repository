package com.sundear.v2h.service.impl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sundear.v2h.dao.BmsDao;
import com.sundear.v2h.dao.EnvironmentMonitoringDao;
import com.sundear.v2h.dao.InverterDao;
import com.sundear.v2h.dao.PcsDao;
import com.sundear.v2h.dao.PcsDetailDao;
import com.sundear.v2h.dao.PowergridLoadDao;
import com.sundear.v2h.dao.SystemStatusDao;
import com.sundear.v2h.model.BmsInfo;
import com.sundear.v2h.model.EnvironmentMonitoringInfo;
import com.sundear.v2h.model.InverterInfo;
import com.sundear.v2h.model.PcsDetailInfo;
import com.sundear.v2h.model.PcsInfo;
import com.sundear.v2h.model.PowergridLoadInfo;
import com.sundear.v2h.model.SystemStatusInfo;
import com.sundear.v2h.service.ContainerService;

/**
 * @ClassName: ContainerServiceImpl
 * @Description: TODO(集装箱的数据处理方式)
 * @date 2019年4月4日 下午5:20:27
 * @author dlz
 */
@Service
public class ContainerServiceImpl implements ContainerService {
	@Autowired
	private InverterDao inverterDao;

	@Autowired
	private EnvironmentMonitoringDao environmentMonitoringDao;

	@Autowired
	private SystemStatusDao systemStatusDao;

	@Autowired
	private BmsDao bmsDao;

	@Autowired
	private PcsDao pcsDao;
	
	@Autowired
	private PowergridLoadDao powergridLoadDao;
	
	@Autowired
	private PcsDetailDao pcsDetailDao;

	// 解析inverter报文
	@Override
	public void analysisInverter(String messager, int inverterNumber) {

		// 去头，去尾
		messager = messager.substring(6, messager.length() - 5);
		// 计算数据的个数
		String[] split = messager.split(" ");
		int number = Integer.parseInt(split[0], 16);
		System.out.println("数据个数" + number);
		float daily_output = (Integer.parseInt(split[1] + split[2], 16) * 65536
				+ Integer.parseInt(split[3] + split[4], 16)) / 1000;
		float total_output = Math.abs((Integer.parseInt(split[5] + split[6], 16) * 65536
				+ Integer.parseInt(split[7] + split[8], 16)) / 1000);
		int total_output_time = Math.abs((Integer.parseInt(split[9] + split[10], 16) * 65536
				+ Integer.parseInt(split[11] + split[12], 16)));
		int running_status = Integer.parseInt(split[13] + split[14], 16);
		float inverter_temperature = Integer.parseInt(split[15] + split[16], 16);
		float bus_voltage = Integer.parseInt(split[17] + split[18], 16);
		int total_output_power = (Integer.parseInt(split[19] + split[20], 16) * 65536
				+ Integer.parseInt(split[21] + split[22], 16));
		float power_factor = Integer.parseInt(split[23] + split[24], 16);
		// 数据打造成对象，加入数据库,ID会在dao层直接填入
		InverterInfo inverterInfo = new InverterInfo();
		inverterInfo.setDailyOutpute(daily_output);
		inverterInfo.setTotalOutpute(total_output);
		inverterInfo.setTotalOutputeTime(total_output_time);
		inverterInfo.setRunningStatus(running_status);
		inverterInfo.setInverterTemperature(inverter_temperature);
		inverterInfo.setBusVoltage(bus_voltage);
		inverterInfo.setTotalOutPower(total_output_power);
		inverterInfo.setPowerFactor(power_factor);
		inverterInfo.setInverterNumber(inverterNumber);
		inverterInfo.setInsertDate(LocalDateTime.now());

		inverterDao.insertInverter(inverterInfo);
	}

	// 解析环境检测仪的信息
	@Override
	public void analysisEM(String messager) {
		// 去头，去尾
		messager = messager.substring(6, messager.length() - 5);
		// 计算数据的个数
		String[] split = messager.split(" ");
		int number = Integer.parseInt(split[0], 16);
		System.out.println("数据个数" + number);
		int environment_temperature = Math.abs((Integer.parseInt(split[1] + split[2], 16) - 2000) / 10);
		int total_radiation = Integer.parseInt(split[3] + split[4], 16);
		float daily_radiation = Integer.parseInt(split[5] + split[6], 16) / 1000;

		EnvironmentMonitoringInfo environmentMonitoringInfo = new EnvironmentMonitoringInfo();
		environmentMonitoringInfo.setEnvironmentTemperature(environment_temperature);
		environmentMonitoringInfo.setTotalRadiation(total_radiation);
		environmentMonitoringInfo.setDailyRadiation(daily_radiation);
		environmentMonitoringInfo.setInsertDate(LocalDateTime.now());

		environmentMonitoringDao.insertEnvironmentMonitoring(environmentMonitoringInfo);
	}

	// 解析系统状态
	@Override
	public void analysisSS(String messager) {
		// 去头，去尾
		messager = messager.substring(6, messager.length() - 5);
		// 计算数据的个数
		String[] split = messager.split(" ");
		int number = Integer.parseInt(split[0], 16);
		System.out.println("数据个数" + number);
		double system_electricity = Integer.parseInt(split[1] + split[2], 16) - 1000;
		double system_voltage = Integer.parseInt(split[3] + split[4], 16);
		double busbar_voltage = Integer.parseInt(split[5] + split[6], 16);
		double module_capacity = Integer.parseInt(split[7] + split[8], 16);

		SystemStatusInfo systemStatusInfo = new SystemStatusInfo();
		systemStatusInfo.setSystemElectricity(system_electricity);
		systemStatusInfo.setSystemVoltage(system_voltage);
		systemStatusInfo.setBusbarVoltage(busbar_voltage);
		systemStatusInfo.setModuleCapacity(module_capacity);
		systemStatusInfo.setInsertDate(LocalDateTime.now());

		systemStatusDao.insertSystemStatus(systemStatusInfo);
	}

	// 解析bms
	@Override
	public void analysisBMS(String messager, int bmsNumber) {
		// 去头，去尾
		messager = messager.substring(6, messager.length() - 5);
		// 计算数据的个数
		String[] split = messager.split(" ");
		int number = Integer.parseInt(split[0], 16);
		System.out.println("数据个数" + number);
		double bms_total_voltage = Integer.parseInt(split[1] + split[2], 16);
		double bms_temperature = Integer.parseInt(split[3] + split[4], 16);
		int bms_soc = Integer.parseInt(split[5] + split[6], 16);

		BmsInfo bmsInfo = new BmsInfo();
		bmsInfo.setBmsTotalVoltage(bms_total_voltage);
		bmsInfo.setBmsTemperature(bms_temperature);
		bmsInfo.setBmsSoc(bms_soc);
		bmsInfo.setBmsNumber(bmsNumber);
		bmsInfo.setInsertDate(LocalDateTime.now());

		bmsDao.insertBms(bmsInfo);
	}

	// 解析pcs信息
	@Override
	public void analysisPCS(String messager) {
		// 去头，去尾
		messager = messager.substring(6, messager.length() - 5);
		// 计算数据的个数
		String[] split = messager.split(" ");
		int number = Integer.parseInt(split[0], 16);
		System.out.println("数据个数" + number);
		double pcs_busbar_voltage = Integer.parseInt(split[1] + split[2], 16);
		double pcs_busbar_eceltricity = Integer.parseInt(split[3] + split[4], 16) - 2000;
		double pcs_busbar_power = Integer.parseInt(split[5] + split[6], 16) - 1500;
		double pcs_total_activepower = Integer.parseInt(split[7] + split[8], 16) - 1200;
		double pcs_total_reactivepower = Integer.parseInt(split[9] + split[10], 16) - 1200;
		double pcs_power_factor = Integer.parseInt(split[11] + split[12], 16) - 1;
		double pcs_charge = Integer.parseInt(split[13] + split[14], 16) * 65536
				+ Integer.parseInt(split[15] + split[16], 16);
		double pcs_discharge = Integer.parseInt(split[17] + split[18], 16) * 65536
				+ Integer.parseInt(split[19] + split[20], 16);
		
		
		PcsInfo pcsInfo = new PcsInfo();
		pcsInfo.setPcsBusbarVoltage(pcs_busbar_voltage);
		pcsInfo.setPcsBusbarElectricity(pcs_busbar_eceltricity);
		pcsInfo.setPcsBusbarPower(pcs_busbar_power);
		pcsInfo.setPcsTotalActivepower(pcs_total_activepower);
		pcsInfo.setPcsTotalReactivepower(pcs_total_reactivepower);
		pcsInfo.setPcsPowerFactor(pcs_power_factor);
		pcsInfo.setInsertDate(LocalDateTime.now());
		pcsInfo.setPcsCharge(pcs_charge);
		pcsInfo.setPcsDischarge(pcs_discharge);
		pcsDao.insertPcs(pcsInfo);
	}
	
	// 解析pcsDetail
	@Override
	public void analysisPCSDetail(String messager, int pcsDetailNumber) {
		// 去头，去尾
		messager = messager.substring(6, messager.length() - 5);
		// 计算数据的个数
		String[] split = messager.split(" ");
		int number = Integer.parseInt(split[0], 16);
		System.out.println("数据个数" + number);
		double pcs_detail_power = Integer.parseInt(split[1] + split[2], 16)-1500;
		double pcs_detail_voltage = Integer.parseInt(split[3] + split[4], 16);
		double pcs_detail_electricity = Integer.parseInt(split[5] + split[6], 16)-2000;
		int pcs_detail_inpute = Integer.parseInt(split[7] + split[8], 16) * 65536
				+ Integer.parseInt(split[9] + split[10], 16);
		int pcs_detail_outpute = Integer.parseInt(split[11] + split[12], 16) * 65536
				+ Integer.parseInt(split[13] + split[14], 16);
		
		PcsDetailInfo pcsDetailInfo = new  PcsDetailInfo();
		pcsDetailInfo.setPcsDetailPower(pcs_detail_power);
		pcsDetailInfo.setPcsDetailVoltage(pcs_detail_voltage);
		pcsDetailInfo.setPcsDetailElectricity(pcs_detail_electricity);
		pcsDetailInfo.setPcsDetailInpute(pcs_detail_inpute);
		pcsDetailInfo.setPcsDetailOutpute(pcs_detail_outpute);
		
		pcsDetailInfo.setPcsDetailNumber(pcsDetailNumber);
		pcsDetailInfo.setInsertDate(LocalDateTime.now());
		
		pcsDetailDao.insertPcsDetail(pcsDetailInfo);
	}
	
	
	// 解析powergrid-load
	@Override
	public void analysisPGL(String messager) {
		// 去头，去尾
		messager = messager.substring(6, messager.length() - 5);
		// 计算数据的个数
		String[] split = messager.split(" ");
		int number = Integer.parseInt(split[0], 16);
		System.out.println("数据个数" + number);
		double powergrid_power = Integer.parseInt(split[1] + split[2], 16);
		double powergrid_inpute = (Integer.parseInt(split[3] + split[4], 16) * 65536
				+ Integer.parseInt(split[5] + split[6], 16)) / 1000;
		double powergrid_outpute = (Integer.parseInt(split[7] + split[8], 16) * 65536
				+ Integer.parseInt(split[9] + split[10], 16)) / 1000;
		double load_power = Integer.parseInt(split[11] + split[12], 16);
		double load_inpute = (Integer.parseInt(split[13] + split[14], 16) * 65536
				+ Integer.parseInt(split[15] + split[16], 16)) / 1000;
		double load_outpute = (Integer.parseInt(split[17] + split[18], 16) * 65536
				+ Integer.parseInt(split[19] + split[20], 16)) / 1000;
		
		PowergridLoadInfo powergridLoadInfo = new PowergridLoadInfo();
		powergridLoadInfo.setPowergridPower(powergrid_power);
		powergridLoadInfo.setPowergridInpute(powergrid_inpute);
		powergridLoadInfo.setPowergridOutpute(powergrid_outpute);
		powergridLoadInfo.setLoadPower(load_power);
		powergridLoadInfo.setLoadInpute(load_inpute);
		powergridLoadInfo.setLoadOutpute(load_outpute);
		powergridLoadInfo.setInsertDate(LocalDateTime.now());
		powergridLoadDao.insertPowergridLoad(powergridLoadInfo);
	}

	

}
