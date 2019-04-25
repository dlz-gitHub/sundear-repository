package com.sundear.v2h.mapper;

import java.util.List;

import com.sundear.v2h.model.CabinInfo;
import com.sundear.v2h.search.CabinInfoSearch;

public interface CabinMapper {
	void insertCabin(CabinInfo cabinInfo);
	void updateCabin(CabinInfo cabinInfo);
	CabinInfo getCabin(String CabinID);
	void deleteCabin(String CabinID);
	List<CabinInfo> searchCabin(CabinInfoSearch cabinInfoSearch);
	int searchCabinCount(CabinInfoSearch cabinInfoSearch);
}
