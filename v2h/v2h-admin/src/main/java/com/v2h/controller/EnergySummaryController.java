package com.v2h.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.sundear.base.enumeration.SearchEnum.SearchTypeEnum;
import com.v2h.core.model.CabinInfo;
import com.v2h.core.model.CarportInfo;
import com.v2h.core.model.InverterInfo;
import com.v2h.core.model.PcsInfo;
import com.v2h.core.search.CabinInfoSearch;
import com.v2h.core.search.CarportInfoSearch;
import com.v2h.core.search.InverterInfoSearch;
import com.v2h.core.search.PcsInfoSearch;
import com.v2h.service.CabinService;
import com.v2h.service.CarportService;
import com.v2h.service.InverterService;
import com.v2h.service.PcsService;

import io.swagger.annotations.ApiOperation;

/**  
* @ClassName: EnergySummaryController  
* @Description: TODO(能源汇总接口入口)
* @date 2019年4月18日 下午1:14:19 
* @author dlz   
*/
@RestController
@RequestMapping("/energySummary")
public class EnergySummaryController {
	
	private static final Logger LOG = LoggerFactory.getLogger(EnergySummaryController.class);
	@Autowired
	private InverterService inverterService;
	
	@Autowired
	private PcsService pcsService;
	
	@Autowired
	private CabinService cabinService;
	
	@Autowired
	private CarportService  carportService;
	//接入信息
	@Value("${ES.pvInstalledCapacity}")
	private String pvInstalledCapacity;
	
	@Value("${ES.seInstalledCapacity}")
	private String seInstalledCapacity;
	
	@Value("${ES.chargingPileCount}")
	private String chargingPileCount;
	
	@Value("${ES.loadCapacity}")
	private String loadCapacity;
	
	//节能减排信息
	@Value("${ES.crudeOil}")
	private String crudeOil;
	
	@Value("${ES.gasoline}")
	private String gasoline;
	
	@Value("${ES.carbonDioxide}")
	private String carbonDioxide;
	
	@Value("${ES.trees}")
	private String trees;
	//==========图表数据的接口开始=========
	
	//集装箱部分
	@ApiOperation(value="集装箱能源汇总曲线图", notes="近五个月每天的发电、充电、放电")
	@RequestMapping(value = "/containerGraph", method = RequestMethod.GET)
	public JSONObject getEnergyOfContainerGraph() {
		
		JSONObject json = new JSONObject();
		//计算时间差
		String today = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		String endTime = today + " 23:59:59";
		
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(new Date());
		//向后推4个月时间
		calendar.add(Calendar.MONTH, -4);
		Date  todayBefore= calendar.getTime();		
		String  startTime = new SimpleDateFormat("yyyy-MM-dd").format(todayBefore)+" 00:00:00";
		
		Map<String,List<InverterInfo>> map = new HashMap<>();
		//发电量(图表)
		
		for (int i = 1; i <= 3; i++) {
			InverterInfoSearch inverterInfoSearch = new InverterInfoSearch();
			inverterInfoSearch.setAdditionalWhereSql(" and inverter_number = " + i + "  group by DATE_FORMAT(insert_date,'%Y-%m-%d')"
					+ " having insert_date between '"+startTime+"' and '"+endTime+"'");
			
			inverterInfoSearch.setOrderBy("insert_date desc");
			
			List<InverterInfo> inverterList = inverterService.searchInverter(inverterInfoSearch);
			map.put("inverter"+i, inverterList);
		}
		//存放3个逆变器每天的发电量
		List<Double> outputEList = new ArrayList<>();
		//计算每天的发电量
		for (int i = 0;i < map.get("inverter1").size();i++) {
			double electricity = map.get("inverter1").get(i).getDailyOutpute()
					+map.get("inverter2").get(i).getDailyOutpute()
					+map.get("inverter3").get(i).getDailyOutpute();
			//加入集合
			outputEList.add(electricity);
		}
		//充电量、放电量(图表)
		PcsInfoSearch pcsInfoSearch = new PcsInfoSearch();
		pcsInfoSearch.setAdditionalWhereSql(" group by DATE_FORMAT(insert_date,'%Y-%m-%d')"
				+ " having insert_date between '"+startTime+"' and '"+endTime+"'");
		pcsInfoSearch.setOrderBy("insert_date desc");
		
		List<PcsInfo> pcsInfos = pcsService.searchPcs(pcsInfoSearch);
		
		json.put("generateElectricity", outputEList);
		//充电和放电分别是属性pcsCharge和pcsDischarge
		json.put("chargeAndDischarge", pcsInfos);
		return json;
	}
	
	//移动车棚
	@ApiOperation(value="移动车棚能源汇总曲线图", notes="暂时使用近五个月每天的发电功率、充电机功率")
	@RequestMapping(value = "/carportGraph", method = RequestMethod.GET)
	public JSONObject getEnergyOfCarportGraph() {
		JSONObject json = new JSONObject();
		//计算时间差
		String today = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		String endTime = today + " 23:59:59";
		
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(new Date());
		//向后推4个月时间
		calendar.add(Calendar.MONTH, -4);
		Date  todayBefore= calendar.getTime();		
		String  startTime = new SimpleDateFormat("yyyy-MM-dd").format(todayBefore)+" 00:00:00";
		
		CarportInfoSearch carportInfoSearch = new CarportInfoSearch();
		carportInfoSearch.setAdditionalWhereSql("  group by DATE_FORMAT(insert_date,'%Y-%m-%d')"
				+ " having insert_date between '"+startTime+"' and '"+endTime+"'");
		
		carportInfoSearch.setOrderBy("insert_date desc");
		List<CarportInfo> carportList = carportService.searchCarport(carportInfoSearch );
		
		List<Map<String, Double>> inverterPower = new ArrayList<>();
		List<Map<String, Double>> chargePower = new ArrayList<>();
		
		DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		if (carportList!=null&&carportList.size()!=0) {
			//遍历计算充电机功率
			for (CarportInfo carportInfo : carportList) {
				Map<String, Double> map1 = new HashMap<>();
				Map<String, Double> map2 = new HashMap<>();
				map1.put(df.format(carportInfo.getInsertDate()).substring(0, 10), carportInfo.getInverterOutPower());
				map2.put(df.format(carportInfo.getInsertDate()).substring(0, 10), carportInfo.getFlotrolOutputVoltage()*carportInfo.getFlotrolOutputElectricity());
				inverterPower.add(map1);
				chargePower.add(map2);
			}
		}
		json.put("inverterPower", inverterPower);
		json.put("chargePower", chargePower);
		return json;
	}
	
	// 户用储能
	@ApiOperation(value = "户用储能汇总曲线图", notes = "近五个月每天光伏发电、负载用电、回馈电网电量")
	@RequestMapping(value = "/cabinGraph", method = RequestMethod.GET)
	public JSONObject getEnergyOfCabin() {
		JSONObject json = new JSONObject();
		// 计算时间差
		String today = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		String endTime = today + " 23:59:59";
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(new Date());
		// 向后推4个月时间
		calendar.add(Calendar.MONTH, -4);
		Date todayBefore = calendar.getTime();
		String startTime = new SimpleDateFormat("yyyy-MM-dd").format(todayBefore)+" 00:00:00";
		
		CabinInfoSearch cabinInfoSearch = new CabinInfoSearch();
		cabinInfoSearch.setAdditionalWhereSql(" group by DATE_FORMAT(insert_date,'%Y-%m-%d')"
				+ " having insert_date between '"+startTime+"' and '"+endTime+"'");
		cabinInfoSearch.setOrderBy("insert_date desc");
		List<CabinInfo> cabinList = cabinService.searchCabin(cabinInfoSearch );
		json.put("list", cabinList);
		return json;
	}
	//==========图表数据的接口结束=========
	
	//============数据统计数据接口开始==================
	
	@ApiOperation(value="获取能源汇总的接入信息", notes="接入信息内容暂定")
	@RequestMapping(value = "/joinUpMessager", method = RequestMethod.GET)
	public JSONObject getJoinUpMessager() {
		JSONObject json = new JSONObject();
		json.put("pvInstalledCapacity", pvInstalledCapacity);
		json.put("seInstalledCapacity", seInstalledCapacity);
		json.put("chargingPileCount", chargingPileCount);
		json.put("loadCapacity", loadCapacity);
		return json;
	}
	
	@ApiOperation(value="获取能源汇总的电量信息", notes="电量信息是3个部分的总和")
	@RequestMapping(value = "/electricMessager", method = RequestMethod.GET)
	public JSONObject getElectricMessager(HttpServletRequest request) {
		JSONObject json = new JSONObject();
		
		//总发电量是集装箱和户用的总和
		
		Map<String,InverterInfo> map = new HashMap<>();
		
		for (int i = 1; i <= 3; i++) {
			InverterInfoSearch inverterInfoSearch = new InverterInfoSearch();
			inverterInfoSearch.setAdditionalWhereSql(" and inverter_number = " + i);
			inverterInfoSearch.setSearchType(SearchTypeEnum.TOP);
			inverterInfoSearch.setTop(1);
			inverterInfoSearch.setOrderBy("insert_date desc");
			
			List<InverterInfo> inverterList = inverterService.searchInverter(inverterInfoSearch);
			if(inverterList!=null&&inverterList.size()!=0) {
				InverterInfo inverterInfo = inverterList.get(0);
				map.put("inverter"+i, inverterInfo);
			}else {
				LOG.warn("inverterList为null或者为空"+request.getRequestURI());
				map.put("inverter"+i, null);
				break;
			}
			
		}
		double totalOutputElectric = 0.0;
		if (map.get("inverter1") != null) {
			totalOutputElectric = map.get("inverter1").getTotalOutpute() + map.get("inverter2").getTotalOutpute()
					+ map.get("inverter3").getTotalOutpute();
		}else {
			LOG.warn("算出的总发电量信息缺失集装箱部分"+request.getRequestURI());
		}
		
		
		CabinInfoSearch cabinInfoSearch = new CabinInfoSearch();
		cabinInfoSearch.setSearchType(SearchTypeEnum.TOP);
		cabinInfoSearch.setTop(1);
		cabinInfoSearch.setOrderBy("insert_date desc");
		List<CabinInfo> cabinList = cabinService.searchCabin(cabinInfoSearch );
		
		CabinInfo cabinInfo = new CabinInfo();
		if(cabinList!=null&&cabinList.size()!=0) {
			cabinInfo = cabinList.get(0);			
		}
		totalOutputElectric += cabinInfo.getCabinTotalOutpute();		
		json.put("totalOutputE", totalOutputElectric);
		
		//负载总用电量是户用的用电量
		json.put("totalLoadE", cabinInfo.getLoadTotalEq());
		
		
		//储能充放电量是集装箱的充方电量
		PcsInfoSearch pcsInfoSearch = new PcsInfoSearch(); 
		pcsInfoSearch.setSearchType(SearchTypeEnum.TOP);
		pcsInfoSearch.setTop(1);
		pcsInfoSearch.setOrderBy("insert_date desc");
		List<PcsInfo> pcsList = pcsService.searchPcs(pcsInfoSearch);
		if (pcsList!=null&&pcsList.size()!=0) {
			PcsInfo pcsInfo = pcsList.get(0);
			json.put("charge", pcsInfo.getPcsCharge());
			json.put("discharge", pcsInfo.getPcsDischarge());
		}		
		return json;
	}
	
	@ApiOperation(value="获取节能减排的细心", notes="一些资源的信息")
	@RequestMapping(value = "/eCAERMessager", method = RequestMethod.GET)
	public JSONObject getEnergyConservationAndEmssionReduction() {
		JSONObject json = new JSONObject();
		json.put("crudeOil", crudeOil);
		json.put("gasoline", gasoline);
		json.put("carbonDioxide", carbonDioxide);
		json.put("trees", trees);
		return json;
	}
	
	//============数据统计数据接口结束==================
}
