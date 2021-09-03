
package com.gnavin.parkinglotservice.abstraction.dbmodels

import com.gnavin.parkinglotservice.models.EntityType
import org.springframework.data.annotation.Id
import org.springframework.data.domain.Persistable
import org.springframework.data.relational.core.mapping.Table

@Table("DEMAND")
data class Demand(@Id val _id:String, val type: EntityType, val entityAsJson: String): Persistable<String> {
    override fun getId(): String? {
        return _id
    }

    override fun isNew(): Boolean {
        return true
    }
}

