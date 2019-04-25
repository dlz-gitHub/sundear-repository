package com.sundear.v2h.dao;
import java.util.List;

import com.sundear.v2h.model.SystemStatusInfo;
import com.sundear.v2h.search.SystemStatusInfoSearch;

public interface SystemStatusDao {
	
	void insertSystemStatus(SystemStatusInfo systemStatusInfo);
	void updateSystemStatus(SystemStatusInfo systemStatusInfo);
	SystemStatusInfo getSystemStatus(String SsID);
	void deleteSystemStatus(String SsID);
	List<SystemStatusInfo> searchSystemStatus(SystemStatusInfoSearch systemStatusInfoSearch);
	int searchSystemStatusCount(SystemStatusInfoSearch systemStatusInfoSearch);
}