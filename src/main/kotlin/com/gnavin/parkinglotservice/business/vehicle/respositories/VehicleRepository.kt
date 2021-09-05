package com.gnavin.parkinglotservice.business.vehicle.respositories

import com.gnavin.parkinglotservice.business.vehicle.dbmodels.Vehicle
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository

interface VehicleRepository: CrudRepository<Vehicle, String> {

    @Query("select * from VEHICLE")
    fun findAllVehicles(): List<Vehicle>

    @Query("""
        SELECT * FROM VEHICLE AS V INNER JOIN (
            SELECT DEMAND.ENTITY_ID FROM DISPATCH INNER JOIN DEMAND ON DISPATCH.DEMAND_ID = DEMAND._ID WHERE END_TIMESTAMP=0
        ) AS D WHERE V.COLOR = :color
        """)
    fun findVehiclesInParkingLotWithFilters(color: String): List<Vehicle>
}