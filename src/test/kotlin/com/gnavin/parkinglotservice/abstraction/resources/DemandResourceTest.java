package com.gnavin.parkinglotservice.abstraction.resources;

import com.gnavin.parkinglotservice.abstraction.dbmodels.Demand;
import com.gnavin.parkinglotservice.abstraction.dto.DemandDto;
import com.gnavin.parkinglotservice.abstraction.services.DemandService;
import com.gnavin.parkinglotservice.business.parking.crud.ParkingAreaCrudHandler;
import com.gnavin.parkinglotservice.business.parking.crud.ParkingLotCrudHandler;
import com.gnavin.parkinglotservice.business.parking.handlers.ParkingLotAllocator;
import com.gnavin.parkinglotservice.business.parking.handlers.ParkingLotSelector;
import com.gnavin.parkinglotservice.business.parking.services.ParkingService;
import com.gnavin.parkinglotservice.business.vehicle.services.VehicleService;
import com.gnavin.parkinglotservice.delegator.BusinessHandlerDelegator;
import com.gnavin.parkinglotservice.models.EntityType;
import com.gnavin.parkinglotservice.models.GenericResponse;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

public class DemandResourceTest {
    @Mock
    DemandService service;
    @InjectMocks
    DemandResource demandResource;

    @BeforeMethod
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAll() {
        List<Demand> result = demandResource.getAll();
        Assert.assertEquals(result, Arrays.<Demand>asList(new Demand("_id", EntityType.PARKING_LOT, "entityId", "entityAsJson")));
    }

    @Test
    public void testPostBatchDemand() {
        GenericResponse result = demandResource.postBatchDemand("type", Arrays.<DemandDto>asList(new DemandDto("id", EntityType.PARKING_LOT, "entityAsJson")));
        Assert.assertEquals(result, new GenericResponse(0, "status", "message", ""));
    }

    @Test
    public void testGetService() {
        DemandService result = demandResource.getService();
        Assert.assertEquals(result, new DemandService(new BusinessHandlerDelegator(new ParkingService(new ParkingAreaCrudHandler(null), new ParkingLotCrudHandler(new ParkingAreaCrudHandler(null), null), new ParkingLotAllocator(null, new ParkingLotSelector())), new VehicleService(null)), null));
    }
}

