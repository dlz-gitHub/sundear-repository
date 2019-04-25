package com.sundear.v2h.dao;

import java.util.List;

import com.sundear.v2h.model.BmsInfo;
import com.sundear.v2h.search.BmsInfoSearch;

public interface BmsDao {
	
	void insertBms(BmsInfo bmsInfo);
	void updateBms(BmsInfo bmsInfo);
	BmsInfo getBms(String BmsID);
	void deleteBms(String BmsID);
	List<BmsInfo> searchBms(BmsInfoSearch bmsInfoSearch);
	int searchBmsCount(BmsInfoSearch bmsInfoSearch);
}
