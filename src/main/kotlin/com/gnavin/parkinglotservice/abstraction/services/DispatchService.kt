package com.gnavin.parkinglotservice.abstraction.services

import com.gnavin.parkinglotservice.abstraction.dbmodels.Demand
import com.gnavin.parkinglotservice.abstraction.dbmodels.Dispatch
import com.gnavin.parkinglotservice.abstraction.repositories.DemandRepository
import com.gnavin.parkinglotservice.abstraction.repositories.DispatchRepository
import com.gnavin.parkinglotservice.business.parking.respositories.ParkingLotRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class DispatchService(
    private val dispatchRepository: DispatchRepository,
    private val demandRepository: DemandRepository,
    private val parkingLotRepository: ParkingLotRepository
) {

    fun findAllDispatches(): List<Dispatch> {
        return dispatchRepository.findAllDispatches()
    }

    fun dispatchStart(demandId: String): Dispatch {
        validateDemand(demandId)

        val allAvailableParkingLotsByParkingArea = parkingLotRepository.findAvailableParkingLotsByParkingAreaId("pa1");
        val parkingLot = allAvailableParkingLotsByParkingArea.get(0)

        val dispatch = Dispatch(
            _id = UUID.randomUUID().toString(),
            supplyId = parkingLot.id!!,
            demandId = demandId,
            startTimestamp = System.currentTimeMillis(),
            endTimestamp = 0
        )

        val savedDispatch = dispatchRepository.save(dispatch)
        return savedDispatch
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