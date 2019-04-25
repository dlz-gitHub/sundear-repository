package com.v2h.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.sundear.base.enumeration.SearchEnum.SearchTypeEnum;
import com.v2h.core.model.CabinInfo;
import com.v2h.core.model.CarportInfo;
import com.v2h.core.model.EnvironmentMonitoringInfo;
import com.v2h.core.model.InverterInfo;
import com.v2h.core.search.CabinInfoSearch;
import com.v2h.core.search.CarportInfoSearch;
import com.v2h.core.search.EnvironmentMonitoringInfoSearch;
import com.v2h.core.search.InverterInfoSearch;
import com.v2h.service.CabinService;
import com.v2h.service.CarportService;
import com.v2h.service.EnvironmentMonitoringService;
import com.v2h.service.InverterService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;




/**  
* @ClassName: DeviceInfoController  
* @Description: TODO(设备详情的接口入口)
* @date 2019年4月21日 下午2:34:07 
* @author dlz   
*/
@RestController
@RequestMapping("/deviceInfo")
public class DeviceInfoController {
	private static final Logger LOG = LoggerFactory.getLogger(DeviceInfoController.class);
	
	@Autowired
	private EnvironmentMonitoringService emService;
	
	@Autowired
	private InverterService inverterService;
	
	@Autowired
	private CarportService carportService;
	
	@Autowired
	private CabinService cabinService;
	
	@Value("${DeviceInfo.maxOutputPower}")
	private String maxOutputPower;
	
	@Value("${DeviceInfo.maxDailyOutputE}")
	private String maxDailyOutputE;
	
	//==========环境检测开始================
	@ApiOperation(value="获取环境检测是辐照值和温度曲线", notes="需要数据是对象中的enviromentTemperature和totalRadiation")
	@RequestMapping(value = "/enviromentInfo", method = RequestMethod.GET)
	public JSONObject getEMMessager() {
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
		
		EnvironmentMonitoringInfoSearch environmentMonitoringInfoSearch = new EnvironmentMonitoringInfoSearch();
		environmentMonitoringInfoSearch.setAdditionalWhereSql(" and insert_date between '"+startTime+"' and '"+endTime+"'");
		environmentMonitoringInfoSearch.setOrderBy("insert_date desc");
		List<EnvironmentMonitoringInfo> dataList = emService.searchEnvironmentMonitoring(environmentMonitoringInfoSearch );
		
		json.put("list", dataList);
		return json;
		
	}
	
	//==========环境检测结束================
	
	//=========集装箱设备详情开始================
	@ApiOperation(value="获取集装箱3个光伏系统的详情数据", notes="需要数据是每个对象中的属性")
	@RequestMapping(value = "/container/inverterInfo", method = RequestMethod.GET)
	//@ApiImplicitParam(name = "timeDiff", value = "时间间隔", paramType = "query")
	public JSONObject getContainerInverterInfo(HttpServletRequest request){
		//LOG.info("时间间隔为"+timeDiff+"===>请求路径"+request.getRequestURI());
		JSONObject json = new JSONObject();
		/*String today = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		String endTime = today + " 23:59:59";
		//计算开始时间
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(new Date());*/

		Map<String, Map<String, Object>> map = new HashMap<>();
		//暂时不处理时间间隔问题
		for (int i = 1; i <= 3; i++) {
			InverterInfoSearch inverterInfoSearch = new InverterInfoSearch();
			inverterInfoSearch.setAdditionalWhereSql("and inverter_number = " + i);
			/*//根据时间间隔来设置时间
			if (timeDiff!=null&&timeDiff.equals("oneWeek")) {//一周
				calendar.add(Calendar.DATE, -7);
				Date todayBefore = calendar.getTime();		
				String  startTime = new SimpleDateFormat("yyyy-MM-dd").format(todayBefore)+" 00:00:00";
				inverterInfoSearch.setAdditionalWhereSql(" group by DATE_FORMAT(insert_date,'%Y-%m-%d')  having insert_date between '"+startTime+"' and '"+endTime+"'");
			}else if(timeDiff!=null&&timeDiff.equals("oneMonth")) {//一月
				calendar.add(Calendar.MONTH, -1);
				Date todayBefore = calendar.getTime();		
				String  startTime = new SimpleDateFormat("yyyy-MM-dd").format(todayBefore)+" 00:00:00";
				inverterInfoSearch.setAdditionalWhereSql(" group by DATE_FORMAT(insert_date,'%Y-%m-%d')  having insert_date between '"+startTime+"' and '"+endTime+"'");
			}else if(timeDiff!=null&&timeDiff.equals("threeMonth")) {//三月
				calendar.add(Calendar.MONTH, -3);
				Date todayBefore = calendar.getTime();		
				String  startTime = new SimpleDateFormat("yyyy-MM-dd").format(todayBefore)+" 00:00:00";
				inverterInfoSearch.setAdditionalWhereSql(" group by DATE_FORMAT(insert_date,'%Y-%m-%d')  having insert_date between '"+startTime+"' and '"+endTime+"'");
			}else if(timeDiff!=null&&timeDiff.equals("sixMonth")) {//六月
				calendar.add(Calendar.MONTH, -6);
				Date todayBefore = calendar.getTime();		
				String  startTime = new SimpleDateFormat("yyyy-MM-dd").format(todayBefore)+" 00:00:00";
				inverterInfoSearch.setAdditionalWhereSql(" group by DATE_FORMAT(insert_date,'%Y-%m-%d')  having insert_date between '"+startTime+"' and '"+endTime+"'");
			}*/
			
			inverterInfoSearch.setOrderBy("insert_date desc");
			List<InverterInfo> inverterList = inverterService.searchInverter(inverterInfoSearch);
			
			if (inverterList!=null&&inverterList.size()!=0) {
				InverterInfo inverterInfo = inverterList.get(0);
				if (i == 1 && inverterInfo != null) {
					Map<String, Object> inverter1 = new HashMap<>();
					inverter1.put("systemStatus", inverterInfo.getRunningStatus());
					inverter1.put("maxOutputPower", maxOutputPower);
					inverter1.put("currentPower", 6.6);
					inverter1.put("totalTime", inverterInfo.getTotalOutputeTime());
					inverter1.put("maxDailyOutputE", maxDailyOutputE);
					inverter1.put("dailyOutputE", inverterInfo.getDailyOutpute());
					inverter1.put("totalOutputE", inverterInfo.getTotalOutpute());

					map.put("inverter1", inverter1);
				} else if (i == 2 && inverterInfo != null) {
					Map<String, Object> inverter2 = new HashMap<>();
					inverter2.put("systemStatus", inverterInfo.getRunningStatus());
					inverter2.put("maxOutputPower", maxOutputPower);
					inverter2.put("currentPower", 11.6);
					inverter2.put("totalTime", inverterInfo.getTotalOutputeTime());
					inverter2.put("maxDailyOutputE", maxDailyOutputE);
					inverter2.put("dailyOutputE", inverterInfo.getDailyOutpute());
					inverter2.put("totalOutputE", inverterInfo.getTotalOutpute());

					map.put("inverter2", inverter2);
				} else if (i == 3 && inverterInfo != null) {
					Map<String, Object> inverter3 = new HashMap<>();
					inverter3.put("systemStatus", inverterInfo.getRunningStatus());
					inverter3.put("maxOutputPower", maxOutputPower);
					inverter3.put("currentPower", 11.6);
					inverter3.put("totalTime", inverterInfo.getTotalOutputeTime());
					inverter3.put("maxDailyOutputE", maxDailyOutputE);
					inverter3.put("dailyOutputE", inverterInfo.getDailyOutpute());
					inverter3.put("totalOutputE", inverterInfo.getTotalOutpute());

					map.put("inverter3", inverter3);
				}
			}
		}
		json.put("map", map);
		return json;
	}
	//=========集装箱设备详情结束================
	
	//=========移动车棚设备详情开始================
	
	@ApiOperation(value="获取2个移动车棚详情数据", notes="需要数据是每个对象中的属性")
	@RequestMapping(value = "/carportInfo", method = RequestMethod.GET)
	//@ApiImplicitParam(name = "timeDiff", value = "时间间隔", paramType = "query")
	public JSONObject getCarportInfo(HttpServletRequest request){
		//LOG.info("时间间隔为"+timeDiff+"===>请求路径"+request.getRequestURI());
		JSONObject json = new JSONObject();
		
		//Map<String, Map<String, Object>> map = new HashMap<>();
		CarportInfoSearch carportInfoSearch = new CarportInfoSearch();
		carportInfoSearch.setOrderBy("insert_date desc");
		carportInfoSearch.setSearchType(SearchTypeEnum.TOP);
		carportInfoSearch.setTop(1);
		List<CarportInfo> carportList = carportService.searchCarport(carportInfoSearch );
		if (carportList!=null&&carportList.size()!=0) {
			CarportInfo carportInfo = carportList.get(0);
			json.put("map1", carportInfo);
		}
		
		//模拟另一个移动车棚的信息
		Map<String, Object> carport1 = new HashMap<>();
		carport1.put("flotrolTrafficStatus",1);
		carport1.put("flotrolRunningStatus", 1);
		carport1.put("flotrolOutputVoltage", 800);
		carport1.put("flotrolOutputElectricity",377.8);
		carport1.put("ascTrafficStatus", 1);
		carport1.put("ascRunningStatus", 1);
		carport1.put("ascConnectionStatus", 2);
		carport1.put("inverterTrafficStatus", 1);
		carport1.put("inverterBypassInput", 1);
		carport1.put("inverterFaultStatus", 2);
		carport1.put("inverterOutputVoltage", 32);
		carport1.put("inverterTemperature", 8);
		carport1.put("inverterOutputE", 455);
		json.put("map2", carport1);
		return json;
	}
	//=========移动车棚设备详情结束================
	
	
	//=========户用储能设备详情开始================
	
	@ApiOperation(value="获取户用存储详情数据", notes="需要数据是每个对象中的属性")
	@RequestMapping(value = "/cabinInfo", method = RequestMethod.GET)
	//@ApiImplicitParam(name = "timeDiff", value = "时间间隔", paramType = "query")
	public JSONObject getCabinInfo(HttpServletRequest request){
		//LOG.info("时间间隔为"+timeDiff+"===>请求路径"+request.getRequestURI());
		JSONObject json = new JSONObject();
		
		CabinInfoSearch cabinInfoSearch = new CabinInfoSearch();
		cabinInfoSearch.setOrderBy("insert_date desc");
		cabinInfoSearch.setSearchType(SearchTypeEnum.TOP);
		cabinInfoSearch.setTop(1);
		List<CabinInfo> cabinList = cabinService.searchCabin(cabinInfoSearch );
		if (cabinList!=null&&cabinList.size()!=0) {
			CabinInfo cabinInfo = cabinList.get(0);
			json.put("map", cabinInfo);
			json.put("pv1Power", cabinInfo.getCabinPv1Voltage()*cabinInfo.getCabinPv1Electricity());
			json.put("pv2Power", cabinInfo.getCabinPv2Voltage()*cabinInfo.getCabinPv2Electricity());
		}
		
		return json;
	}
	//=========户用储能设备详情结束================
	
}
