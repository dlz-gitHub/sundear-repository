package com.v2h.core.mapper;

import java.util.List;
import com.v2h.core.model.EnvironmentMonitoringInfo;
import com.v2h.core.search.EnvironmentMonitoringInfoSearch;

public interface EnvironmentMonitoringMapper {
	void insertEnvironmentMonitoring(EnvironmentMonitoringInfo environmentMonitoringInfo);
	void updateEnvironmentMonitoring(EnvironmentMonitoringInfo environmentMonitoringInfo);
	EnvironmentMonitoringInfo getEnvironmentMonitoring(String EmID);
	void deleteEnvironmentMonitoring(String EmID);
	List<EnvironmentMonitoringInfo> searchEnvironmentMonitoring(EnvironmentMonitoringInfoSearch environmentMonitoringInfoSearch);
	int searchEnvironmentMonitoringCount(EnvironmentMonitoringInfoSearch environmentMonitoringInfoSearch);
}