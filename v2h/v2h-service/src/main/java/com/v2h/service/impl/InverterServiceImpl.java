package com.v2h.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.v2h.service.InverterService;
import com.v2h.core.dao.InverterDao;
import com.v2h.core.model.InverterInfo;
import com.v2h.core.search.InverterInfoSearch;
import com.sundear.base.enumeration.SearchEnum.SearchTypeEnum;

@Service("InverterService")
public class InverterServiceImpl implements InverterService {
	@Autowired
	private  InverterDao inverterDao;
	
	public void insertInverter(InverterInfo inverterInfo){
		inverterDao.insertInverter(inverterInfo);
	}
	public void updateInverter(InverterInfo inverterInfo) {
		inverterDao.updateInverter(inverterInfo);
	}
	public InverterInfo getInverter(String InverterID) {
		return inverterDao.getInverter(InverterID);
	}
	public void deleteInverter(String InverterID) {
		inverterDao.deleteInverter(InverterID);
	}
	public List<InverterInfo> searchInverter(InverterInfoSearch inverterInfoSearch){
		if(inverterInfoSearch.getSearchType()==SearchTypeEnum.PAGES){
			inverterInfoSearch.setTotalCount(inverterDao.searchInverterCount(inverterInfoSearch));
		}
		return inverterDao.searchInverter(inverterInfoSearch);
	}
}