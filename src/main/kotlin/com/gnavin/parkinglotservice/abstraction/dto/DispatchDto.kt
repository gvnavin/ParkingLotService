package com.gnavin.parkinglotservice.abstraction.dto

data class DispatchDto(val id: String, val supplyId: String, val demandId:String, val startTimestamp:Long, var endTimestamp:Long, var entityAsJson: String?)