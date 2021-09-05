package com.gnavin.parkinglotservice.business.vehicle.services

import com.gnavin.parkinglotservice.abstraction.dto.DemandDto
import com.gnavin.parkinglotservice.business.vehicle.dbmodels.Vehicle
import com.gnavin.parkinglotservice.business.vehicle.respositories.VehicleRepository
import com.google.gson.Gson
import org.springframework.stereotype.Service

@Service
class VehicleService(private val vehicleRepository: VehicleRepository) {

    fun saveAll(demandDtos: List<DemandDto>) {
        val vehicles = demandDtos.map {
            var gson = Gson()
            val fromJson = gson.fromJson<Vehicle>(it.entityAsJson, Vehicle::class.java)
            println("fromJson = ${fromJson}")
            fromJson
        }
        vehicleRepository.saveAll(vehicles)
    }

    fun findVehiclesInParkingLotWithColor(color: String): List<Vehicle> {
        return vehicleRepository.findVehiclesInParkingLotWithFilters(color)
    }
}