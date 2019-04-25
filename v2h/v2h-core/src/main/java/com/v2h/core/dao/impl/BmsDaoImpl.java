package com.v2h.core.dao.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.v2h.core.dao.BmsDao;
import com.v2h.core.mapper.BmsMapper;
import com.v2h.core.model.BmsInfo;
import com.v2h.core.search.BmsInfoSearch;

@Repository
public class BmsDaoImpl implements BmsDao {

	@Autowired
	private BmsMapper bmsMapper;
	public void insertBms(BmsInfo bmsInfo) {
				bmsInfo.setBmsID(UUID.randomUUID().toString().replaceAll("-", ""));
				bmsMapper.insertBms(bmsInfo);
	}
	public void updateBms(BmsInfo bmsInfo) {
		bmsMapper.updateBms(bmsInfo);
	}
	public BmsInfo getBms(String BmsID) {
		return bmsMapper.getBms(BmsID);
	}
	public void deleteBms(String BmsID) {
		bmsMapper.deleteBms(BmsID);
	}
	public List<BmsInfo> searchBms(BmsInfoSearch bmsInfoSearch){
		return bmsMapper.searchBms(bmsInfoSearch);
	}
	public int searchBmsCount(BmsInfoSearch bmsInfoSearch){
		return bmsMapper.searchBmsCount(bmsInfoSearch);
	}
}
