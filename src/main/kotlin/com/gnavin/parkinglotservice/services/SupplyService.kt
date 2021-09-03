package com.gnavin.parkinglotservice.services

import com.gnavin.parkinglotservice.dbmodels.ParkingArea
import com.gnavin.parkinglotservice.dbmodels.ParkingLot
import com.gnavin.parkinglotservice.models.ParkingLotDto
import com.gnavin.parkinglotservice.models.Supply
import com.gnavin.parkinglotservice.models.EntityType
import com.gnavin.parkinglotservice.repositories.ParkingAreaRepository
import com.gnavin.parkinglotservice.repositories.ParkingLotRepository
import com.google.gson.Gson
import org.springframework.stereotype.Service

@Service
class SupplyService(private val parkingLotRepository: ParkingLotRepository, private val parkingAreaRepository: ParkingAreaRepository) {

    fun findAllSupplies(): List<Supply> {

        val allParkingLots = parkingLotRepository.findAllParkingLots()
        println("allParkingLots = ${allParkingLots}")

        val allParkingAreas = parkingAreaRepository.findAllParkingAreas()
        println("allParkingAreas = ${allParkingAreas}")

        val parkingArea = allParkingAreas.get(0);
        println("parkingArea = ${parkingArea}")

        val parkingLotDtos: List<ParkingLotDto> = allParkingLots.map {
            ParkingLotDto(it.id!!, it.parkingAreaId, parkingArea.owner, parkingArea.location)
        }
        println("parkingLotDtos = ${parkingLotDtos}")

        val listOfSupplies: List<Supply> = parkingLotDtos.map {
            var gson = Gson()
            val entityAsJson = gson.toJson(it)
            Supply(it.id, EntityType.PARKING_LOT, entityAsJson)
        }
        println("listOfSupplies = ${listOfSupplies}")

        return listOfSupplies
    }

    fun saveSupplies(type: EntityType, supplies: List<Supply>) {
        if (type == EntityType.PARKING_AREA) {
            val parkingAreas = supplies.map {
                var gson = Gson()
                val fromJson = gson.fromJson<ParkingArea>(it.entityAsJson, ParkingArea::class.java)
                println("fromJson = ${fromJson}")
                fromJson
            }
            parkingAreaRepository.saveAll(parkingAreas)
        }
        if (type == EntityType.PARKING_LOT) {
            val parkingAreas = supplies.map {
                var gson = Gson()
                val fromJson = gson.fromJson<ParkingLot>(it.entityAsJson, ParkingLot::class.java)
                println("fromJson = ${fromJson}")
                fromJson
            }
            parkingLotRepository.saveAll(parkingAreas)
        }
    }

}