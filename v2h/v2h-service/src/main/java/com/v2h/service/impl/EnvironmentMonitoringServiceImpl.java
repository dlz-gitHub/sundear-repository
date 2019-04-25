package com.v2h.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.v2h.service.EnvironmentMonitoringService;
import com.v2h.core.dao.EnvironmentMonitoringDao;
import com.v2h.core.model.EnvironmentMonitoringInfo;
import com.v2h.core.search.EnvironmentMonitoringInfoSearch;
import com.sundear.base.enumeration.SearchEnum.SearchTypeEnum;

@Service("EnvironmentMonitoringService")
public class EnvironmentMonitoringServiceImpl implements EnvironmentMonitoringService {
	@Autowired
	private  EnvironmentMonitoringDao environmentMonitoringDao;
	
	public void insertEnvironmentMonitoring(EnvironmentMonitoringInfo environmentMonitoringInfo){
		environmentMonitoringDao.insertEnvironmentMonitoring(environmentMonitoringInfo);
	}
	public void updateEnvironmentMonitoring(EnvironmentMonitoringInfo environmentMonitoringInfo) {
		environmentMonitoringDao.updateEnvironmentMonitoring(environmentMonitoringInfo);
	}
	public EnvironmentMonitoringInfo getEnvironmentMonitoring(String EmID) {
		return environmentMonitoringDao.getEnvironmentMonitoring(EmID);
	}
	public void deleteEnvironmentMonitoring(String EmID) {
		environmentMonitoringDao.deleteEnvironmentMonitoring(EmID);
	}
	public List<EnvironmentMonitoringInfo> searchEnvironmentMonitoring(EnvironmentMonitoringInfoSearch environmentMonitoringInfoSearch){
		if(environmentMonitoringInfoSearch.getSearchType()==SearchTypeEnum.PAGES){
			environmentMonitoringInfoSearch.setTotalCount(environmentMonitoringDao.searchEnvironmentMonitoringCount(environmentMonitoringInfoSearch));
		}
		return environmentMonitoringDao.searchEnvironmentMonitoring(environmentMonitoringInfoSearch);
	}
}