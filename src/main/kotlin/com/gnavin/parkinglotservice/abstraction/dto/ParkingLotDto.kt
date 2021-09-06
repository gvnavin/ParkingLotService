package com.gnavin.parkinglotservice.abstraction.dto

data class ParkingLotDto(val id: String, val parkingAreaId: String, val childParkingAreaId: String, val location:String, val owner:String)
