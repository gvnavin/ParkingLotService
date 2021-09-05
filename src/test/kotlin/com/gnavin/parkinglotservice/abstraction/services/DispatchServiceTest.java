package com.gnavin.parkinglotservice.abstraction.services;

import com.gnavin.parkinglotservice.abstraction.dbmodels.Dispatch;
import com.gnavin.parkinglotservice.abstraction.dto.DispatchDto;
import com.gnavin.parkinglotservice.abstraction.repositories.DispatchRepository;
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

public class DispatchServiceTest {
    @Mock
    DispatchRepository dispatchRepository;
    @Mock
    DemandService demandService;
    @Mock
    BusinessHandlerDelegator businessHandlerDelegator;
    @InjectMocks
    DispatchService dispatchService;

    @BeforeMethod
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindAllDispatches() {
        List<Dispatch> result = dispatchService.findAllDispatches();
        Assert.assertEquals(result, Arrays.<Dispatch>asList(new Dispatch("_id", "supplyId", "demandId", 0L, 0L)));
    }

    @Test
    public void testDispatchStart() {
        Dispatch result = dispatchService.dispatchStart("demandId");
        Assert.assertEquals(result, new Dispatch("_id", "supplyId", "demandId", 0L, 0L));
    }

    @Test
    public void testDispatchDone() {
        Dispatch result = dispatchService.dispatchDone("dispatchId");
        Assert.assertEquals(result, new Dispatch("_id", "supplyId", "demandId", 0L, 0L));
    }

    @Test
    public void testFindDispatchesByFilters() {
        List<DispatchDto> result = dispatchService.findDispatchesByFilters(EntityType.PARKING_LOT, EntityType.PARKING_LOT, "filterKey1", "filterValue1");
        Assert.assertEquals(result, Arrays.<DispatchDto>asList(new DispatchDto("id", "supplyId", "demandId", 0L, 0L, "entityAsJson")));
    }
}

