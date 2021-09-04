package com.gnavin.parkinglotservice.factories

import com.gnavin.parkinglotservice.abstraction.dbmodels.Demand
import com.gnavin.parkinglotservice.abstraction.dto.DemandDto
import com.gnavin.parkinglotservice.abstraction.dto.SupplyDto
import com.gnavin.parkinglotservice.business.parking.services.ParkingService
import com.gnavin.parkinglotservice.business.vehicle.services.VehicleService
import com.gnavin.parkinglotservice.models.EntityType
import org.springframework.stereotype.Component

@Component
class BusinessHandlerDelegator(val parkingService: ParkingService,
                               val vehicleService: VehicleService,
) {

    fun handleSupply(type: EntityType, supplies: List<SupplyDto>) {

        if (type == EntityType.PARKING_AREA ||
            type == EntityType.PARKING_LOT) {
            parkingService.saveSupplies(type, supplies)
        }
    }

    fun handleDemands(type: EntityType, demandDtos: List<DemandDto>) {
        if (type == EntityType.PARKING_LOT) {
            vehicleService.saveAll(demandDtos)
        }
    }

    fun handleDispatchStart(parkingAreaId: String, demand: Demand): String {
        return parkingService.findSuitableAvailableParkingLotByParkingAreaId(parkingAreaId, demand)
    }

    fun findAllSupplies(): List<SupplyDto> {
        return parkingService.findAllSupplies()
    }

}