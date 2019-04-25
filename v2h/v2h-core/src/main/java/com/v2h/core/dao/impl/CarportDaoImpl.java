package com.v2h.core.dao.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.v2h.core.dao.CarportDao;
import com.v2h.core.mapper.CarportMapper;
import com.v2h.core.model.CarportInfo;
import com.v2h.core.search.CarportInfoSearch;

@Repository
public class CarportDaoImpl implements CarportDao {

	@Autowired
	private CarportMapper carportMapper;
	public void insertCarport(CarportInfo carportInfo) {
				carportInfo.setCarportID(UUID.randomUUID().toString().replaceAll("-", ""));
				carportMapper.insertCarport(carportInfo);
	}
	public void updateCarport(CarportInfo carportInfo) {
		carportMapper.updateCarport(carportInfo);
	}
	public CarportInfo getCarport(String CarportID) {
		return carportMapper.getCarport(CarportID);
	}
	public void deleteCarport(String CarportID) {
		carportMapper.deleteCarport(CarportID);
	}
	public List<CarportInfo> searchCarport(CarportInfoSearch carportInfoSearch){
		return carportMapper.searchCarport(carportInfoSearch);
	}
	public int searchCarportCount(CarportInfoSearch carportInfoSearch){
		return carportMapper.searchCarportCount(carportInfoSearch);
	}
}