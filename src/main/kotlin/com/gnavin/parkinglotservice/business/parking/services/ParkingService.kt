package com.gnavin.parkinglotservice.business.parking.services

import com.gnavin.parkinglotservice.abstraction.dto.SupplyDto
import com.gnavin.parkinglotservice.business.parking.crud.ParkingAreaCrudHandler
import com.gnavin.parkinglotservice.business.parking.crud.ParkingLotCrudHandler
import com.gnavin.parkinglotservice.models.EntityType
import org.springframework.stereotype.Service

@Service
class ParkingService(private val parkingAreaCrudHandler: ParkingAreaCrudHandler,
                     private val parkingLotCrudHandler: ParkingLotCrudHandler) {

    fun findAllSupplies(): List<SupplyDto> {
        return parkingLotCrudHandler.findAllLotsWithParkingArea()
    }

    fun saveSupplies(type: EntityType, supplies: List<SupplyDto>) {
        if (type == EntityType.PARKING_AREA) {
            parkingAreaCrudHandler.save(supplies)
        } else if (type == EntityType.PARKING_LOT) {
            parkingLotCrudHandler.save(supplies)
        }
    }
}