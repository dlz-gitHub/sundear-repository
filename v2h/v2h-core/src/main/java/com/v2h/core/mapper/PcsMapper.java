
package com.v2h.core.mapper;

import java.util.List;
import com.v2h.core.model.PcsInfo;
import com.v2h.core.search.PcsInfoSearch;

public interface PcsMapper {
	void insertPcs(PcsInfo pcsInfo);
	void updatePcs(PcsInfo pcsInfo);
	PcsInfo getPcs(String PcsID);
	void deletePcs(String PcsID);
	List<PcsInfo> searchPcs(PcsInfoSearch pcsInfoSearch);
	int searchPcsCount(PcsInfoSearch pcsInfoSearch);
}
