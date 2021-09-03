package com.gnavin.parkinglotservice.abstraction.dto

import com.gnavin.parkinglotservice.models.EntityType

data class DemandDto(var id:String, val type: EntityType, val entityAsJson: String)
