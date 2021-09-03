package com.gnavin.parkinglotservice.services
import com.gnavin.parkinglotservice.dbmodels.Vehicle
import com.gnavin.parkinglotservice.dbmodels.Demand
import com.gnavin.parkinglotservice.models.EntityType
import com.gnavin.parkinglotservice.repositories.DemandRepository
import com.gnavin.parkinglotservice.repositories.VehicleRepository
import com.google.gson.Gson
import org.springframework.stereotype.Service

@Service
class DemandService(private val vehicleRepository: VehicleRepository, private val demandRepository: DemandRepository) {

    fun findAllDemands(): List<Demand> {

//        val allVechicles = vehicleRepository.findAllVehicles()
//        println("allVechicles = ${allVechicles}")
//
//        val demands: List<Demand> = allVechicles.map {
//            var gson = Gson()
//            val entityAsJson = gson.toJson(it)
//            Demand("id", EntityType.PARKING_LOT, entityAsJson)
//        }
//        println("demands = ${demands}")
//
//        return demands

        return demandRepository.findAllDemands()

    }
    fun saveDemand(type: EntityType, demands: List<Demand>) {
        if (type == EntityType.PARKING_LOT) {
            val vehicles = demands.map {
                var gson = Gson()
                val fromJson = gson.fromJson<Vehicle>(it.entityAsJson, Vehicle::class.java)
                println("fromJson = ${fromJson}")
                fromJson
            }
            vehicleRepository.saveAll(vehicles)
        }
    }
}