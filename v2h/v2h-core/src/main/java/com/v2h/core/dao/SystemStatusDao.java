package com.v2h.core.dao;

import java.util.List;

import com.v2h.core.model.SystemStatusInfo;
import com.v2h.core.search.SystemStatusInfoSearch;

public interface SystemStatusDao {
	
	void insertSystemStatus(SystemStatusInfo systemStatusInfo);
	void updateSystemStatus(SystemStatusInfo systemStatusInfo);
	SystemStatusInfo getSystemStatus(String SsID);
	void deleteSystemStatus(String SsID);
	List<SystemStatusInfo> searchSystemStatus(SystemStatusInfoSearch systemStatusInfoSearch);
	int searchSystemStatusCount(SystemStatusInfoSearch systemStatusInfoSearch);
}
