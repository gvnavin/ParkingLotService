package com.gnavin.parkinglotservice.abstraction.dbmodels

import org.springframework.data.annotation.Id
import org.springframework.data.domain.Persistable
import org.springframework.data.relational.core.mapping.Table

@Table("DISPATCH")
data class Dispatch(@Id val _id: String, val supplyId: String, val demandId:String, val startTimestamp:Long, var endTimestamp:Long) : Persistable<String> {

    override fun getId(): String? {
        return _id
    }

    override fun isNew(): Boolean {
        return true
    }
}

