package com.gnavin.parkinglotservice.business.parking.handlers

import com.gnavin.parkinglotservice.business.parking.dbmodels.ParkingLot
import org.springframework.stereotype.Component

@Component
class ParkingLotSelector {

    fun select(parkingLots: List<ParkingLot>): ParkingLot {
        val strategy = getStrategy()
        return strategy.select(parkingLots)
    }

    //StrategyFactory ->
    fun getStrategy(): ParkingLotSelectionStrategy {
        return ParkingLotDistanceBasedStrategy()
//        return EvenDistributionStragegy()
//        return FillFirstStragey()
    }

}