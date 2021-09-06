package com.gnavin.parkinglotservice.business.parking.dbmodels

import org.springframework.data.annotation.Id
import org.springframework.data.domain.Persistable
import org.springframework.data.relational.core.mapping.Table

@Table("PARKING_AREA")
data class ParkingArea(@Id var _id: String?, var childParkingAreaIds: String, val location:String, val owner:String): Persistable<String> {
    override fun getId(): String? {
        return _id
    }

    override fun isNew(): Boolean {
        return true
    }
}
