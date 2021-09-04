package com.gnavin.parkinglotservice.business.parking.services

import com.gnavin.parkinglotservice.abstraction.dbmodels.Demand
import com.gnavin.parkinglotservice.abstraction.dto.SupplyDto
import com.gnavin.parkinglotservice.business.parking.crud.ParkingAreaCrudHandler
import com.gnavin.parkinglotservice.business.parking.crud.ParkingLotCrudHandler
import com.gnavin.parkinglotservice.business.parking.handlers.ParkingLotAllocator
import com.gnavin.parkinglotservice.models.EntityType
import org.springframework.stereotype.Service

@Service
class ParkingService(private val parkingAreaCrudHandler: ParkingAreaCrudHandler,
                     private val parkingLotCrudHandler: ParkingLotCrudHandler,
                     private val parkingLotAllocator: ParkingLotAllocator
) {

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

    fun findSuitableAvailableParkingLotByParkingAreaId(parkingAreaId: String, demand: Demand): String {
        val (_id, _) = parkingLotAllocator.allocate(parkingAreaId, demand)
        return _id!!
    }
}