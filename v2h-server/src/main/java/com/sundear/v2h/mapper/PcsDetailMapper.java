package com.sundear.v2h.mapper;

import java.util.List;

import com.sundear.v2h.model.PcsDetailInfo;
import com.sundear.v2h.search.PcsDetailInfoSearch;

public interface PcsDetailMapper {
	void insertPcsDetail(PcsDetailInfo pcsDetailInfo);
	void updatePcsDetail(PcsDetailInfo pcsDetailInfo);
	PcsDetailInfo getPcsDetail(String PcsDetailID);
	void deletePcsDetail(String PcsDetailID);
	List<PcsDetailInfo> searchPcsDetail(PcsDetailInfoSearch pcsDetailInfoSearch);
	int searchPcsDetailCount(PcsDetailInfoSearch pcsDetailInfoSearch);
}