package com.v2h.core.dao;
import java.util.List;

import com.v2h.core.model.PcsInfo;
import com.v2h.core.search.PcsInfoSearch;

public interface PcsDao {
	
	void insertPcs(PcsInfo pcsInfo);
	void updatePcs(PcsInfo pcsInfo);
	PcsInfo getPcs(String PcsID);
	void deletePcs(String PcsID);
	List<PcsInfo> searchPcs(PcsInfoSearch pcsInfoSearch);
	int searchPcsCount(PcsInfoSearch pcsInfoSearch);
}