package com.sundear.v2h.mapper;
import java.util.List;

import com.sundear.v2h.model.PcsInfo;
import com.sundear.v2h.search.PcsInfoSearch;

public interface PcsMapper {
	void insertPcs(PcsInfo pcsInfo);
	void updatePcs(PcsInfo pcsInfo);
	PcsInfo getPcs(String PcsID);
	void deletePcs(String PcsID);
	List<PcsInfo> searchPcs(PcsInfoSearch pcsInfoSearch);
	int searchPcsCount(PcsInfoSearch pcsInfoSearch);
}