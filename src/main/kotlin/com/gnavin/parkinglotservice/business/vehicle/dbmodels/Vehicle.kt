package com.gnavin.parkinglotservice.business.vehicle.dbmodels

import org.springframework.data.annotation.Id
import org.springframework.data.domain.Persistable
import org.springframework.data.relational.core.mapping.Table

@Table("VEHICLE")
data class Vehicle(@Id val _id: String, val owner: String, val color: String) : Persistable<String> {
    override fun getId(): String? {
        return _id
    }

    override fun isNew(): Boolean {
        return true
    }
}
