package com.gnavin.parkinglotservice.abstraction.services

import com.gnavin.parkinglotservice.abstraction.dbmodels.Demand
import com.gnavin.parkinglotservice.abstraction.dbmodels.Dispatch
import com.gnavin.parkinglotservice.abstraction.repositories.DemandRepository
import com.gnavin.parkinglotservice.abstraction.repositories.DispatchRepository
import com.gnavin.parkinglotservice.factories.BusinessHandlerDelegator
import com.gnavin.parkinglotservice.models.EntityType
import org.springframework.stereotype.Service
import java.util.*

@Service
class DispatchService(
    private val dispatchRepository: DispatchRepository,
    private val demandRepository: DemandRepository,
    private val businessHandlerDelegator: BusinessHandlerDelegator
) {

    fun findAllDispatches(): List<Dispatch> {
        return dispatchRepository.findAllDispatches()
    }

    fun dispatchStart(demandId: String): Dispatch {
        validateDemand(demandId)

        val parkingAreaId = "pa1"

        val supplyId = businessHandlerDelegator.handleDispatchStart(
            parkingAreaId,
            Demand(parkingAreaId, EntityType.PARKING_AREA, "")
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

    private fun validateDemand(demandId: String) {
        val denamdOpt: Optional<Demand> = demandRepository.findById(demandId)
        if (!denamdOpt.isPresent) {
            throw IllegalArgumentException("demandId is not valid")
        }
    }
}