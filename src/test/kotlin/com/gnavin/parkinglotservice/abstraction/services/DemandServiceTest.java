package com.gnavin.parkinglotservice.abstraction.services;

import com.gnavin.parkinglotservice.abstraction.dbmodels.Demand;
import com.gnavin.parkinglotservice.abstraction.dto.DemandDto;
import com.gnavin.parkinglotservice.abstraction.repositories.DemandRepository;
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

public class DemandServiceTest {
    @Mock
    BusinessHandlerDelegator businessHandlerDelegator;
    @Mock
    DemandRepository demandRepository;
    @InjectMocks
    DemandService demandService;

    @BeforeMethod
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindAllDemands() {
        List<Demand> result = demandService.findAllDemands();
        Assert.assertEquals(result, Arrays.<Demand>asList(new Demand("_id", EntityType.PARKING_LOT, "entityId", "entityAsJson")));
    }

    @Test
    public void testSaveDemand() {
        demandService.saveDemand(EntityType.PARKING_LOT, Arrays.<DemandDto>asList(new DemandDto("id", EntityType.PARKING_LOT, "entityAsJson")));
    }

    @Test
    public void testValidate() {
        demandService.validate("demandId");
    }
}

