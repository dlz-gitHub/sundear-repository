package com.v2h.core.dao;

import java.util.List;

import com.v2h.core.model.CarportInfo;
import com.v2h.core.search.CarportInfoSearch;

public interface CarportDao {
	
	void insertCarport(CarportInfo carportInfo);
	void updateCarport(CarportInfo carportInfo);
	CarportInfo getCarport(String CarportID);
	void deleteCarport(String CarportID);
	List<CarportInfo> searchCarport(CarportInfoSearch carportInfoSearch);
	int searchCarportCount(CarportInfoSearch carportInfoSearch);
}