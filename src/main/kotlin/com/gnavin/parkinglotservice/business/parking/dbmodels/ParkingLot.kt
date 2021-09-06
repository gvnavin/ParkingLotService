package com.gnavin.parkinglotservice.business.parking.dbmodels

import org.springframework.data.annotation.Id
import org.springframework.data.domain.Persistable
import org.springframework.data.relational.core.mapping.Table

@Table("PARKING_LOT")
data class ParkingLot(@Id var _id: String?, val parkingAreaId: String, var childParkingAreaId: String): Persistable<String> {
    override fun isNew(): Boolean {
        return true // should be backed by code that is able to figure out whether the entity is new.
    }

    override fun getId(): String? {
        return _id
    }
}
