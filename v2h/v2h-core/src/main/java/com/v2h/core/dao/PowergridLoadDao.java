package com.v2h.core.dao;

import java.util.List;

import com.v2h.core.model.PowergridLoadInfo;
import com.v2h.core.search.PowergridLoadInfoSearch;

public interface PowergridLoadDao {
	
	void insertPowergridLoad(PowergridLoadInfo powergridLoadInfo);
	void updatePowergridLoad(PowergridLoadInfo powergridLoadInfo);
	PowergridLoadInfo getPowergridLoad(String PglID);
	void deletePowergridLoad(String PglID);
	List<PowergridLoadInfo> searchPowergridLoad(PowergridLoadInfoSearch powergridLoadInfoSearch);
	int searchPowergridLoadCount(PowergridLoadInfoSearch powergridLoadInfoSearch);
}
