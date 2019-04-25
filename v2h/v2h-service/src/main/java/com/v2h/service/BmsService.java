package com.v2h.service;

import java.util.List;

import com.v2h.core.model.BmsInfo;
import com.v2h.core.search.BmsInfoSearch;

public interface BmsService {
	void insertBms(BmsInfo bmsInfo);
	void updateBms(BmsInfo bmsInfo);
	BmsInfo getBms(String BmsID);
	void deleteBms(String BmsID);
	List<BmsInfo> searchBms(BmsInfoSearch bmsInfoSearch);
}