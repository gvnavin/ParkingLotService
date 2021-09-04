package com.gnavin.parkinglotservice.business.parking.handlers

import com.gnavin.parkinglotservice.abstraction.dbmodels.Demand
import com.gnavin.parkinglotservice.business.parking.dbmodels.ParkingLot
import com.gnavin.parkinglotservice.business.parking.respositories.ParkingLotRepository
import org.springframework.stereotype.Component

@Component
class ParkingLotAllocator(
    private val parkingLotRepository: ParkingLotRepository,
    private val parkingLotSelector: ParkingLotSelector
) {

    fun allocate(parkingAreaId: String, demand: Demand): ParkingLot {
        val allAvailableParkingLotsByParkingArea =
            parkingLotRepository.findAvailableParkingLotsByParkingAreaId(parkingAreaId)

        val allotedParkingLot = parkingLotSelector.select(allAvailableParkingLotsByParkingArea)
        return allotedParkingLot
    }
}