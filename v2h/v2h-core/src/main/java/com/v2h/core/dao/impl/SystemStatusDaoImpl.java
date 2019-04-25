package com.v2h.core.dao.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.v2h.core.dao.SystemStatusDao;
import com.v2h.core.mapper.SystemStatusMapper;
import com.v2h.core.model.SystemStatusInfo;
import com.v2h.core.search.SystemStatusInfoSearch;

@Repository
public class SystemStatusDaoImpl implements SystemStatusDao {

	@Autowired
	private SystemStatusMapper systemStatusMapper;
	public void insertSystemStatus(SystemStatusInfo systemStatusInfo) {
				systemStatusInfo.setSsID(UUID.randomUUID().toString().replaceAll("-", ""));
				systemStatusMapper.insertSystemStatus(systemStatusInfo);
	}
	public void updateSystemStatus(SystemStatusInfo systemStatusInfo) {
		systemStatusMapper.updateSystemStatus(systemStatusInfo);
	}
	public SystemStatusInfo getSystemStatus(String SsID) {
		return systemStatusMapper.getSystemStatus(SsID);
	}
	public void deleteSystemStatus(String SsID) {
		systemStatusMapper.deleteSystemStatus(SsID);
	}
	public List<SystemStatusInfo> searchSystemStatus(SystemStatusInfoSearch systemStatusInfoSearch){
		return systemStatusMapper.searchSystemStatus(systemStatusInfoSearch);
	}
	public int searchSystemStatusCount(SystemStatusInfoSearch systemStatusInfoSearch){
		return systemStatusMapper.searchSystemStatusCount(systemStatusInfoSearch);
	}
}
