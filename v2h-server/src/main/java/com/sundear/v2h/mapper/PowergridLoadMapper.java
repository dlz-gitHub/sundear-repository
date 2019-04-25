package com.sundear.v2h.mapper;
import java.util.List;

import com.sundear.v2h.model.PowergridLoadInfo;
import com.sundear.v2h.search.PowergridLoadInfoSearch;

public interface PowergridLoadMapper {
	void insertPowergridLoad(PowergridLoadInfo powergridLoadInfo);
	void updatePowergridLoad(PowergridLoadInfo powergridLoadInfo);
	PowergridLoadInfo getPowergridLoad(String PglID);
	void deletePowergridLoad(String PglID);
	List<PowergridLoadInfo> searchPowergridLoad(PowergridLoadInfoSearch powergridLoadInfoSearch);
	int searchPowergridLoadCount(PowergridLoadInfoSearch powergridLoadInfoSearch);
}
