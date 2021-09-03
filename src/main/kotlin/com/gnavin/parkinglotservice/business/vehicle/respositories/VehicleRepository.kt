package com.gnavin.parkinglotservice.business.vehicle.respositories

import com.gnavin.parkinglotservice.business.vehicle.dbmodels.Vehicle
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository

interface VehicleRepository: CrudRepository<Vehicle, String> {

    @Query("select * from VEHICLE")
    fun findAllVehicles(): List<Vehicle>
}