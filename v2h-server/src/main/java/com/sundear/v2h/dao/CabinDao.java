package com.sundear.v2h.dao;

import java.util.List;

import com.sundear.v2h.model.CabinInfo;
import com.sundear.v2h.search.CabinInfoSearch;

public interface CabinDao {
	
	void insertCabin(CabinInfo cabinInfo);
	void updateCabin(CabinInfo cabinInfo);
	CabinInfo getCabin(String CabinID);
	void deleteCabin(String CabinID);
	List<CabinInfo> searchCabin(CabinInfoSearch cabinInfoSearch);
	int searchCabinCount(CabinInfoSearch cabinInfoSearch);
}
