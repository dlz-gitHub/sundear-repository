package com.sundear.v2h.dao.impl;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sundear.v2h.dao.CabinDao;
import com.sundear.v2h.mapper.CabinMapper;
import com.sundear.v2h.model.CabinInfo;
import com.sundear.v2h.search.CabinInfoSearch;

@Repository
public class CabinDaoImpl implements CabinDao {

	@Autowired
	private CabinMapper cabinMapper;
	public void insertCabin(CabinInfo cabinInfo) {
				cabinInfo.setCabinID(UUID.randomUUID().toString().replaceAll("-", ""));
				cabinMapper.insertCabin(cabinInfo);
	}
	public void updateCabin(CabinInfo cabinInfo) {
		cabinMapper.updateCabin(cabinInfo);
	}
	public CabinInfo getCabin(String CabinID) {
		return cabinMapper.getCabin(CabinID);
	}
	public void deleteCabin(String CabinID) {
		cabinMapper.deleteCabin(CabinID);
	}
	public List<CabinInfo> searchCabin(CabinInfoSearch cabinInfoSearch){
		return cabinMapper.searchCabin(cabinInfoSearch);
	}
	public int searchCabinCount(CabinInfoSearch cabinInfoSearch){
		return cabinMapper.searchCabinCount(cabinInfoSearch);
	}
}
