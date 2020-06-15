/****************************************************************************************************************************
 - File Name        : Bus Service
 - Author           : Pushkar Singh Rathore
 - Creation Date    : 13-06-2020
 - Description      : This is a service interface of Bus Services.
  ****************************************************************************************************************************/ 

package com.cg.busmanagement.bus.service;

import java.util.List;

import com.cg.busmanagement.bus.dto.BusEntity;
import com.cg.busmanagement.bus.exception.BusIdNotFound;



public interface BusService {
	public List<BusEntity> getBusByRouteId(Integer routeId);
	/****************************************************************************************************************************
	 - Method Name      : deleteBus
	 - Input Parameters : int busId
	 - Return type      : void
	 - Author           : Pushkar Singh Rathore
	 - Creation Date    : 13-06-2020
	 - Description      : Deleting the bus from the database.
	  ****************************************************************************************************************************/ 
	
	public String deleteBus(int busId);
	/****************************************************************************************************************************
	 - Method Name      :updateBus
	 - Input Parameters : int busId
	 - Return type      : void
	 - Author           : Pushkar Singh Rathore
	 - Creation Date    : 13-06-2020
	 - Description      : Updating the bus from the database.
	  ****************************************************************************************************************************/ 
	

	public String updateBus(Integer busId, BusEntity bus) throws BusIdNotFound;
	/****************************************************************************************************************************
	 - Method Name      :updateCostbyBusType
	 - Input Parameters : int busType
	 - Return type      : void
	 - Author           : Pushkar Singh Rathore
	 - Creation Date    : 13-06-2020
	 - Description      : Updating the bus from the database.
	  ****************************************************************************************************************************/ 
	

	public String updateCostbyBusType(Integer busType, Integer cost);
	/****************************************************************************************************************************
	 - Method Name      : getBusById
	 - Input Parameters : int busId
	 - Return type      : void
	 - Author           : Pushkar Singh Rathore
	 - Creation Date    : 13-06-2020
	 - Description      : GET bus from the database.
	  ****************************************************************************************************************************/ 
	
	public BusEntity getBusById(int busId) throws BusIdNotFound;
	
	/****************************************************************************************************************************
	 - Method Name      : addBus
	 - Input Parameters : BusDto busdto
	 - Return type      : BusDto
	 - Author           : Pushkar Singh Rathore
	 - Creation Date    : 13-06-2020
	 - Description      : Inserting the Bus information into the database.
	  ****************************************************************************************************************************/ 

	public String addBus(BusEntity bus);
	/****************************************************************************************************************************
	 - Method Name      : getAllBus
	 - Input Parameters : BusDto busdto
	 - Return type      : BusDto
	 - Author           : Pushkar Singh Rathore
	 - Creation Date    : 13-06-2020
	 - Description      : Inserting the Bus information into the database.
	  ****************************************************************************************************************************/ 

	
	public List<BusEntity> getAllBus();

	String findBus(BusEntity bus);

}
