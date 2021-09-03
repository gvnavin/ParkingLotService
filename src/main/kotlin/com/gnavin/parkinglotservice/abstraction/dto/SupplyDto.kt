package com.gnavin.parkinglotservice.abstraction.dto

import com.gnavin.parkinglotservice.models.EntityType

data class SupplyDto(var id:String?, val type: EntityType, val entityAsJson: String)
