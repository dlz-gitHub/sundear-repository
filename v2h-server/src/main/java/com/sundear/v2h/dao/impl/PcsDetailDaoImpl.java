package com.sundear.v2h.dao.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sundear.v2h.dao.PcsDetailDao;
import com.sundear.v2h.mapper.PcsDetailMapper;
import com.sundear.v2h.model.PcsDetailInfo;
import com.sundear.v2h.search.PcsDetailInfoSearch;

@Repository
public class PcsDetailDaoImpl implements PcsDetailDao {

	@Autowired
	private PcsDetailMapper pcsDetailMapper;
	public void insertPcsDetail(PcsDetailInfo pcsDetailInfo) {
				pcsDetailInfo.setPcsDetailID(UUID.randomUUID().toString().replaceAll("-", ""));
				pcsDetailMapper.insertPcsDetail(pcsDetailInfo);
	}
	public void updatePcsDetail(PcsDetailInfo pcsDetailInfo) {
		pcsDetailMapper.updatePcsDetail(pcsDetailInfo);
	}
	public PcsDetailInfo getPcsDetail(String PcsDetailID) {
		return pcsDetailMapper.getPcsDetail(PcsDetailID);
	}
	public void deletePcsDetail(String PcsDetailID) {
		pcsDetailMapper.deletePcsDetail(PcsDetailID);
	}
	public List<PcsDetailInfo> searchPcsDetail(PcsDetailInfoSearch pcsDetailInfoSearch){
		return pcsDetailMapper.searchPcsDetail(pcsDetailInfoSearch);
	}
	public int searchPcsDetailCount(PcsDetailInfoSearch pcsDetailInfoSearch){
		return pcsDetailMapper.searchPcsDetailCount(pcsDetailInfoSearch);
	}
}