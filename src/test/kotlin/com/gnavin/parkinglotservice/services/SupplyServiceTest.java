package com.gnavin.parkinglotservice.services;

import com.gnavin.parkinglotservice.abstraction.services.SupplyService;
import com.gnavin.parkinglotservice.models.EntityType;
import com.gnavin.parkinglotservice.abstraction.dto.SupplyDto;
import com.gnavin.parkinglotservice.business.parking.respositories.ParkingAreaRepository;
import com.gnavin.parkinglotservice.business.parking.respositories.ParkingLotRepository;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class SupplyServiceTest {
    @Mock
    ParkingLotRepository parkingLotRepository;
    @Mock
    ParkingAreaRepository parkingAreaRepository;
    @InjectMocks
    SupplyService supplyService;

    @BeforeMethod
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindAllSupplies() {
        List<SupplyDto> result = supplyService.findAllSupplies();
        Assert.assertEquals(result, Arrays.<SupplyDto>asList(new SupplyDto("id", EntityType.PARKING_LOT, "entityAsJson")));
    }

    @Test
    public void testSaveSupplies() {
        supplyService.saveSupplies(EntityType.PARKING_LOT, Arrays.<SupplyDto>asList(new SupplyDto("id", EntityType.PARKING_LOT, "entityAsJson")));
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme