package com.v2h.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.v2h.service.BmsService;
import com.v2h.core.dao.BmsDao;
import com.v2h.core.model.BmsInfo;
import com.v2h.core.search.BmsInfoSearch;
import com.sundear.base.enumeration.SearchEnum.SearchTypeEnum;

@Service("BmsService")
public class BmsServiceImpl implements BmsService {
	@Autowired
	private  BmsDao bmsDao;
	
	public void insertBms(BmsInfo bmsInfo){
		bmsDao.insertBms(bmsInfo);
	}
	public void updateBms(BmsInfo bmsInfo) {
		bmsDao.updateBms(bmsInfo);
	}
	public BmsInfo getBms(String BmsID) {
		return bmsDao.getBms(BmsID);
	}
	public void deleteBms(String BmsID) {
		bmsDao.deleteBms(BmsID);
	}
	public List<BmsInfo> searchBms(BmsInfoSearch bmsInfoSearch){
		if(bmsInfoSearch.getSearchType()==SearchTypeEnum.PAGES){
			bmsInfoSearch.setTotalCount(bmsDao.searchBmsCount(bmsInfoSearch));
		}
		return bmsDao.searchBms(bmsInfoSearch);
	}
}