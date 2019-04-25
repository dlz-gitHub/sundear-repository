package com.v2h.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.v2h.service.PowergridLoadService;
import com.v2h.core.dao.PowergridLoadDao;
import com.v2h.core.model.PowergridLoadInfo;
import com.v2h.core.search.PowergridLoadInfoSearch;
import com.sundear.base.enumeration.SearchEnum.SearchTypeEnum;

@Service("PowergridLoadService")
public class PowergridLoadServiceImpl implements PowergridLoadService {
	@Autowired
	private  PowergridLoadDao powergridLoadDao;
	
	public void insertPowergridLoad(PowergridLoadInfo powergridLoadInfo){
		powergridLoadDao.insertPowergridLoad(powergridLoadInfo);
	}
	public void updatePowergridLoad(PowergridLoadInfo powergridLoadInfo) {
		powergridLoadDao.updatePowergridLoad(powergridLoadInfo);
	}
	public PowergridLoadInfo getPowergridLoad(String PglID) {
		return powergridLoadDao.getPowergridLoad(PglID);
	}
	public void deletePowergridLoad(String PglID) {
		powergridLoadDao.deletePowergridLoad(PglID);
	}
	public List<PowergridLoadInfo> searchPowergridLoad(PowergridLoadInfoSearch powergridLoadInfoSearch){
		if(powergridLoadInfoSearch.getSearchType()==SearchTypeEnum.PAGES){
			powergridLoadInfoSearch.setTotalCount(powergridLoadDao.searchPowergridLoadCount(powergridLoadInfoSearch));
		}
		return powergridLoadDao.searchPowergridLoad(powergridLoadInfoSearch);
	}
}