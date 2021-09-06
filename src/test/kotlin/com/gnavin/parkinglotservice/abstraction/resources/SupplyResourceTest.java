package com.gnavin.parkinglotservice.abstraction.resources;

import com.gnavin.parkinglotservice.abstraction.dto.SupplyDto;
import com.gnavin.parkinglotservice.abstraction.services.SupplyService;
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

public class SupplyResourceTest {
    @Mock
    SupplyService service;
    @InjectMocks
    SupplyResource supplyResource;

    @BeforeMethod
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAll() {
        List<SupplyDto> result = supplyResource.getAll();
        Assert.assertEquals(result, Arrays.<SupplyDto>asList(new SupplyDto("id", EntityType.PARKING_LOT, "entityAsJson")));
    }

    @Test
    public void testSaveSupplies() {
        GenericResponse result = supplyResource.saveSupplies("type", Arrays.<SupplyDto>asList(new SupplyDto("id", EntityType.PARKING_LOT, "entityAsJson")));
        Assert.assertEquals(result, new GenericResponse(0, "status", "message", ""));
    }

    @Test
    public void testGetService() {
        SupplyService result = supplyResource.getService();
        Assert.assertEquals(result, new SupplyService(new BusinessHandlerDelegator(new ParkingService(new ParkingAreaCrudHandler(null), new ParkingLotCrudHandler(new ParkingAreaCrudHandler(null), null), new ParkingLotAllocator(null, new ParkingLotSelector())), new VehicleService(null))));
    }
}

