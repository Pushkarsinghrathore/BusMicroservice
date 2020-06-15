/****************************************************************************************************************************
	 - File Name        : Bus Service DAO
	 - Author           : Pushkar Singh Rathore
	 - Creation Date    : 13-06-2020
	 - Description      : This is a repository class used to use the database for Bus Services.
	  ****************************************************************************************************************************/ 
	
	package com.cg.busmanagement.bus.dao;
	
	import java.util.List;
	
	import org.springframework.data.jpa.repository.JpaRepository;
	import org.springframework.data.jpa.repository.Query;

import com.cg.busmanagement.bus.dto.BusEntity;
	
	public interface BusRepository extends JpaRepository<BusEntity,Integer>
	{
		
		
			
			@Query("Select b from BusEntity b where b.routeId=?1")
			public List<BusEntity> getAllBus(Integer routeId);
	
			@Query("Select b from BusEntity b where b.busType=?1")
			public BusEntity getBusByType(int busType);
	
				
		}
		
	
	


