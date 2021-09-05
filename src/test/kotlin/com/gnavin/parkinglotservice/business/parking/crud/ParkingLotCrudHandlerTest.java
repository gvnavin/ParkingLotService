package com.gnavin.parkinglotservice.business.parking.crud;

import com.gnavin.parkinglotservice.abstraction.dto.ParkingLotDto;
import com.gnavin.parkinglotservice.abstraction.dto.SupplyDto;
import com.gnavin.parkinglotservice.business.parking.respositories.ParkingLotRepository;
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

public class ParkingLotCrudHandlerTest {
    @Mock
    ParkingAreaCrudHandler parkingAreaCrudHandler;
    @Mock
    ParkingLotRepository parkingLotRepository;
    @InjectMocks
    ParkingLotCrudHandler parkingLotCrudHandler;

    @BeforeMethod
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSave() {
        parkingLotCrudHandler.save(Arrays.<SupplyDto>asList(new SupplyDto("id", EntityType.PARKING_LOT, "entityAsJson")));
    }

    @Test
    public void testFindAllLotsWithParkingArea() {
        List<SupplyDto> result = parkingLotCrudHandler.findAllLotsWithParkingArea();
        Assert.assertEquals(result, Arrays.<SupplyDto>asList(new SupplyDto("id", EntityType.PARKING_LOT, "entityAsJson")));
    }

    @Test
    public void testFindParkingLotByParkedVehicleId() {
        List<ParkingLotDto> result = parkingLotCrudHandler.findParkingLotByParkedVehicleId("id");
        Assert.assertEquals(result, Arrays.<ParkingLotDto>asList(new ParkingLotDto("id", "parkingAreaId", "location", "owner")));
    }

    @Test
    public void testFindParkingLotByParkedVehicleColor() {
        List<ParkingLotDto> result = parkingLotCrudHandler.findParkingLotByParkedVehicleColor("color");
        Assert.assertEquals(result, Arrays.<ParkingLotDto>asList(new ParkingLotDto("id", "parkingAreaId", "location", "owner")));
    }
}

