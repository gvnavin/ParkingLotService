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
        println("allDispatches = ${allDispatches}")
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
    fun getDispatchesByFilters(@PathVariable type: String, @RequestParam(name = "color") color: String): List<DispatchDto> {
        return service.findDispatchesByFilters(EntityType.valueOf(type.uppercase()), color)
    }
}