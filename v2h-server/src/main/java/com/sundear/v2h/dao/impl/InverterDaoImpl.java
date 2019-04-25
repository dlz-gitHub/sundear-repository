package com.sundear.v2h.dao.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sundear.v2h.dao.InverterDao;
import com.sundear.v2h.mapper.InverterMapper;
import com.sundear.v2h.model.InverterInfo;
import com.sundear.v2h.search.InverterInfoSearch;

@Repository
public class InverterDaoImpl implements InverterDao {

	@Autowired
	private InverterMapper inverterMapper;
	public void insertInverter(InverterInfo inverterInfo) {
				inverterInfo.setInverterID(UUID.randomUUID().toString().replaceAll("-", ""));
				inverterMapper.insertInverter(inverterInfo);
	}
	public void updateInverter(InverterInfo inverterInfo) {
		inverterMapper.updateInverter(inverterInfo);
	}
	public InverterInfo getInverter(String InverterID) {
		return inverterMapper.getInverter(InverterID);
	}
	public void deleteInverter(String InverterID) {
		inverterMapper.deleteInverter(InverterID);
	}
	public List<InverterInfo> searchInverter(InverterInfoSearch inverterInfoSearch){
		return inverterMapper.searchInverter(inverterInfoSearch);
	}
	public int searchInverterCount(InverterInfoSearch inverterInfoSearch){
		return inverterMapper.searchInverterCount(inverterInfoSearch);
	}
}