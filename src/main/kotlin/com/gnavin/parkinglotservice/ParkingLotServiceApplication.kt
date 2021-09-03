package com.gnavin.parkinglotservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ParkingLotServiceApplication

fun main(args: Array<String>) {
    try {
        runApplication<ParkingLotServiceApplication>(*args)
    } catch (e: Exception) {
        println("e = ${e}")
        println(e.message)
        e.printStackTrace()
    }
}
