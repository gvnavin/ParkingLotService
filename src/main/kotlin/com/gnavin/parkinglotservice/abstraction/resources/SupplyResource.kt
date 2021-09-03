package com.gnavin.parkinglotservice.abstraction.resources

import com.gnavin.parkinglotservice.models.EntityType
import com.gnavin.parkinglotservice.models.GenericResponse
import com.gnavin.parkinglotservice.abstraction.dto.SupplyDto
import com.gnavin.parkinglotservice.abstraction.services.SupplyService
import org.springframework.web.bind.annotation.*


@RestController
class SupplyResource(val service: SupplyService) {

    @GetMapping("/supplies")
    fun getAll(): List<SupplyDto> {

        val allSupplies = service.findAllSupplies()
        println("allSupplies = ${allSupplies}")
        return allSupplies;
    }

    @PostMapping("/supplies/type/{type}")
    fun saveSupplies(@PathVariable type: String, @RequestBody supplies: List<SupplyDto>): GenericResponse {
        println("type = ${type}")

        service.saveSupplies(EntityType.valueOf(type.uppercase()), supplies)
        return GenericResponse(200, "SUCCESS", "supplies of type ${type} saved successfully")
    }
}