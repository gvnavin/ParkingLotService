package com.gnavin.parkinglotservice.converters.fromdto

import com.gnavin.parkinglotservice.abstraction.dbmodels.Demand
import com.gnavin.parkinglotservice.abstraction.dto.DemandDto

object FromDemandDto {

    fun batchConvert(demandDtos: List<DemandDto>): List<Demand> {
        return demandDtos.map { Demand(it.id!!, it.type, it.entityAsJson) }
    }

}