package com.sundear.v2h.dao.impl;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sundear.v2h.dao.BmsDao;
import com.sundear.v2h.mapper.BmsMapper;
import com.sundear.v2h.model.BmsInfo;
import com.sundear.v2h.search.BmsInfoSearch;

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