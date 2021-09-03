package com.gnavin.parkinglotservice.business.vehicle.services

import com.gnavin.parkinglotservice.business.parking.respositories.ParkingAreaRepository
import com.gnavin.parkinglotservice.business.parking.respositories.ParkingLotRepository
import org.springframework.stereotype.Service

@Service
class VechicleService(private val parkingLotRepository: ParkingLotRepository, private val parkingAreaRepository: ParkingAreaRepository) {

}