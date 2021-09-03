package com.gnavin.parkinglotservice.dbmodels

import org.springframework.data.annotation.Id
import org.springframework.data.domain.Persistable
import org.springframework.data.relational.core.mapping.Table

@Table("PARKING_AREA")
data class ParkingArea(@Id val _id: String, val location:String, val owner:String): Persistable<String> {
    override fun getId(): String? {
        return _id
    }

    override fun isNew(): Boolean {
        return true
    }
}
