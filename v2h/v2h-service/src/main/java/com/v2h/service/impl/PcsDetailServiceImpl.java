package com.v2h.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.v2h.service.PcsDetailService;
import com.v2h.core.dao.PcsDetailDao;
import com.v2h.core.model.PcsDetailInfo;
import com.v2h.core.search.PcsDetailInfoSearch;
import com.sundear.base.enumeration.SearchEnum.SearchTypeEnum;

@Service("PcsDetailService")
public class PcsDetailServiceImpl implements PcsDetailService {
	@Autowired
	private  PcsDetailDao pcsDetailDao;
	
	public void insertPcsDetail(PcsDetailInfo pcsDetailInfo){
		pcsDetailDao.insertPcsDetail(pcsDetailInfo);
	}
	public void updatePcsDetail(PcsDetailInfo pcsDetailInfo) {
		pcsDetailDao.updatePcsDetail(pcsDetailInfo);
	}
	public PcsDetailInfo getPcsDetail(String PcsDetailID) {
		return pcsDetailDao.getPcsDetail(PcsDetailID);
	}
	public void deletePcsDetail(String PcsDetailID) {
		pcsDetailDao.deletePcsDetail(PcsDetailID);
	}
	public List<PcsDetailInfo> searchPcsDetail(PcsDetailInfoSearch pcsDetailInfoSearch){
		if(pcsDetailInfoSearch.getSearchType()==SearchTypeEnum.PAGES){
			pcsDetailInfoSearch.setTotalCount(pcsDetailDao.searchPcsDetailCount(pcsDetailInfoSearch));
		}
		return pcsDetailDao.searchPcsDetail(pcsDetailInfoSearch);
	}
}