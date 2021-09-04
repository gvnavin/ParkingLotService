package com.gnavin.parkinglotservice.abstraction.services

import com.gnavin.parkinglotservice.abstraction.dto.SupplyDto
import com.gnavin.parkinglotservice.factories.BusinessHandlerDelegator
import com.gnavin.parkinglotservice.models.EntityType
import org.springframework.stereotype.Service

@Service
class SupplyService(private val businessHandlerDelegator: BusinessHandlerDelegator) {

    fun findAllSupplies(): List<SupplyDto> {
       return businessHandlerDelegator.findAllSupplies()
    }

    fun saveSupplies(type: EntityType, supplies: List<SupplyDto>) {
       businessHandlerDelegator.handleSupply(type, supplies)
    }

}