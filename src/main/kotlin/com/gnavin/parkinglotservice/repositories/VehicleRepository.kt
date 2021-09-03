package com.gnavin.parkinglotservice.repositories

import com.gnavin.parkinglotservice.dbmodels.Vehicle
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository

interface VehicleRepository: CrudRepository<Vehicle, String> {

    @Query("select * from VEHICLE")
    fun findAllVehicles(): List<Vehicle>
}