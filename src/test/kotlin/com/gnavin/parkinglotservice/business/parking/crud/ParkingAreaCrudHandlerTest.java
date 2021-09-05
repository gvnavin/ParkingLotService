package com.gnavin.parkinglotservice.business.parking.crud;

import com.gnavin.parkinglotservice.abstraction.dto.SupplyDto;
import com.gnavin.parkinglotservice.business.parking.dbmodels.ParkingArea;
import com.gnavin.parkinglotservice.business.parking.respositories.ParkingAreaRepository;
import com.gnavin.parkinglotservice.models.EntityType;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.mockito.Mockito.*;

public class ParkingAreaCrudHandlerTest {
    @Mock
    ParkingAreaRepository parkingAreaRepository;
    @InjectMocks
    ParkingAreaCrudHandler parkingAreaCrudHandler;

    @BeforeMethod
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSave() {
        parkingAreaCrudHandler.save(Arrays.<SupplyDto>asList(new SupplyDto("id", EntityType.PARKING_LOT, "entityAsJson")));
    }

    @Test
    public void testFindParkingAreaById() {
        ParkingArea result = parkingAreaCrudHandler.findParkingAreaById("id");
        Assert.assertEquals(result, new ParkingArea("_id", "location", "owner"));
    }
}

