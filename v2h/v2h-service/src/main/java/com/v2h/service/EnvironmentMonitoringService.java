package com.v2h.service;

import java.util.List;

import com.v2h.core.model.EnvironmentMonitoringInfo;
import com.v2h.core.search.EnvironmentMonitoringInfoSearch;

public interface EnvironmentMonitoringService {
	void insertEnvironmentMonitoring(EnvironmentMonitoringInfo environmentMonitoringInfo);
	void updateEnvironmentMonitoring(EnvironmentMonitoringInfo environmentMonitoringInfo);
	EnvironmentMonitoringInfo getEnvironmentMonitoring(String EmID);
	void deleteEnvironmentMonitoring(String EmID);
	List<EnvironmentMonitoringInfo> searchEnvironmentMonitoring(EnvironmentMonitoringInfoSearch environmentMonitoringInfoSearch);
}