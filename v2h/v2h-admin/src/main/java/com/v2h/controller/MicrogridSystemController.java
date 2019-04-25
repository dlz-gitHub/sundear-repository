package com.v2h.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.omg.CORBA.PRIVATE_MEMBER;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.sundear.base.enumeration.SearchEnum.SearchTypeEnum;
import com.v2h.core.model.CabinInfo;
import com.v2h.core.model.CarportInfo;
import com.v2h.core.model.EnvironmentMonitoringInfo;
import com.v2h.core.model.InverterInfo;
import com.v2h.core.model.PcsDetailInfo;
import com.v2h.core.model.PowergridLoadInfo;
import com.v2h.core.search.CabinInfoSearch;
import com.v2h.core.search.CarportInfoSearch;
import com.v2h.core.search.EnvironmentMonitoringInfoSearch;
import com.v2h.core.search.InverterInfoSearch;
import com.v2h.core.search.PcsDetailInfoSearch;
import com.v2h.core.search.PowergridLoadInfoSearch;
import com.v2h.service.CabinService;
import com.v2h.service.CarportService;
import com.v2h.service.EnvironmentMonitoringService;
import com.v2h.service.InverterService;
import com.v2h.service.PcsDetailService;
import com.v2h.service.PowergridLoadService;

import io.swagger.annotations.ApiOperation;

/**  
* @ClassName: ContainerController  
* @Description: TODO(微电网接口入口)
* @date 2019年4月16日 下午6:32:43 
* @author dlz   
*/
@RestController
@RequestMapping("/miceogrid")
public class MicrogridSystemController {
	private static final Logger LOG = LoggerFactory.getLogger(MicrogridSystemController.class);
	
	@Autowired
	private InverterService inverterService;
	
	@Autowired
	private EnvironmentMonitoringService emService;
	
	@Autowired
	private PowergridLoadService plService;
	
	@Autowired
	private PcsDetailService pcsDetailService;
	
	@Autowired
	private CabinService cabinService;
	
	@Autowired
	private CarportService carportService;
	
	
	@Value("${MS.inverterCapacity}")
	private String inverterCapacity;
	
	@Value("${MS.storedEnergyCapacity}")
	private String storedEnergyCapacity;
	
	@Value("${MS.inverterArea}")
	private String inverterArea;
	
	@Value("${MS.inverterCount}")
	private String inverterCount;
	
	@Value("${MS.cpInverterCapacity}")
	private String cpInverterCapacity;
	
	@Value("${MS.cpStoredEnergyCapacity}")
	private String cpStoredEnergyCapacity;
	
	@Value("${MS.cpInverterArea}")
	private String cpInverterArea;
	
	@Value("${MS.cpInverterCount}")
	private String cpInverterCount;
	
	@Value("${MS.usInstallCapacity}")
	private String usInstallCapacity;
	
	@Value("${MS.usInstallCount}")
	private String usInstallCount;
	//=============微电网部分 ---集装箱部分接口开始============

	@ApiOperation(value="集装箱光伏功率曲线", notes="3个逆变器的功率,每天的所有数据")
	@RequestMapping(value = "/container/containerGraphOfInverter", method = RequestMethod.GET)
	public JSONObject getInverterPower(HttpServletRequest request) {
		JSONObject json = new JSONObject();
		//返回数据是一个Map key发分别是3个逆变器的编号，vlaue是一个Double集合
		
		String today = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		String startTime = today + " 00:00:00";
		//获取推后一天的时间
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(new Date());
		//向后推一天
		calendar.add(Calendar.DATE, 1);
		Date todayAfter = calendar.getTime();		
		String  endTime = new SimpleDateFormat("yyyy-MM-dd").format(todayAfter)+" 00:00:00";
		
		Map<Integer,List<Map<LocalDateTime, Double>>> datas = new HashMap<>();
		
		for (int i = 1; i <= 3; i++) {
			InverterInfoSearch inverterInfoSearch = new InverterInfoSearch();	
			inverterInfoSearch.setAdditionalWhereSql("and inverter_number = " + i +" and insert_date between '"+startTime+"' and '"+endTime+"'");
			inverterInfoSearch.setOrderBy("insert_date desc"); 
			List<InverterInfo> inverterList = inverterService.searchInverter(inverterInfoSearch);
			
			//分别加入相应的模块
			if (inverterList!=null&&inverterList.get(0).getInverterNumber()==1) {//逆变器1号
				List<Map<LocalDateTime, Double>> list1 = new ArrayList<>();
				for (InverterInfo inverterInfo : inverterList) {
					Map<LocalDateTime, Double> map = new HashMap<>();
					map.put(inverterInfo.getInsertDate(), inverterInfo.getTotalOutPower()/1000.0);
					list1.add(map);
				}
				//放入Map中
				datas.put(1, list1);
			}else if(inverterList!=null&&inverterList.get(0).getInverterNumber()==2) {//逆变器2号
				List<Map<LocalDateTime, Double>> list2 = new ArrayList<>();
				for (InverterInfo inverterInfo : inverterList) {
					Map<LocalDateTime, Double> map = new HashMap<>();
					map.put(inverterInfo.getInsertDate(), inverterInfo.getTotalOutPower()/1000.0);
					list2.add(map);
				}
				//放入Map中
				datas.put(2, list2);
			}else if(inverterList!=null&&inverterList.get(0).getInverterNumber()==3) {//逆变器3好号
				List<Map<LocalDateTime, Double>> list3 = new ArrayList<>();
				for (InverterInfo inverterInfo : inverterList) {
					Map<LocalDateTime, Double> map = new HashMap<>();
					map.put(inverterInfo.getInsertDate(), inverterInfo.getTotalOutPower()/1000.0);
					list3.add(map);
				}
				//放入Map中
				datas.put(3, list3);
			}else {
				LOG.warn("inverterList可能为null 请求路径为："+request.getRequestURI());
			}
		}
		json.put("map", datas);
		return json;
	}
	
	@ApiOperation(value="集装箱PCS功率曲线", notes="3个PCS的功率,每天的所有数据")
	@RequestMapping(value = "/container/containerGraphOfPcs", method = RequestMethod.GET)
	public JSONObject getPcsPower(HttpServletRequest request) {
		JSONObject json = new JSONObject();
			
		String today = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		String startTime = today + " 00:00:00";
		//获取推后一天的时间
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(new Date());
		//向后推一天
		calendar.add(Calendar.DATE, 1);
		Date todayAfter = calendar.getTime();		
		String  endTime = new SimpleDateFormat("yyyy-MM-dd").format(todayAfter)+" 00:00:00";
		
		Map<Integer,List<Map<LocalDateTime, Double>>> datas = new HashMap<>();
		
		for (int i = 1; i <= 3; i++) {
			PcsDetailInfoSearch pcsDetailInfoSearch = new PcsDetailInfoSearch();
			pcsDetailInfoSearch.setAdditionalWhereSql("and pcs_detail_number = " + i +" and insert_date between '"+startTime+"' and '"+endTime+"'");
			pcsDetailInfoSearch.setOrderBy("insert_date desc");
			List<PcsDetailInfo> pcsDetailList = pcsDetailService.searchPcsDetail(pcsDetailInfoSearch );
			
			if(pcsDetailList!=null&&pcsDetailList.get(0).getPcsDetailNumber()==1) {
				List<Map<LocalDateTime, Double>> list1 = new ArrayList<>();
				for (PcsDetailInfo pcsDetailInfo : pcsDetailList) {
					Map<LocalDateTime, Double> map = new HashMap<>();
					map.put(pcsDetailInfo.getInsertDate(), pcsDetailInfo.getPcsDetailPower());
					list1.add(map);
				}
				//放入Map中
				datas.put(1, list1);
			}else if(pcsDetailList!=null&&pcsDetailList.get(0).getPcsDetailNumber()==2) {
				List<Map<LocalDateTime, Double>> list2 = new ArrayList<>();
				for (PcsDetailInfo pcsDetailInfo : pcsDetailList) {
					Map<LocalDateTime, Double> map = new HashMap<>();
					map.put(pcsDetailInfo.getInsertDate(), pcsDetailInfo.getPcsDetailPower());
					list2.add(map);
				}
				//放入Map中
				datas.put(2, list2);
			}else if(pcsDetailList!=null&&pcsDetailList.get(0).getPcsDetailNumber()==3) {
				List<Map<LocalDateTime, Double>> list3 = new ArrayList<>();
				for (PcsDetailInfo pcsDetailInfo : pcsDetailList) {
					Map<LocalDateTime, Double> map = new HashMap<>();
					map.put(pcsDetailInfo.getInsertDate(), pcsDetailInfo.getPcsDetailPower());
					list3.add(map);
				}
				//放入Map中
				datas.put(3, list3);
			}else {
				LOG.warn("pcsDetailList可能为null 请求路径为："+request.getRequestURI());
			}
		
		}
		json.put("map", datas);
		return json;
	}
	
	
	@ApiOperation(value="集装箱电网、负载功率曲线", notes="电网、负载的功率,每天的所有数据,需要的数据是对象中powerGridPower和loadPower")
	@RequestMapping(value = "/container/containerGraphOfPowerGrid", method = RequestMethod.GET)
	public JSONObject getPowerGridLoadPower(HttpServletRequest request) {
		JSONObject json = new JSONObject();
		
		String today = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		String startTime = today + " 00:00:00";
		//获取推后一天的时间
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(new Date());
		//向后推一天
		calendar.add(Calendar.DATE, 1);
		Date todayAfter = calendar.getTime();		
		String  endTime = new SimpleDateFormat("yyyy-MM-dd").format(todayAfter)+" 00:00:00";
		
		PowergridLoadInfoSearch powergridLoadInfoSearch = new PowergridLoadInfoSearch();
		
		powergridLoadInfoSearch.setAdditionalWhereSql(" and insert_date between '"+startTime+"' and '"+endTime+"'");
		powergridLoadInfoSearch.setOrderBy(" insert_date desc");
		
		List<PowergridLoadInfo> dataList = plService.searchPowergridLoad(powergridLoadInfoSearch );
		
		if (dataList==null) {
			LOG.warn("pcsDetailList可能为null 请求路径为："+request.getRequestURI());			
		}
		json.put("list", dataList);
		return json;
	}
	
	
	@ApiOperation(value="电站系统信息", notes="电站系统部分运行模式，需求数据是对象中的 eNVIRONMENTTEMPERATURE和TOTALRADIATION")
	@RequestMapping(value = "/container/containerPowerPlantMessager", method = RequestMethod.GET)
	public JSONObject getContainerPowerPlantMessager(HttpServletRequest request) {
		JSONObject json = new JSONObject();
		
		EnvironmentMonitoringInfoSearch environmentMonitoringInfoSearch = new EnvironmentMonitoringInfoSearch();
		environmentMonitoringInfoSearch.setOrderBy("insert_date desc");
		environmentMonitoringInfoSearch.setSearchType(SearchTypeEnum.TOP);
		environmentMonitoringInfoSearch.setTop(1);
		List<EnvironmentMonitoringInfo> dataList = emService.searchEnvironmentMonitoring(environmentMonitoringInfoSearch );
		if (dataList!=null) {
			json.put("emInfo", dataList.get(0));
			json.put("runningMessager", "削峰填谷");
			//添加一下集装箱系统信息
			json.put("usInstallCapacity", usInstallCapacity);
			json.put("usInstallCount", usInstallCount);
			return json; 
		}else {
			LOG.warn("dataList可能为null 请求路径为："+request.getRequestURI());			
			json.put("faultMessager", "null");
			//添加一下集装箱系统信息
			json.put("usInstallCapacity", usInstallCapacity);
			json.put("usInstallCount", usInstallCount);
			return json;
		}		
		
	}
	
	@ApiOperation(value="集装箱电量统计", notes="3个逆变器的总光伏发电量")
	@RequestMapping(value = "/container/inverterOutputE", method = RequestMethod.GET)
	public JSONObject getInverterOutputE(HttpServletRequest request) {
		JSONObject json = new JSONObject();
				
		for (int i = 1; i <= 3; i++) {
			InverterInfoSearch inverterInfoSearch = new InverterInfoSearch();	
			inverterInfoSearch.setAdditionalWhereSql("and inverter_number = " + i );
			inverterInfoSearch.setOrderBy("insert_date desc");
			inverterInfoSearch.setSearchType(SearchTypeEnum.TOP);
			inverterInfoSearch.setTop(1);

			List<InverterInfo> inverterInfoLsit = inverterService.searchInverter(inverterInfoSearch);
			if (inverterInfoLsit != null && inverterInfoLsit.size() != 0) {
				InverterInfo inverterInfo = inverterInfoLsit.get(0);
				if (i == 1 && inverterInfo != null) {
					json.put("inverter1", inverterInfo.getTotalOutpute());
				} else if (i == 2 && inverterInfo != null) {
					json.put("inverter2", inverterInfo.getTotalOutpute());
				} else if (i == 3 && inverterInfo != null) {
					json.put("inverter3", inverterInfo.getTotalOutpute());
				}
			} else {
				LOG.warn("inverterInfoLsit可能为null 请求路径为：" + request.getRequestURI());
			}
		}
		return json;
	}
	
	@ApiOperation(value="集装箱电量统计", notes="电网负载部分的吸收、释放电量，需求数据是对象中的loadInputE和loadOutPutE")
	@RequestMapping(value = "/container/powergridLoad", method = RequestMethod.GET)
	public JSONObject getPowergridLoadOfE() {
		JSONObject json = new JSONObject();
		
		PowergridLoadInfoSearch powergridLoadInfoSearch = new PowergridLoadInfoSearch();
		powergridLoadInfoSearch.setOrderBy("insert_date desc");
		powergridLoadInfoSearch.setSearchType(SearchTypeEnum.TOP);
		powergridLoadInfoSearch.setTop(1);	

		List<PowergridLoadInfo> powergridLoadInfoList = plService.searchPowergridLoad(powergridLoadInfoSearch);
		if (powergridLoadInfoList != null && powergridLoadInfoList.size() != 0) {
			PowergridLoadInfo powergridLoadInfo = powergridLoadInfoList.get(0);
			json.put("pgdInfo", powergridLoadInfo);
		}

		return json;
	}
	
	@ApiOperation(value="集装箱电量统计", notes="储能充放部分，三个bms信息")
	@RequestMapping(value = "/container/chargeDischarge", method = RequestMethod.GET)
	public JSONObject getEneryChargeDischarge() {
		JSONObject json = new JSONObject();
		
		List<Integer> inputE = new ArrayList<>();
		List<Integer> outputE = new ArrayList<>();
		for (int i = 1; i <= 3; i++) {
			PcsDetailInfoSearch pcsDetailInfoSearch = new PcsDetailInfoSearch();
			pcsDetailInfoSearch.setAdditionalWhereSql("and pcs_detail_number = " + i);
			pcsDetailInfoSearch.setOrderBy("insert_date desc");
			pcsDetailInfoSearch.setSearchType(SearchTypeEnum.TOP);
			pcsDetailInfoSearch.setTop(1);
			
			List<PcsDetailInfo> pcsDetailList = pcsDetailService.searchPcsDetail(pcsDetailInfoSearch);
			if (pcsDetailList != null && pcsDetailList.size() != 0) {
				PcsDetailInfo pcsDetailInfo = pcsDetailList.get(0);
				inputE.add(pcsDetailInfo.getPcsDetailInpute());
				outputE.add(pcsDetailInfo.getPcsDetailOutpute());
			}
		}
		
		json.put("inputE", inputE);
		json.put("outputE", outputE);
		return json;
	}
	//=============微电网部分 ---集装箱部分接口结束============
	
	
	//=============微电网部分 ---光伏屋顶部分接口开始============
	
	@ApiOperation(value="光伏屋顶负载、光伏功率曲线", notes="当天户用、小木屋负载功率曲线数据,需要数据是对象里的loadPower和inverterTotalPower")
	@RequestMapping(value = "/cabin/inverterLoadGraph", method = RequestMethod.GET)
	public JSONObject getCabinInverterLoadGraph() {
		JSONObject json = new JSONObject();
		
		String today = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		String startTime = today + " 00:00:00";
		//获取推后一天的时间
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(new Date());
		//向后推一天
		calendar.add(Calendar.DATE, 1);
		Date todayAfter = calendar.getTime();		
		String  endTime = new SimpleDateFormat("yyyy-MM-dd").format(todayAfter)+" 00:00:00";
		CabinInfoSearch cabinInfoSearch = new CabinInfoSearch();
		cabinInfoSearch.setAdditionalWhereSql(" and insert_date between '"+startTime+"' and '"+endTime+"'");
		cabinInfoSearch.setOrderBy("insert_date desc");

		List<CabinInfo> dataList = cabinService.searchCabin(cabinInfoSearch );
		
		json.put("list", dataList);
		return json;
	}
	
	@ApiOperation(value="光伏屋顶BMS功率曲线", notes="暂时数据没有,模拟一份数据放上")
	@RequestMapping(value = "/cabin/bmsPowerGraph", method = RequestMethod.GET)
	public JSONObject getCabinBmsPowerGraph() {
		JSONObject json = new JSONObject();
		
		String today = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		String startTime = today + " 00:00:00";
		//获取推后一天的时间
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(new Date());
		//向后推一天
		calendar.add(Calendar.DATE, 1);
		Date todayAfter = calendar.getTime();		
		String  endTime = new SimpleDateFormat("yyyy-MM-dd").format(todayAfter)+" 00:00:00";
		CabinInfoSearch cabinInfoSearch = new CabinInfoSearch();
		cabinInfoSearch.setAdditionalWhereSql(" and insert_date between '"+startTime+"' and '"+endTime+"'");
		cabinInfoSearch.setOrderBy("insert_date desc");

		
		List<CabinInfo> dataList = cabinService.searchCabin(cabinInfoSearch );
		List<Map<LocalDateTime, Double>> datas = new ArrayList<>();
		if (dataList!=null&&dataList.size()!=0) {
			for (CabinInfo cabinInfo : dataList) {
				Map<LocalDateTime, Double> map = new HashMap<>();
				map.put(cabinInfo.getInsertDate(), cabinInfo.getBatteryVoltage()*cabinInfo.getCabinPv2Electricity());
				datas.add(map);
			}
		}
		json.put("list", datas);
		return json;
	}
	
	@ApiOperation(value="光伏屋顶系统简介", notes="户用、小木屋部分数据介绍")
	@RequestMapping(value = "/cabin/systemImage", method = RequestMethod.GET)
	public JSONObject getCabinSystemImage() {
		JSONObject json = new JSONObject();
		
		json.put("inverterCapacity", inverterCapacity);
		json.put("storedEnergyCapacity", storedEnergyCapacity);
		json.put("inverterArea",inverterArea);
		json.put("inverterCount", inverterCount);
		return json;
	}
	
	//=============微电网部分 ---光伏屋顶部分接口结束============
	
	
	//=============微电网部分 ---移动储能部分接口开始============
	
	@ApiOperation(value="移动车棚光伏功率曲线", notes="当天移动车棚功率曲线数据,对象中的属性值为 inverterTotalPower")
	@RequestMapping(value = "/carport/inverterGraph", method = RequestMethod.GET)
	public JSONObject getCarportInverterGraph() {
		
		JSONObject json = new JSONObject();
		
		String today = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		String startTime = today + " 00:00:00";
		//获取推后一天的时间
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(new Date());
		//向后推一天
		calendar.add(Calendar.DATE, 1);
		Date todayAfter = calendar.getTime();		
		String  endTime = new SimpleDateFormat("yyyy-MM-dd").format(todayAfter)+" 00:00:00";
		
		CarportInfoSearch carportInfoSearch = new CarportInfoSearch();
		carportInfoSearch.setAdditionalWhereSql(" and insert_date between '"+startTime+"' and '"+endTime+"'");
		carportInfoSearch.setOrderBy("insert_date desc");
		
		List<CarportInfo> dataList = carportService.searchCarport(carportInfoSearch );
		
		json.put("list", dataList);
		return json;
	}
	
	@ApiOperation(value="移动车棚BMS功率曲线", notes="当天移动车棚功率曲线数据")
	@RequestMapping(value = "/carport/bmsGraph", method = RequestMethod.GET)
	public JSONObject getCarportBmsGraph() {
		
		JSONObject json = new JSONObject();
		
		
		String today = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		String startTime = today + " 00:00:00";
		//获取推后一天的时间
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(new Date());
		//向后推一天
		calendar.add(Calendar.DATE, 1);
		Date todayAfter = calendar.getTime();		
		String  endTime = new SimpleDateFormat("yyyy-MM-dd").format(todayAfter)+" 00:00:00";
		
		CarportInfoSearch carportInfoSearch = new CarportInfoSearch();
		carportInfoSearch.setAdditionalWhereSql(" and insert_date between '"+startTime+"' and '"+endTime+"'");
		carportInfoSearch.setOrderBy("insert_date desc");
		List<CarportInfo> searchCarportList = carportService.searchCarport(carportInfoSearch );
		
		List<Map<LocalDateTime, Double>> datas = new ArrayList<>();
		//遍历计算
		for (CarportInfo carportInfo : searchCarportList) {
			double voltage = carportInfo.getBmsVoltage();
			double electricity = carportInfo.getBatteryElectricity();
			double bmsPower = voltage*electricity;
			Map<LocalDateTime, Double> map = new HashMap<>();
			map.put(carportInfo.getInsertDate(), bmsPower);
			//加入集合
			datas.add(map);
		}
		
		json.put("list", datas);
		return json;
	}
	
	
	@ApiOperation(value="移动车棚系统简介", notes="移动储能的系统部分数据")
	@RequestMapping(value = "/carport/systemImage", method = RequestMethod.GET)
	public JSONObject getCarportSystemMessager() {
		JSONObject json = new JSONObject();
		
		json.put("inverterCapacity", cpInverterCapacity);
		json.put("storedEnergyCapacity", cpStoredEnergyCapacity);
		json.put("inverterArea", cpInverterArea);
		json.put("inverterCount", cpInverterCount);
		return json;
	}
	//=============微电网部分 ---移动储能部分接口结束============
	
}
