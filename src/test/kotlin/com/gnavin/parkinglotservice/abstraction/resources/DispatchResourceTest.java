package com.gnavin.parkinglotservice.abstraction.resources;

import com.gnavin.parkinglotservice.abstraction.dbmodels.Dispatch;
import com.gnavin.parkinglotservice.abstraction.dto.DispatchDto;
import com.gnavin.parkinglotservice.abstraction.services.DemandService;
import com.gnavin.parkinglotservice.abstraction.services.DispatchService;
import com.gnavin.parkinglotservice.business.parking.crud.ParkingAreaCrudHandler;
import com.gnavin.parkinglotservice.business.parking.crud.ParkingLotCrudHandler;
import com.gnavin.parkinglotservice.business.parking.handlers.ParkingLotAllocator;
import com.gnavin.parkinglotservice.business.parking.handlers.ParkingLotSelector;
import com.gnavin.parkinglotservice.business.parking.services.ParkingService;
import com.gnavin.parkinglotservice.business.vehicle.services.VehicleService;
import com.gnavin.parkinglotservice.delegator.BusinessHandlerDelegator;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

public class DispatchResourceTest {
    @Mock
    DispatchService service;
    @InjectMocks
    DispatchResource dispatchResource;

    @BeforeMethod
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAll() {
        List<Dispatch> result = dispatchResource.getAll();
        Assert.assertEquals(result, Arrays.<Dispatch>asList(new Dispatch("_id", "supplyId", "demandId", 0L, 0L)));
    }

    @Test
    public void testDispatchStart() {
        Dispatch result = dispatchResource.dispatchStart("demandId");
        Assert.assertEquals(result, new Dispatch("_id", "supplyId", "demandId", 0L, 0L));
    }

    @Test
    public void testDispatchDone() {
        Dispatch result = dispatchResource.dispatchDone("dispatchId");
        Assert.assertEquals(result, new Dispatch("_id", "supplyId", "demandId", 0L, 0L));
    }

    @Test
    public void testGetDispatchesByFilters() {
        List<DispatchDto> result = dispatchResource.getDispatchesByFilters("type", "requiredEntityType", "filterKey1", "filterValue1");
        Assert.assertEquals(result, Arrays.<DispatchDto>asList(new DispatchDto("id", "supplyId", "demandId", 0L, 0L, "entityAsJson")));
    }

    @Test
    public void testGetService() {
        DispatchService result = dispatchResource.getService();
        Assert.assertEquals(result, new DispatchService(null, new DemandService(new BusinessHandlerDelegator(new ParkingService(new ParkingAreaCrudHandler(null), new ParkingLotCrudHandler(new ParkingAreaCrudHandler(null), null), new ParkingLotAllocator(null, new ParkingLotSelector())), new VehicleService(null)), null), new BusinessHandlerDelegator(new ParkingService(new ParkingAreaCrudHandler(null), new ParkingLotCrudHandler(new ParkingAreaCrudHandler(null), null), new ParkingLotAllocator(null, new ParkingLotSelector())), new VehicleService(null))));
    }
}

