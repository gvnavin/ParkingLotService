package com.gnavin.parkinglotservice.abstraction.resources

import com.gnavin.parkinglotservice.abstraction.dbmodels.Demand
import com.gnavin.parkinglotservice.abstraction.dto.DemandDto
import com.gnavin.parkinglotservice.abstraction.services.DemandService
import com.gnavin.parkinglotservice.models.EntityType
import com.gnavin.parkinglotservice.models.GenericResponse
import com.google.gson.Gson
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
class DemandResource(val service: DemandService) {

    @GetMapping("/demands")
    fun getAll(): List<Demand> {

        val allDemands = service.findAllDemands()
        println("DemandResource.getAll allDemands = ${allDemands}")
        return allDemands
    }

    @PostMapping("/demand/type/{type}")
    fun postBatchDemand(@PathVariable type: String, @RequestBody demandDtos: List<DemandDto>): GenericResponse {
        println("DemandResource.postBatchDemand type = ${type}")

        demandDtos.filter { it.id.isNullOrBlank() }.forEach { it.id = UUID.randomUUID().toString() }
        println("SupplyResource.saveSupplies supplies = ${demandDtos}")

        service.saveDemand(EntityType.valueOf(type.uppercase()), demandDtos)
        return GenericResponse(200, "SUCCESS",
            "demands of type ${type} saved successfully",
            Gson().toJson(demandDtos)
        )
    }

}