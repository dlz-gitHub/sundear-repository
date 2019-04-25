package com.v2h.core.dao;

import java.util.List;

import com.v2h.core.model.CabinInfo;
import com.v2h.core.search.CabinInfoSearch;

public interface CabinDao {
	
	void insertCabin(CabinInfo cabinInfo);
	void updateCabin(CabinInfo cabinInfo);
	CabinInfo getCabin(String CabinID);
	void deleteCabin(String CabinID);
	List<CabinInfo> searchCabin(CabinInfoSearch cabinInfoSearch);
	int searchCabinCount(CabinInfoSearch cabinInfoSearch);
}