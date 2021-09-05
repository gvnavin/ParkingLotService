package com.gnavin.parkinglotservice.abstraction.services;

import com.gnavin.parkinglotservice.abstraction.dto.SupplyDto;
import com.gnavin.parkinglotservice.delegator.BusinessHandlerDelegator;
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

public class SupplyServiceTest {
    @Mock
    BusinessHandlerDelegator businessHandlerDelegator;
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

