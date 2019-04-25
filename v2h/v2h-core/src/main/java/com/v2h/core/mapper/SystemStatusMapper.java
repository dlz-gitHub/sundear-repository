package com.v2h.core.mapper;

import java.util.List;
import com.v2h.core.model.SystemStatusInfo;
import com.v2h.core.search.SystemStatusInfoSearch;

public interface SystemStatusMapper {
	void insertSystemStatus(SystemStatusInfo systemStatusInfo);
	void updateSystemStatus(SystemStatusInfo systemStatusInfo);
	SystemStatusInfo getSystemStatus(String SsID);
	void deleteSystemStatus(String SsID);
	List<SystemStatusInfo> searchSystemStatus(SystemStatusInfoSearch systemStatusInfoSearch);
	int searchSystemStatusCount(SystemStatusInfoSearch systemStatusInfoSearch);
}
