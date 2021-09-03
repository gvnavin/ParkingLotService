package com.gnavin.parkinglotservice.repositories

import com.gnavin.parkinglotservice.dbmodels.Dispatch
import org.springframework.data.jdbc.repository.query.Modifying
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param

interface DispatchRepository: CrudRepository<Dispatch, String> {

    @Query("SELECT * FROM DISPATCH")
    fun findAllDispatches(): List<Dispatch>

    @Modifying
    @Query("UPDATE DISPATCH U SET U.END_TIMESTAMP = :endTimestamp WHERE U._ID = :id")
    fun updateEndTimestamp(@Param(value = "id") id: String, @Param(value = "endTimestamp") endTimestamp: Long)
}