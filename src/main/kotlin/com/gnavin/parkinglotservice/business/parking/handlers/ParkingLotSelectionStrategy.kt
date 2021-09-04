package com.gnavin.parkinglotservice.business.parking.handlers

import com.gnavin.parkinglotservice.business.parking.dbmodels.ParkingLot

interface ParkingLotSelectionStrategy {
   fun select(parkingLots: List<ParkingLot>): ParkingLot
}