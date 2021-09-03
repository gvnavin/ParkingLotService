package com.gnavin.parkinglotservice.configurations

import com.gnavin.parkinglotservice.business.parking.dbmodels.ParkingArea
import com.gnavin.parkinglotservice.business.parking.dbmodels.ParkingLot
import com.gnavin.parkinglotservice.business.parking.respositories.ParkingAreaRepository
import com.gnavin.parkinglotservice.business.parking.respositories.ParkingLotRepository
import com.gnavin.parkinglotservice.business.vehicle.dbmodels.Vehicle
import com.gnavin.parkinglotservice.business.vehicle.respositories.VehicleRepository
import com.gnavin.parkinglotservice.abstraction.dbmodels.*
import com.gnavin.parkinglotservice.models.EntityType
import com.gnavin.parkinglotservice.abstraction.repositories.*
import com.google.gson.Gson
import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ParkingConfiguration {
    @Bean
    fun databaseInitializer(parkingLotRepository: ParkingLotRepository,
                            parkingAreaRepository: ParkingAreaRepository,
                            vehicleRepository: VehicleRepository,
                            demandRepository: DemandRepository,
                            dispatchRepository: DispatchRepository
    ) = ApplicationRunner {

        //-------------------- PARKING AREA --------------------

        val parkingArea = ParkingArea("pa_1", "Pheonix mall, Chennai", "Owner")
        val pa1 = parkingAreaRepository.save(parkingArea)

        println("parkingArea = ${parkingArea}")
        println("pa1 = ${pa1}")

        //-------------------- PARKING LOT --------------------

        val pl1 = parkingLotRepository.save(ParkingLot("pl1", parkingArea.getId()!!))
        val pl2 = parkingLotRepository.save(ParkingLot("pl2", parkingArea.getId()!!))
        val pl3 = parkingLotRepository.save(ParkingLot("pl3", parkingArea.getId()!!))

        println("pl1 = ${pl1}")
        println("pl2 = ${pl2}")
        println("pl3 = ${pl3}")

        //-------------------- VEHICLE --------------------

        val vehicle1 = Vehicle("TN20B1234", "Foo_owner", "black")
        val savedVehicle1 = vehicleRepository.save(vehicle1)

        println("vehicle1 = ${vehicle1}")
        println("savedVehicle1 = ${savedVehicle1}")

        var gson = Gson()
        val vehicle1toJson = gson.toJson(savedVehicle1)
        println("vehicle1toJson = ${vehicle1toJson}")

        //-------------------- DEMAND --------------------

        val demand1 = Demand("demand_1", EntityType.PARKING_LOT, vehicle1toJson)
        val demand2 = Demand("demand_2", EntityType.PARKING_LOT, vehicle1toJson)

        val savedDemand1 = demandRepository.save(demand1)
        val savedDemand2 = demandRepository.save(demand2)

        println("demand = ${demand1}")
        println("demand = ${demand2}")

        println("savedDemand1 = ${savedDemand1}")
        println("savedDemand2 = ${savedDemand2}")

        //-------------------- DISPATCH --------------------

        val dispatch1 = Dispatch("dispatch_1", pl1.id!!, demand1.id!!, 1630644737, 0)
        val dispatch2 = Dispatch("dispatch_2", pl2.id!!, demand1.id!!, 1630644737, 1630644740)

        val savedDispatch1 = dispatchRepository.save(dispatch1)
        val savedDispatch2 = dispatchRepository.save(dispatch2)

        println("dispatch1 = ${dispatch1}")
        println("dispatch2 = ${dispatch2}")

        println("savedDispatch1 = ${savedDispatch1}")
        println("savedDispatch2 = ${savedDispatch2}")
    }
}