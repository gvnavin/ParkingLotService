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

    fun save(supplies: List<SupplyDto>): MutableIterable<ParkingLot> {

        val parkingAreas = supplies.map {
            var gson = Gson()
            val fromJson = gson.fromJson<ParkingLot>(it.entityAsJson, ParkingLot::class.java)
            if (fromJson._id == null) {
                fromJson._id =   it.id.toString()
            }
            println("ParkingLotCrudHandler.save fromJson = ${fromJson}")
            fromJson
        }
        println("ParkingLotCrudHandler.save parkingAreas: $parkingAreas")
        return parkingLotRepository.saveAll(parkingAreas)
    }

    fun findAllLotsWithParkingArea(): List<SupplyDto> {

        val allParkingLots = parkingLotRepository.findAllParkingLots()
        println("ParkingLotCrudHandler.findAllLotsWithParkingArea allParkingLots = ${allParkingLots}")
        val parkingLotDtos: List<ParkingLotDto> = mergeParkingLotAndParkingArea(allParkingLots)

        val listOfSupplies: List<SupplyDto> = parkingLotDtos.map {
            var gson = Gson()
            val entityAsJson = gson.toJson(it)
            SupplyDto(it.id, EntityType.PARKING_LOT, entityAsJson)
        }
        println("ParkingLotCrudHandler.findAllLotsWithParkingArea listOfSupplies = ${listOfSupplies}")

        return listOfSupplies
    }

    private fun mergeParkingLotAndParkingArea(parkingLots: List<ParkingLot>): List<ParkingLotDto> {
        //todo: fix me
        val parkingArea = parkingAreaCrudHandler.findParkingAreaById("");
        println("ParkingLotCrudHandler.findAllLotsWithParkingArea parkingArea = $parkingArea")

        val parkingLotDtos: List<ParkingLotDto> = parkingLots.map {
            ParkingLotDto(it.id!!, it.parkingAreaId, parkingArea.owner, parkingArea.location)
        }
        println("ParkingLotCrudHandler.findAllLotsWithParkingArea parkingLotDtos = ${parkingLotDtos}")
        return parkingLotDtos
    }

    fun findParkingLotByParkedVehicleId(id: String): List<ParkingLotDto> {
        val parkingLots = parkingLotRepository.findParkingLotByParkedVehicleId(id)
        return mergeParkingLotAndParkingArea(parkingLots)
    }

    fun findParkingLotByParkedVehicleColor(color: String): List<ParkingLotDto> {
        val parkingLots = parkingLotRepository.findParkingLotByParkedVehicleColor(color)
        return mergeParkingLotAndParkingArea(parkingLots)
    }

}