
package com.v2h.service;

import java.util.List;

import com.v2h.core.model.InverterInfo;
import com.v2h.core.search.InverterInfoSearch;

public interface InverterService {
	void insertInverter(InverterInfo inverterInfo);
	void updateInverter(InverterInfo inverterInfo);
	InverterInfo getInverter(String InverterID);
	void deleteInverter(String InverterID);
	List<InverterInfo> searchInverter(InverterInfoSearch inverterInfoSearch);
}
