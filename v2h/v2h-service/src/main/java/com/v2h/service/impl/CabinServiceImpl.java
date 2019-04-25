package com.v2h.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.v2h.service.CabinService;
import com.v2h.core.dao.CabinDao;
import com.v2h.core.model.CabinInfo;
import com.v2h.core.search.CabinInfoSearch;
import com.sundear.base.enumeration.SearchEnum.SearchTypeEnum;

@Service("CabinService")
public class CabinServiceImpl implements CabinService {
	@Autowired
	private  CabinDao cabinDao;
	
	public void insertCabin(CabinInfo cabinInfo){
		cabinDao.insertCabin(cabinInfo);
	}
	public void updateCabin(CabinInfo cabinInfo) {
		cabinDao.updateCabin(cabinInfo);
	}
	public CabinInfo getCabin(String CabinID) {
		return cabinDao.getCabin(CabinID);
	}
	public void deleteCabin(String CabinID) {
		cabinDao.deleteCabin(CabinID);
	}
	public List<CabinInfo> searchCabin(CabinInfoSearch cabinInfoSearch){
		if(cabinInfoSearch.getSearchType()==SearchTypeEnum.PAGES){
			cabinInfoSearch.setTotalCount(cabinDao.searchCabinCount(cabinInfoSearch));
		}
		return cabinDao.searchCabin(cabinInfoSearch);
	}
}