package com.sundear.v2h.dao;

import java.util.List;

import com.sundear.v2h.model.InverterInfo;
import com.sundear.v2h.search.InverterInfoSearch;

public interface InverterDao {
	
	void insertInverter(InverterInfo inverterInfo);
	void updateInverter(InverterInfo inverterInfo);
	InverterInfo getInverter(String InverterID);
	void deleteInverter(String InverterID);
	List<InverterInfo> searchInverter(InverterInfoSearch inverterInfoSearch);
	int searchInverterCount(InverterInfoSearch inverterInfoSearch);
}