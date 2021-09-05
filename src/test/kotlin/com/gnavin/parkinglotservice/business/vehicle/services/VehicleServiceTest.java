package com.gnavin.parkinglotservice.business.vehicle.services;

import com.gnavin.parkinglotservice.abstraction.dto.DemandDto;
import com.gnavin.parkinglotservice.business.vehicle.dbmodels.Vehicle;
import com.gnavin.parkinglotservice.business.vehicle.respositories.VehicleRepository;
import com.gnavin.parkinglotservice.models.EntityType;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

public class VehicleServiceTest {
    @Mock
    VehicleRepository vehicleRepository;
    @InjectMocks
    VehicleService vehicleService;

    @BeforeMethod
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSaveAll() {
        vehicleService.saveAll(Arrays.<DemandDto>asList(new DemandDto("id", EntityType.PARKING_LOT, "entityAsJson")));
    }

    @Test
    public void testFindVehiclesInParkingLotWithColor() {
        List<Vehicle> result = vehicleService.findVehiclesInParkingLotWithColor("color");
        Assert.assertEquals(result, Arrays.<Vehicle>asList(new Vehicle("_id", "owner", "color")));
    }
}

