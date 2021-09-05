package com.gnavin.parkinglotservice.configurations;

import org.springframework.boot.ApplicationRunner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ParkingConfigurationTest {
    ParkingConfiguration parkingConfiguration = new ParkingConfiguration();

    @Test
    public void testDatabaseInitializer() {
        ApplicationRunner result = parkingConfiguration.databaseInitializer(null, null, null, null, null);
        Assert.assertEquals(result, null);
    }
}

