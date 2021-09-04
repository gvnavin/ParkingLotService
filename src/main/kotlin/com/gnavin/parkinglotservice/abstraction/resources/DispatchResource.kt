package com.gnavin.parkinglotservice.abstraction.resources

import com.gnavin.parkinglotservice.abstraction.dbmodels.Dispatch
import com.gnavin.parkinglotservice.abstraction.services.DispatchService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

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
}