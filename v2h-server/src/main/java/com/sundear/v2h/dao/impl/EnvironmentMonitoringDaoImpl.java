package com.sundear.v2h.dao.impl;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sundear.v2h.dao.EnvironmentMonitoringDao;
import com.sundear.v2h.mapper.EnvironmentMonitoringMapper;
import com.sundear.v2h.model.EnvironmentMonitoringInfo;
import com.sundear.v2h.search.EnvironmentMonitoringInfoSearch;

@Repository
public class EnvironmentMonitoringDaoImpl implements EnvironmentMonitoringDao {

	@Autowired
	private EnvironmentMonitoringMapper environmentMonitoringMapper;
	public void insertEnvironmentMonitoring(EnvironmentMonitoringInfo environmentMonitoringInfo) {
				environmentMonitoringInfo.setEmID(UUID.randomUUID().toString().replaceAll("-", ""));
				environmentMonitoringMapper.insertEnvironmentMonitoring(environmentMonitoringInfo);
	}
	public void updateEnvironmentMonitoring(EnvironmentMonitoringInfo environmentMonitoringInfo) {
		environmentMonitoringMapper.updateEnvironmentMonitoring(environmentMonitoringInfo);
	}
	public EnvironmentMonitoringInfo getEnvironmentMonitoring(String EmID) {
		return environmentMonitoringMapper.getEnvironmentMonitoring(EmID);
	}
	public void deleteEnvironmentMonitoring(String EmID) {
		environmentMonitoringMapper.deleteEnvironmentMonitoring(EmID);
	}
	public List<EnvironmentMonitoringInfo> searchEnvironmentMonitoring(EnvironmentMonitoringInfoSearch environmentMonitoringInfoSearch){
		return environmentMonitoringMapper.searchEnvironmentMonitoring(environmentMonitoringInfoSearch);
	}
	public int searchEnvironmentMonitoringCount(EnvironmentMonitoringInfoSearch environmentMonitoringInfoSearch){
		return environmentMonitoringMapper.searchEnvironmentMonitoringCount(environmentMonitoringInfoSearch);
	}
}