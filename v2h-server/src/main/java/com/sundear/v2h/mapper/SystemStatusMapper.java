package com.sundear.v2h.mapper;
import java.util.List;

import com.sundear.v2h.model.SystemStatusInfo;
import com.sundear.v2h.search.SystemStatusInfoSearch;

public interface SystemStatusMapper {
	void insertSystemStatus(SystemStatusInfo systemStatusInfo);
	void updateSystemStatus(SystemStatusInfo systemStatusInfo);
	SystemStatusInfo getSystemStatus(String SsID);
	void deleteSystemStatus(String SsID);
	List<SystemStatusInfo> searchSystemStatus(SystemStatusInfoSearch systemStatusInfoSearch);
	int searchSystemStatusCount(SystemStatusInfoSearch systemStatusInfoSearch);
}