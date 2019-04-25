package com.v2h.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.v2h.service.SystemStatusService;
import com.v2h.core.dao.SystemStatusDao;
import com.v2h.core.model.SystemStatusInfo;
import com.v2h.core.search.SystemStatusInfoSearch;
import com.sundear.base.enumeration.SearchEnum.SearchTypeEnum;

@Service("SystemStatusService")
public class SystemStatusServiceImpl implements SystemStatusService {
	@Autowired
	private  SystemStatusDao systemStatusDao;
	
	public void insertSystemStatus(SystemStatusInfo systemStatusInfo){
		systemStatusDao.insertSystemStatus(systemStatusInfo);
	}
	public void updateSystemStatus(SystemStatusInfo systemStatusInfo) {
		systemStatusDao.updateSystemStatus(systemStatusInfo);
	}
	public SystemStatusInfo getSystemStatus(String SsID) {
		return systemStatusDao.getSystemStatus(SsID);
	}
	public void deleteSystemStatus(String SsID) {
		systemStatusDao.deleteSystemStatus(SsID);
	}
	public List<SystemStatusInfo> searchSystemStatus(SystemStatusInfoSearch systemStatusInfoSearch){
		if(systemStatusInfoSearch.getSearchType()==SearchTypeEnum.PAGES){
			systemStatusInfoSearch.setTotalCount(systemStatusDao.searchSystemStatusCount(systemStatusInfoSearch));
		}
		return systemStatusDao.searchSystemStatus(systemStatusInfoSearch);
	}
}