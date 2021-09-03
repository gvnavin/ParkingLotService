package com.gnavin.parkinglotservice.factories

import com.gnavin.parkinglotservice.abstraction.dto.SupplyDto
import com.gnavin.parkinglotservice.business.parking.services.ParkingService
import com.gnavin.parkinglotservice.models.EntityType
import org.springframework.stereotype.Component

@Component
class BusinessHandlerFactory(val parkingService: ParkingService) {

    fun handleSupply(type: EntityType, supplies: List<SupplyDto>) {

        if (type == EntityType.PARKING_AREA ||
            type == EntityType.PARKING_LOT) {
            parkingService.saveSupplies(type, supplies)
        }
    }
}