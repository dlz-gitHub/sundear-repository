package com.sundear.v2h.mapper;
import java.util.List;

import com.sundear.v2h.model.EnvironmentMonitoringInfo;
import com.sundear.v2h.search.EnvironmentMonitoringInfoSearch;

public interface EnvironmentMonitoringMapper {
	void insertEnvironmentMonitoring(EnvironmentMonitoringInfo environmentMonitoringInfo);
	void updateEnvironmentMonitoring(EnvironmentMonitoringInfo environmentMonitoringInfo);
	EnvironmentMonitoringInfo getEnvironmentMonitoring(String EmID);
	void deleteEnvironmentMonitoring(String EmID);
	List<EnvironmentMonitoringInfo> searchEnvironmentMonitoring(EnvironmentMonitoringInfoSearch environmentMonitoringInfoSearch);
	int searchEnvironmentMonitoringCount(EnvironmentMonitoringInfoSearch environmentMonitoringInfoSearch);
}