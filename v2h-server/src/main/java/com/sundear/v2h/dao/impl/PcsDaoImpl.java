package com.sundear.v2h.dao.impl;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sundear.v2h.dao.PcsDao;
import com.sundear.v2h.mapper.PcsMapper;
import com.sundear.v2h.model.PcsInfo;
import com.sundear.v2h.search.PcsInfoSearch;

@Repository
public class PcsDaoImpl implements PcsDao {

	@Autowired
	private PcsMapper pcsMapper;
	public void insertPcs(PcsInfo pcsInfo) {
				pcsInfo.setPcsID(UUID.randomUUID().toString().replaceAll("-", ""));
				pcsMapper.insertPcs(pcsInfo);
	}
	public void updatePcs(PcsInfo pcsInfo) {
		pcsMapper.updatePcs(pcsInfo);
	}
	public PcsInfo getPcs(String PcsID) {
		return pcsMapper.getPcs(PcsID);
	}
	public void deletePcs(String PcsID) {
		pcsMapper.deletePcs(PcsID);
	}
	public List<PcsInfo> searchPcs(PcsInfoSearch pcsInfoSearch){
		return pcsMapper.searchPcs(pcsInfoSearch);
	}
	public int searchPcsCount(PcsInfoSearch pcsInfoSearch){
		return pcsMapper.searchPcsCount(pcsInfoSearch);
	}
}