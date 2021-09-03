package com.gnavin.parkinglotservice.business.parking.respositories

import com.gnavin.parkinglotservice.business.parking.dbmodels.ParkingArea
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository

interface ParkingAreaRepository: CrudRepository<ParkingArea, String> {

    @Query("select * from PARKING_AREA")
    fun findAllParkingAreas(): List<ParkingArea>
}