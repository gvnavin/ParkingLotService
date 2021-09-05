package com.gnavin.parkinglotservice.business.parking.handlers;

import com.gnavin.parkinglotservice.abstraction.dbmodels.Demand;
import com.gnavin.parkinglotservice.business.parking.dbmodels.ParkingLot;
import com.gnavin.parkinglotservice.business.parking.respositories.ParkingLotRepository;
import com.gnavin.parkinglotservice.models.EntityType;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.mockito.Mockito.*;

public class ParkingLotAllocatorTest {
    @Mock
    ParkingLotRepository parkingLotRepository;
    @Mock
    ParkingLotSelector parkingLotSelector;
    @InjectMocks
    ParkingLotAllocator parkingLotAllocator;

    @BeforeMethod
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAllocate() {
        ParkingLot result = parkingLotAllocator.allocate("parkingAreaId", new Demand("_id", EntityType.PARKING_LOT, "entityId", "entityAsJson"));
        Assert.assertEquals(result, new ParkingLot("_id", "parkingAreaId"));
    }
}

