package com.gnavin.parkinglotservice.business.parking.services;

import com.gnavin.parkinglotservice.abstraction.dbmodels.Demand;
import com.gnavin.parkinglotservice.abstraction.dto.ParkingLotDto;
import com.gnavin.parkinglotservice.abstraction.dto.SupplyDto;
import com.gnavin.parkinglotservice.business.parking.crud.ParkingAreaCrudHandler;
import com.gnavin.parkinglotservice.business.parking.crud.ParkingLotCrudHandler;
import com.gnavin.parkinglotservice.business.parking.handlers.ParkingLotAllocator;
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

public class ParkingServiceTest {
    @Mock
    ParkingAreaCrudHandler parkingAreaCrudHandler;
    @Mock
    ParkingLotCrudHandler parkingLotCrudHandler;
    @Mock
    ParkingLotAllocator parkingLotAllocator;
    @InjectMocks
    ParkingService parkingService;

    @BeforeMethod
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindAllSupplies() {
        List<SupplyDto> result = parkingService.findAllSupplies();
        Assert.assertEquals(result, Arrays.<SupplyDto>asList(new SupplyDto("id", EntityType.PARKING_LOT, "entityAsJson")));
    }

    @Test
    public void testSaveSupplies() {
        parkingService.saveSupplies(EntityType.PARKING_LOT, Arrays.<SupplyDto>asList(new SupplyDto("id", EntityType.PARKING_LOT, "entityAsJson")));
    }

    @Test
    public void testFindSuitableAvailableParkingLotByParkingAreaId() {
        String result = parkingService.findSuitableAvailableParkingLotByParkingAreaId("parkingAreaId", new Demand("_id", EntityType.PARKING_LOT, "entityId", "entityAsJson"));
        Assert.assertEquals(result, "replaceMeWithExpectedResult");
    }

    @Test
    public void testFindParkingLotByParkedVehicleId() {
        List<ParkingLotDto> result = parkingService.findParkingLotByParkedVehicleId("id");
        Assert.assertEquals(result, Arrays.<ParkingLotDto>asList(new ParkingLotDto("id", "parkingAreaId", "location", "owner")));
    }

    @Test
    public void testFindParkingLotByParkedVehicleColor() {
        List<ParkingLotDto> result = parkingService.findParkingLotByParkedVehicleColor("color");
        Assert.assertEquals(result, Arrays.<ParkingLotDto>asList(new ParkingLotDto("id", "parkingAreaId", "location", "owner")));
    }
}

