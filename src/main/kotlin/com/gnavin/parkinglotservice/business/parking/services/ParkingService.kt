package com.gnavin.parkinglotservice.business.parking.services

import com.gnavin.parkinglotservice.abstraction.dbmodels.Demand
import com.gnavin.parkinglotservice.abstraction.dto.ParkingLotDto
import com.gnavin.parkinglotservice.abstraction.dto.SupplyDto
import com.gnavin.parkinglotservice.business.parking.crud.ParkingAreaCrudHandler
import com.gnavin.parkinglotservice.business.parking.crud.ParkingLotCrudHandler
import com.gnavin.parkinglotservice.business.parking.dbmodels.ParkingArea
import com.gnavin.parkinglotservice.business.parking.dbmodels.ParkingLot
import com.gnavin.parkinglotservice.business.parking.handlers.ParkingLotAllocator
import com.gnavin.parkinglotservice.models.EntityType
import org.springframework.stereotype.Service
import java.util.*

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

    fun findParkingLotByParkedVehicleId(id: String): List<ParkingLotDto> {
        return parkingLotCrudHandler.findParkingLotByParkedVehicleId(id)
    }

    fun findParkingLotByParkedVehicleColor(color: String): List<ParkingLotDto> {
        return parkingLotCrudHandler.findParkingLotByParkedVehicleColor(color)
    }

    fun saveBulkSupplies(
        parkingAreaId: String,
        noOfChildParkingArea: Int,
        listOfNoOfParkingLotInChildParkingArea: List<Int>
    ) {

        val childParkingAreaIds = parkingAreaCrudHandler.saveBulkSupplies(parkingAreaId, noOfChildParkingArea)

        listOfNoOfParkingLotInChildParkingArea.forEachIndexed { index, element ->

            val list = IntRange(0, element).map {
                ParkingLot(
                    UUID.randomUUID().toString(),
                    parkingAreaId,
                    childParkingAreaIds[index]
                )
            }

            parkingLotCrudHandler.saveParkingLot(list)

        }

    }
}