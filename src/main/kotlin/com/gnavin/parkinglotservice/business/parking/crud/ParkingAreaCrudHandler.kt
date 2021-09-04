package com.gnavin.parkinglotservice.business.parking.crud

import com.gnavin.parkinglotservice.abstraction.dto.SupplyDto
import com.gnavin.parkinglotservice.business.parking.dbmodels.ParkingArea
import com.gnavin.parkinglotservice.business.parking.respositories.ParkingAreaRepository
import com.google.gson.Gson
import org.springframework.stereotype.Component
import java.util.*

@Component
class ParkingAreaCrudHandler(private val parkingAreaRepository: ParkingAreaRepository) {

    fun save(supplies: List<SupplyDto>) {

        val parkingAreas = supplies.map {
            var gson = Gson()
            val fromJson = gson.fromJson<ParkingArea>(it.entityAsJson, ParkingArea::class.java)
            if (fromJson._id == null) {
                fromJson._id =   it.id.toString()
            }
            println("ParkingAreaCrudHandler.save fromJson = ${fromJson}")
            fromJson
        }
        parkingAreaRepository.saveAll(parkingAreas)
    }

    fun findParkingAreaById(id: String): ParkingArea {
        //todo: fix me
        val allParkingAreas = parkingAreaRepository.findAllParkingAreas()
        println("ParkingAreaCrudHandler.findParkingAreaById allParkingAreas = ${allParkingAreas}")

        val parkingArea = allParkingAreas.get(0);
        println("ParkingAreaCrudHandler.findParkingAreaById parkingArea = ${parkingArea}")

        return parkingArea
    }
}