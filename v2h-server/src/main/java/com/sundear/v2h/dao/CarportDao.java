package com.sundear.v2h.dao;
import java.util.List;

import com.sundear.v2h.model.CarportInfo;
import com.sundear.v2h.search.CarportInfoSearch;

public interface CarportDao {
	
	void insertCarport(CarportInfo carportInfo);
	void updateCarport(CarportInfo carportInfo);
	CarportInfo getCarport(String CarportID);
	void deleteCarport(String CarportID);
	List<CarportInfo> searchCarport(CarportInfoSearch carportInfoSearch);
	int searchCarportCount(CarportInfoSearch carportInfoSearch);
}
