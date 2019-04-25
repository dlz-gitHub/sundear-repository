package com.v2h.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.v2h.service.PcsService;
import com.v2h.core.dao.PcsDao;
import com.v2h.core.model.PcsInfo;
import com.v2h.core.search.PcsInfoSearch;
import com.sundear.base.enumeration.SearchEnum.SearchTypeEnum;

@Service("PcsService")
public class PcsServiceImpl implements PcsService {
	@Autowired
	private  PcsDao pcsDao;
	
	public void insertPcs(PcsInfo pcsInfo){
		pcsDao.insertPcs(pcsInfo);
	}
	public void updatePcs(PcsInfo pcsInfo) {
		pcsDao.updatePcs(pcsInfo);
	}
	public PcsInfo getPcs(String PcsID) {
		return pcsDao.getPcs(PcsID);
	}
	public void deletePcs(String PcsID) {
		pcsDao.deletePcs(PcsID);
	}
	public List<PcsInfo> searchPcs(PcsInfoSearch pcsInfoSearch){
		if(pcsInfoSearch.getSearchType()==SearchTypeEnum.PAGES){
			pcsInfoSearch.setTotalCount(pcsDao.searchPcsCount(pcsInfoSearch));
		}
		return pcsDao.searchPcs(pcsInfoSearch);
	}
}