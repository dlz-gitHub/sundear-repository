
package com.v2h.service;

import java.util.List;

import com.v2h.core.model.CarportInfo;
import com.v2h.core.search.CarportInfoSearch;

public interface CarportService {
	void insertCarport(CarportInfo carportInfo);
	void updateCarport(CarportInfo carportInfo);
	CarportInfo getCarport(String CarportID);
	void deleteCarport(String CarportID);
	List<CarportInfo> searchCarport(CarportInfoSearch carportInfoSearch);
}
