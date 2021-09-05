package com.gnavin.parkinglotservice.converters.todto

import com.gnavin.parkinglotservice.abstraction.dto.DispatchDto
import com.gnavin.parkinglotservice.abstraction.dto.ParkingLotDto
import com.gnavin.parkinglotservice.business.vehicle.dbmodels.Vehicle
import com.google.gson.Gson

object ToDispatchDto {

    fun batchConvertVehicles(vehicles: List<Vehicle>): List<DispatchDto> {
        return vehicles.map {
            val gson = Gson()
            val toJson = gson.toJson(it)
            DispatchDto("","", "", 0,0, toJson)
        }
    }

    fun batchConvertParkingLotDtos(parkingLotDtos: List<ParkingLotDto>): List<DispatchDto> {
        return parkingLotDtos.map {
            val gson = Gson()
            val toJson = gson.toJson(it)
            DispatchDto("","", "", 0,0, toJson)
        }
    }

}