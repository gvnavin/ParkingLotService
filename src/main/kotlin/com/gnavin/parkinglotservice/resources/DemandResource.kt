package com.gnavin.parkinglotservice.resources

import com.gnavin.parkinglotservice.dbmodels.Demand
import com.gnavin.parkinglotservice.models.EntityType
import com.gnavin.parkinglotservice.models.GenericResponse
import com.gnavin.parkinglotservice.services.DemandService
import org.springframework.web.bind.annotation.*

@RestController
class DemandResource(val service: DemandService) {

    @GetMapping("/demands")
    fun getAll(): List<Demand> {

        val allDemands = service.findAllDemands()
        println("allDemands = ${allDemands}")
        return allDemands
    }

    @PostMapping("/demand/type/{type}")
    fun saveSupplies(@PathVariable type: String, @RequestBody demands: List<Demand>): GenericResponse {
        println("type = ${type}")

        service.saveDemand(EntityType.valueOf(type.uppercase()), demands)
        return GenericResponse(200, "SUCCESS", "demands of type ${type} saved successfully")
    }

}