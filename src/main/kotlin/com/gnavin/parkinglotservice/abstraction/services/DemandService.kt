package com.gnavin.parkinglotservice.abstraction.services
import com.gnavin.parkinglotservice.abstraction.dbmodels.Demand
import com.gnavin.parkinglotservice.abstraction.dto.DemandDto
import com.gnavin.parkinglotservice.abstraction.repositories.DemandRepository
import com.gnavin.parkinglotservice.converters.fromdto.FromDemandDto
import com.gnavin.parkinglotservice.delegator.BusinessHandlerDelegator
import com.gnavin.parkinglotservice.models.EntityType
import org.springframework.stereotype.Service
import java.util.*

@Service
class DemandService(private val businessHandlerDelegator: BusinessHandlerDelegator, private val demandRepository: DemandRepository) {

    fun findAllDemands(): List<Demand> {
        return demandRepository.findAllDemands()

    }
    fun saveDemand(type: EntityType, demandDtos: List<DemandDto>) {

        businessHandlerDelegator.handleDemands(type, demandDtos)

        demandDtos.filter { it.id.isNullOrBlank() }.forEach { it.id = UUID.randomUUID().toString() }
        val demands = FromDemandDto.batchConvert(demandDtos)
        demandRepository.saveAll(demands)
    }

     fun validate(demandId: String) {
        val denamdOpt: Optional<Demand> = demandRepository.findById(demandId)
        if (!denamdOpt.isPresent) {
            throw IllegalArgumentException("demandId is not valid")
        }
    }

}