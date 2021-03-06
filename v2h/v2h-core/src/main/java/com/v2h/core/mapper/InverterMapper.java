package com.v2h.core.mapper;

import java.util.List;
import com.v2h.core.model.InverterInfo;
import com.v2h.core.search.InverterInfoSearch;

public interface InverterMapper {
	void insertInverter(InverterInfo inverterInfo);
	void updateInverter(InverterInfo inverterInfo);
	InverterInfo getInverter(String InverterID);
	void deleteInverter(String InverterID);
	List<InverterInfo> searchInverter(InverterInfoSearch inverterInfoSearch);
	int searchInverterCount(InverterInfoSearch inverterInfoSearch);
}
