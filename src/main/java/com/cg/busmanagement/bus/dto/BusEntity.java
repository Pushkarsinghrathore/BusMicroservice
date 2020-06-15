/****************************************************************************************************************************
 - File Name        : Bus Service DTO
 - Author           : Pushkar Singh Rathore	
 - Creation Date    : 13-06-2020
 - Description      : This is an "Entity CLASS" that is used to map the data in the database.
  ****************************************************************************************************************************/ 

	package com.cg.busmanagement.bus.dto;
	
	import java.time.LocalDate;
	
	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.Id;
	import javax.persistence.Table;
	import javax.validation.constraints.Max;
	import javax.validation.constraints.Min;
	import javax.validation.constraints.NotBlank;
	import javax.validation.constraints.NotNull;
	
	@Entity
	@Table(name="bus")
	public class BusEntity {
		@Id
		@Column(name="busid",nullable = false)
		@Min(value = 1,message = "Bus Id must be a Natural number")
		private Integer busId;
		
		@Column(name="busname")
		@NotNull(message="BusName is mandatory")
		@NotBlank(message="BusName is mandatory")
		private String busName;
		
		@Column(name="bustype")
		@NotNull(message="BusType is mandatory")
		@Min(value = 0,message = "Bus Type should Lie Between 0 to 2")
		@Max(value = 2,message = "Bus Type should Lie Between 0 to 2")
	    private Integer busType;
		
		@Column(name="fare")
		@NotNull(message="Fare is mandatory")
		@Min(value = 300,message = "Bus fare should lie 300-1000")
		@Max(value = 1000,message = "Bus fare should lie 300-1000")
		private Integer fare;
		
		@Column(name="routeid")
	    @NotNull(message="Route ID is mandatory")
	    @Min(value = 100,message = "Route ID should lie 99-150")
		@Max(value = 150,message = "Route ID should lie 99-150")
		private Integer routeId;
		
		@Column(name="stime")
		@NotNull(message="STime  is mandatory")
		@NotBlank(message="STime is mandatory")
		private String sTime;
		
		@Column(name="etime")
		@NotNull(message="ETime  is mandatory")
		@NotBlank(message="ETime is mandatory")
		private String eTime;
		
		@Column(name="seat")
		@Min(value = 30,message = "Seats should Lie Between 30 to 50")
		@Max(value = 50,message = "Seats should Lie Between 30 to 50")
		private Integer seat;
	    
		//@NotNull(message="Date   is mandatory")
		//@NotBlank(message="Date is mandatory")
		private LocalDate date;
	
		public BusEntity(Integer busId,
				@NotNull(message = "BusName is mandatory") @NotBlank(message = "BusName is mandatory") String busName,
				@NotNull(message = "BusType  is mandatory") @NotBlank(message = "BusType is mandatory") Integer busType,
				@NotNull(message = "BusFare  is mandatory") @NotBlank(message = "BusFare is mandatory") Integer fare,
				@NotNull(message = "RouteId  is mandatory") @NotBlank(message = "RouteId is mandatory") Integer routeId,
				@NotNull(message = "STime  is mandatory") @NotBlank(message = "STime is mandatory") String sTime,
				@NotNull(message = "ETime  is mandatory") @NotBlank(message = "ETime is mandatory") String eTime,
				@NotNull(message = "Seats  are mandatory") @NotBlank(message = "Seats are mandatory") Integer seat,
				LocalDate date) {
			super();
			this.busId = busId;
			this.busName = busName;
			this.busType = busType;
			this.fare = fare;
			this.routeId = routeId;
			this.sTime = sTime;
			this.eTime = eTime;
			this.seat = seat;
			this.date = date;
		}
		public BusEntity() {
			super();
		}
		public Integer getBusId() {
			return busId;
		}
		public void setBusId(Integer busId) {
			this.busId = busId;
		}
		public String getBusName() {
			return busName;
		}
		public void setBusName(String busName) {
			this.busName = busName;
		}
		public Integer getBusType() {
			return busType;
		}
		public void setBusType(Integer busType) {
			this.busType = busType;
		}
		public Integer getFare() {
			return fare;
		}
		public void setFare(Integer fare) {
			this.fare = fare;
		}
		public Integer getRouteId() {
			return routeId;
		}
		public void setRouteId(Integer routeId) {
			this.routeId = routeId;
		}
		public String getsTime() {
			return sTime;
		}
		public void setsTime(String sTime) {
			this.sTime = sTime;
		}
		public String geteTime() {
			return eTime;
		}
		public void seteTime(String eTime) {
			this.eTime = eTime;
		}
		public Integer getSeat() {
			return seat;
		}
		public void setSeat(Integer seat) {
			this.seat = seat;
		}
		public LocalDate getDate() {
			return date;
		}
		public void setDate(LocalDate date) {
			this.date = date;
		}
		
	
		
	
	}
