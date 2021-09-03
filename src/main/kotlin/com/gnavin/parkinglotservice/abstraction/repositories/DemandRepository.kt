package com.gnavin.parkinglotservice.abstraction.repositories

import com.gnavin.parkinglotservice.abstraction.dbmodels.Demand
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository

interface DemandRepository: CrudRepository<Demand, String> {

    @Query("select * from DEMAND")
    fun findAllDemands(): List<Demand>
}