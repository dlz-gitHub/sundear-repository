package com.sundear.v2h.dao.impl;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sundear.v2h.dao.PowergridLoadDao;
import com.sundear.v2h.mapper.PowergridLoadMapper;
import com.sundear.v2h.model.PowergridLoadInfo;
import com.sundear.v2h.search.PowergridLoadInfoSearch;

@Repository
public class PowergridLoadDaoImpl implements PowergridLoadDao {

	@Autowired
	private PowergridLoadMapper powergridLoadMapper;
	public void insertPowergridLoad(PowergridLoadInfo powergridLoadInfo) {
				powergridLoadInfo.setPglID(UUID.randomUUID().toString().replaceAll("-", ""));
				powergridLoadMapper.insertPowergridLoad(powergridLoadInfo);
	}
	public void updatePowergridLoad(PowergridLoadInfo powergridLoadInfo) {
		powergridLoadMapper.updatePowergridLoad(powergridLoadInfo);
	}
	public PowergridLoadInfo getPowergridLoad(String PglID) {
		return powergridLoadMapper.getPowergridLoad(PglID);
	}
	public void deletePowergridLoad(String PglID) {
		powergridLoadMapper.deletePowergridLoad(PglID);
	}
	public List<PowergridLoadInfo> searchPowergridLoad(PowergridLoadInfoSearch powergridLoadInfoSearch){
		return powergridLoadMapper.searchPowergridLoad(powergridLoadInfoSearch);
	}
	public int searchPowergridLoadCount(PowergridLoadInfoSearch powergridLoadInfoSearch){
		return powergridLoadMapper.searchPowergridLoadCount(powergridLoadInfoSearch);
	}
}