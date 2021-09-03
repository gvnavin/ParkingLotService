package com.gnavin.parkinglotservice.business.parking.respositories

import com.gnavin.parkinglotservice.business.parking.dbmodels.ParkingLot
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository

interface ParkingLotRepository: CrudRepository<ParkingLot, String> {

    @Query("SELECT * FROM PARKING_LOT")
    fun findAllParkingLots(): List<ParkingLot>

    fun findParkingLotsByParkingAreaId(parkingAreaId: String): List<ParkingLot>

    @Query("""
    SELECT PL.* FROM PARKING_LOT AS PL LEFT OUTER JOIN
    (SELECT PARKING_LOT._ID AS ID2 FROM PARKING_LOT INNER JOIN DISPATCH ON PARKING_LOT._ID = DISPATCH.SUPPLY_ID WHERE DISPATCH.END_TIMESTAMP = 0) AS T
    ON PL._ID = T.ID2 WHERE T.ID2 IS NULL
    """)
    fun findAvailableParkingLotsByParkingAreaId(parkingAreaId: String): List<ParkingLot>
}