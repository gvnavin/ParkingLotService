package com.gnavin.parkinglotservice.business.parking.handlers

import com.gnavin.parkinglotservice.business.parking.dbmodels.ParkingLot
import org.springframework.stereotype.Component

@Component
class ParkingLotDistanceBasedStrategy: ParkingLotSelectionStrategy {

    fun compute(entry: Object, lot: ParkingLot): Int {
        return 1;
    }

    fun findMinimumDistanceLot(parkingLots: List<ParkingLot>): ParkingLot {

        val min = Int.MAX_VALUE
        lateinit var resultParkingLot: ParkingLot
        for (parkingLot in parkingLots) {
            val dist = compute(Object(), parkingLot)
            if (dist < min) {
                resultParkingLot = parkingLot
            }
        }

        return resultParkingLot
    }

    override fun select(parkingLots: List<ParkingLot>): ParkingLot {
        return findMinimumDistanceLot(parkingLots)
    }
}