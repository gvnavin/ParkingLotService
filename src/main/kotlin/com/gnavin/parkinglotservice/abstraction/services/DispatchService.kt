package com.gnavin.parkinglotservice.abstraction.services

import com.gnavin.parkinglotservice.abstraction.dbmodels.Demand
import com.gnavin.parkinglotservice.abstraction.dbmodels.Dispatch
import com.gnavin.parkinglotservice.abstraction.dto.DispatchDto
import com.gnavin.parkinglotservice.abstraction.repositories.DispatchRepository
import com.gnavin.parkinglotservice.delegator.BusinessHandlerDelegator
import com.gnavin.parkinglotservice.models.EntityType
import org.springframework.stereotype.Service
import java.util.*

@Service
class DispatchService(
    private val dispatchRepository: DispatchRepository,
    private val demandService: DemandService,
    private val businessHandlerDelegator: BusinessHandlerDelegator
) {

    fun findAllDispatches(): List<Dispatch> {
        return dispatchRepository.findAllDispatches()
    }

    fun dispatchStart(demandId: String): Dispatch {
        demandService.validate(demandId)

        val parkingAreaId = "pa1"

        val supplyId = businessHandlerDelegator.handleDispatchStart(
            parkingAreaId,
            Demand(parkingAreaId, EntityType.PARKING_AREA, "", "")
        )

        val dispatch = Dispatch(
            _id = UUID.randomUUID().toString(),
            supplyId = supplyId,
            demandId = demandId,
            startTimestamp = System.currentTimeMillis(),
            endTimestamp = 0
        )

        return dispatchRepository.save(dispatch)
    }

    fun dispatchDone(dispatchId: String): Dispatch {
        dispatchRepository.updateEndTimestamp(dispatchId, System.currentTimeMillis())

        val dispatchOpt: Optional<Dispatch> = dispatchRepository.findById(dispatchId)
        if (!dispatchOpt.isPresent) {
            throw IllegalArgumentException("dispatchId is not valid")
        }

        return dispatchOpt.get()
    }

    fun findDispatchesByFilters(type: EntityType, requiredEntityType: EntityType, filterKey1: String, filterValue1: String): List<DispatchDto> {
        return businessHandlerDelegator.handleFindDispatchesByFilters(type, requiredEntityType, filterKey1, filterValue1);
    }
}