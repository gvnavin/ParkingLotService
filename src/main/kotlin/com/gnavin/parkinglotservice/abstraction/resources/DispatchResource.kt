package com.gnavin.parkinglotservice.abstraction.resources

import com.gnavin.parkinglotservice.abstraction.dbmodels.Dispatch
import com.gnavin.parkinglotservice.abstraction.dto.DispatchDto
import com.gnavin.parkinglotservice.abstraction.services.DispatchService
import com.gnavin.parkinglotservice.models.EntityType
import org.springframework.web.bind.annotation.*

@RestController
class DispatchResource(val service: DispatchService) {

    @GetMapping("/dispatches")
    fun getAll(): List<Dispatch> {

        val allDispatches = service.findAllDispatches()
        println("DispatchResource.getAll allDispatches = ${allDispatches}")
        return allDispatches
    }

    @PostMapping("/dispatch/start/demandId/{demandId}")
    fun dispatchStart(@PathVariable demandId: String): Dispatch {
        return service.dispatchStart(demandId)
    }

    @PostMapping("/dispatch/done/dispatchId/{dispatchId}")
    fun dispatchDone(@PathVariable dispatchId: String): Dispatch {
        return service.dispatchDone(dispatchId)
    }

    @GetMapping("/dispatch/start/type/{type}")
    fun getDispatchesByFilters(
        @PathVariable type: String,
        @RequestParam(name = "requiredEntityType") requiredEntityType: String,
        @RequestParam(name = "filterKey1") filterKey1: String,
        @RequestParam(name = "filterValue1") filterValue1: String
    ): List<DispatchDto> {

        println(
            "DispatchResource.getDispatchesByFilters type = [${type}], " +
                    "requiredEntityType = [${requiredEntityType}], " +
                    "filterKey1 = [${filterKey1}], " +
                    "filterValue1 = [${filterValue1}]"
        )

        val enumType = EntityType.valueOf(type.uppercase())
        val enumRequiredEntityType = EntityType.valueOf(requiredEntityType.uppercase())


        return service.findDispatchesByFilters(
            enumType, enumRequiredEntityType, filterKey1, filterValue1
        )
    }
}