package com.v2h.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.v2h.service.CarportService;
import com.v2h.core.dao.CarportDao;
import com.v2h.core.model.CarportInfo;
import com.v2h.core.search.CarportInfoSearch;
import com.sundear.base.enumeration.SearchEnum.SearchTypeEnum;

@Service("CarportService")
public class CarportServiceImpl implements CarportService {
	@Autowired
	private  CarportDao carportDao;
	
	public void insertCarport(CarportInfo carportInfo){
		carportDao.insertCarport(carportInfo);
	}
	public void updateCarport(CarportInfo carportInfo) {
		carportDao.updateCarport(carportInfo);
	}
	public CarportInfo getCarport(String CarportID) {
		return carportDao.getCarport(CarportID);
	}
	public void deleteCarport(String CarportID) {
		carportDao.deleteCarport(CarportID);
	}
	public List<CarportInfo> searchCarport(CarportInfoSearch carportInfoSearch){
		if(carportInfoSearch.getSearchType()==SearchTypeEnum.PAGES){
			carportInfoSearch.setTotalCount(carportDao.searchCarportCount(carportInfoSearch));
		}
		return carportDao.searchCarport(carportInfoSearch);
	}
}