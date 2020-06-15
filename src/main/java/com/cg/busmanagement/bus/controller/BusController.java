	/****************************************************************************************************************************
	 - File Name        : Bus Service Controller
	 - Author           : Pushkar Singh Rathore
	 - Creation Date    : 13-06-2020
	 - Description      : This is an end point controller to consume Bus Service.
	  ****************************************************************************************************************************/ 
	
	package com.cg.busmanagement.bus.controller;
	
	import java.util.List;
	import javax.validation.ConstraintViolationException;
	import javax.validation.Valid;
	import javax.validation.constraints.Min;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
	import org.springframework.validation.annotation.Validated;
	import org.springframework.web.bind.annotation.CrossOrigin;
	import org.springframework.web.bind.annotation.DeleteMapping;
	import org.springframework.web.bind.annotation.ExceptionHandler;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.PutMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.ResponseStatus;
	import org.springframework.web.bind.annotation.RestController;

import com.cg.busmanagement.bus.dto.BusEntity;
import com.cg.busmanagement.bus.exception.BusIdNotFound;
import com.cg.busmanagement.bus.service.BusServiceImplementation;
	
	
	
	@RestController
	@RequestMapping("/bus")
	@Validated
	
	public class BusController {
		@Autowired
		BusServiceImplementation service;
	   
		 // GET   ALL BUS SERVICE OPTIONS
			/****************************************************************************************************************************
			- Method Name      : Start
			- Input Parameters : ---
			- Return type      : ResponseEntity
			- Author           : Pushkar Singh Rathore
			- Creation Date    : 13-06-2020
			- Description      : Getting the bus Services provided.
			- End Point Url    :  http://localhost:9093/bus/Services
			****************************************************************************************************************************/ 
		
	
		 // GET   ALL BUS INFORMATION
		/****************************************************************************************************************************
		- Method Name      : getAllBusDetails
		- Input Parameters : ---
		- Return type      : ResponseEntity
		- Author           : Pushkar Singh Rathore
		- Creation Date    : 13-06-2020
		- Description      : Getting the bus information using the "END POINT" from the database.
		- End Point Url    :  http://localhost:9093/bus/fetchAllBus
		****************************************************************************************************************************/ 
		  @GetMapping("/fetchAllBus")
		  public List<com.cg.busmanagement.bus.dto.BusEntity> getAllBusDetails() {
			return service.getAllBus();
		}
		
	
	  
		     // DELETING Bus
		
	
			/****************************************************************************************************************************
			 - Method Name      : deleteBus
			 - Input Parameters : int Busid
			 - Return type      : ResponseEntity<String>
			 - Author           : Pushkar Singh Rathore
			 - Creation Date    : 13-06-2020
			 - Description      : Deleting the Bus from the database.
			 - End Point Url    :  http://localhost:9093/bus/deleteById/
			  ****************************************************************************************************************************/ 
		@DeleteMapping("/deleteById/{busId}")
		public ResponseEntity<String> deleteBus(@PathVariable("busId")@Min(value = 1) Integer busId) {
			return ResponseEntity.ok(service.deleteBus(busId));
		}
		
		
	
		// GET Bus INFORMATION BY BUS ID
		/****************************************************************************************************************************
		- Method Name      : fetchByRouteId
		- Input Parameters : int routeId
		- Return type      : ResponseEntity
		- Author           : Pushkar Singh Rathore
		- Creation Date    : 13-06-2020
		- Description      : Getting the bus information using the routeId from the database.
		- End Point Url    :  http://localhost:9093/bus/fetchByRouteId/
		****************************************************************************************************************************/ 
		@GetMapping("/fetchByRouteId/{routeId}")
		public ResponseEntity<List<BusEntity>> getBusByRouteId(@PathVariable("routeId") @Min(value = 100) Integer routeId) {
			List<BusEntity> busList = service.getBusByRouteId(routeId);
			return new ResponseEntity<>(busList, HttpStatus.OK);
		}
	
	
		// UPDATING THE BUS INFORMATION
		/****************************************************************************************************************************
		- Method Name      : updateCost
		- Input Parameters : int busType,Cost
		- Return type      : ResponseEntity<String>
		- Author           : Pushkar Singh Rathore
		- Creation Date    : 13-06-2020
		- Description      : Updating the bus information in the database.
		- End Point Url    :  http://localhost:9093/bus/updateByType/
		****************************************************************************************************************************/ 
	@PutMapping("/updateByType/{busType}/{Cost}")
	
	public ResponseEntity<String> updateCost(@PathVariable("busType") Integer busType,
			@PathVariable("Cost") Integer cost) {
		return ResponseEntity.ok(service.updateCostbyBusType(busType, cost));
	}
		                                                                                                  
		
	
	   // GET Bus INFORMATION BY Bus ID
	/****************************************************************************************************************************
	- Method Name      : getBusById
	- Input Parameters : int Busid
	- Return type      : ResponseEntity
	- Author           : Pushkar Singh Rathore
	- Creation Date    : 13-06-2020
	- Description      : Getting the bus information using the bus id from the database.
	- End Point Url    :  http://localhost:9093/bus/fetchByBusId/
	****************************************************************************************************************************/ 
	@GetMapping("/fetchByBusId/{busId}")
	public ResponseEntity<BusEntity> getBusById(@PathVariable("busId") Integer busId) throws BusIdNotFound {
		BusEntity bus = service.getBusById(busId);
		return new ResponseEntity<>(bus, HttpStatus.OK);
	}	
		                                                                                                     
	
	// Adding Bus
	
	/****************************************************************************************************************************
	- Method Name      : add
	- Input Parameters : BusDto busdto
	- Return type      : ResponseEntity<BusDto>
	- Author           : Pushkar Singh Rathore
	- Creation Date    : 13-06-2020
	- Description      : Inserting the bus information into the database.
	- End Point Url    : http://localhost:9093/bus/addBus/
	****************************************************************************************************************************/ 
	                                                                                                  
	@PostMapping("/addBus")
	public ResponseEntity<String> getBusById(@Valid @RequestBody BusEntity bus) {
	String msg = service.addBus(bus);
	return new ResponseEntity<>(msg, HttpStatus.OK);
	}
	
	
	
	@ExceptionHandler(ConstraintViolationException.class)
	  @ResponseStatus(HttpStatus.BAD_REQUEST)
	  ResponseEntity<String> handleException(Exception e) {
	    return new ResponseEntity<>(" " + e.getMessage(), HttpStatus.BAD_REQUEST);
	  } 
		                                                                                                      
		
	
	
		
		
	
	}
	
