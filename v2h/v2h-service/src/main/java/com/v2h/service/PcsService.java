
package com.v2h.service;

import java.util.List;

import com.v2h.core.model.PcsInfo;
import com.v2h.core.search.PcsInfoSearch;

public interface PcsService {
	void insertPcs(PcsInfo pcsInfo);
	void updatePcs(PcsInfo pcsInfo);
	PcsInfo getPcs(String PcsID);
	void deletePcs(String PcsID);
	List<PcsInfo> searchPcs(PcsInfoSearch pcsInfoSearch);
}