/****************************************************************************************************************************
 - File Name        : Bus Service Interface Implementation
 - Author           : Pushkar Singh Rathore
 - Creation Date    : 13-06-2020
 - Description      : This is an implementation of service interface of Bus Services.
  ****************************************************************************************************************************/ 

package com.cg.busmanagement.bus.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.busmanagement.bus.dao.BusRepository;
import com.cg.busmanagement.bus.dto.BusEntity;
import com.cg.busmanagement.bus.exception.BusIdNotFound;

@Service
public class BusServiceImplementation implements BusService{

	@Autowired
	BusRepository repository;

	@Override
	public String deleteBus(int busId) {
		repository.deleteById(busId);
		return "Bus record deleted successfully";
	}

	@Override
	public String updateCostbyBusType(Integer busType, Integer fare) {
		BusEntity bus = repository.getBusByType(busType);
		bus.setFare(fare);
		repository.saveAndFlush(bus);
		return "Bus data has been updated successfully";
	}

	

	@Override
	public List<BusEntity> getBusByRouteId(Integer routeId) {
		List<BusEntity> list = repository.getAllBus(routeId);
		return list;
	}

	@Override
	public BusEntity getBusById(int busId) throws BusIdNotFound {
		Optional<BusEntity> optional = repository.findById(busId);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			throw new BusIdNotFound("Bus not found for the given id");
		}
	}
	
	@Override
	public String addBus(BusEntity bus) {
		repository.save(bus);
		return "Bus Added";
	}
	
	@Override
	public List<BusEntity> getAllBus() {
		return repository.findAll();
	}

	@Override
	public String updateBus(Integer busId, BusEntity bus) throws BusIdNotFound {
		Optional<BusEntity> optional = repository.findById(busId);
		if (optional.isPresent()) {
			bus.setBusId(busId);
			repository.save(bus);
			return "Update Bus ";
		} else {
			throw new BusIdNotFound("Bus is not found for the given id");
		}
	}

	@Override
	public String findBus(BusEntity bus) {
		
		return null;
	}


}



