package com.gnavin.parkinglotservice.business.parking.crud

import com.gnavin.parkinglotservice.abstraction.dto.ParkingLotDto
import com.gnavin.parkinglotservice.abstraction.dto.SupplyDto
import com.gnavin.parkinglotservice.business.parking.dbmodels.ParkingLot
import com.gnavin.parkinglotservice.business.parking.respositories.ParkingLotRepository
import com.gnavin.parkinglotservice.models.EntityType
import com.google.gson.Gson
import org.springframework.stereotype.Component

@Component
class ParkingLotCrudHandler(
    private val parkingAreaCrudHandler: ParkingAreaCrudHandler,
    private val parkingLotRepository: ParkingLotRepository
    ) {

    fun save(supplies: List<SupplyDto>) {

        val parkingAreas = supplies.map {
            var gson = Gson()
            val fromJson = gson.fromJson<ParkingLot>(it.entityAsJson, ParkingLot::class.java)
            println("fromJson = ${fromJson}")
            fromJson
        }
        parkingLotRepository.saveAll(parkingAreas)
    }

    fun findAllLotsWithParkingArea(): List<SupplyDto> {

        val allParkingLots = parkingLotRepository.findAllParkingLots()
        println("allParkingLots = ${allParkingLots}")

        //todo: fix me
        val parkingArea = parkingAreaCrudHandler.findParkingAreaById("");

        val parkingLotDtos: List<ParkingLotDto> = allParkingLots.map {
            ParkingLotDto(it.id!!, it.parkingAreaId, parkingArea.owner, parkingArea.location)
        }
        println("parkingLotDtos = ${parkingLotDtos}")

        val listOfSupplies: List<SupplyDto> = parkingLotDtos.map {
            var gson = Gson()
            val entityAsJson = gson.toJson(it)
            SupplyDto(it.id, EntityType.PARKING_LOT, entityAsJson)
        }
        println("listOfSupplies = ${listOfSupplies}")

        return listOfSupplies
    }
}