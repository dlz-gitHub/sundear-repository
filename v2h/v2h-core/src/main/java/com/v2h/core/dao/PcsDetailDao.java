package com.v2h.core.dao;

import java.util.List;

import com.v2h.core.model.PcsDetailInfo;
import com.v2h.core.search.PcsDetailInfoSearch;

public interface PcsDetailDao {
	
	void insertPcsDetail(PcsDetailInfo pcsDetailInfo);
	void updatePcsDetail(PcsDetailInfo pcsDetailInfo);
	PcsDetailInfo getPcsDetail(String PcsDetailID);
	void deletePcsDetail(String PcsDetailID);
	List<PcsDetailInfo> searchPcsDetail(PcsDetailInfoSearch pcsDetailInfoSearch);
	int searchPcsDetailCount(PcsDetailInfoSearch pcsDetailInfoSearch);
}
