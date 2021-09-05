package com.gnavin.parkinglotservice.delegator;

import com.gnavin.parkinglotservice.abstraction.dbmodels.Demand;
import com.gnavin.parkinglotservice.abstraction.dto.DemandDto;
import com.gnavin.parkinglotservice.abstraction.dto.DispatchDto;
import com.gnavin.parkinglotservice.abstraction.dto.SupplyDto;
import com.gnavin.parkinglotservice.business.parking.crud.ParkingAreaCrudHandler;
import com.gnavin.parkinglotservice.business.parking.crud.ParkingLotCrudHandler;
import com.gnavin.parkinglotservice.business.parking.handlers.ParkingLotAllocator;
import com.gnavin.parkinglotservice.business.parking.handlers.ParkingLotSelector;
import com.gnavin.parkinglotservice.business.parking.services.ParkingService;
import com.gnavin.parkinglotservice.business.vehicle.services.VehicleService;
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

public class BusinessHandlerDelegatorTest {
    @Mock
    ParkingService parkingService;
    @Mock
    VehicleService vehicleService;
    @InjectMocks
    BusinessHandlerDelegator businessHandlerDelegator;

    @BeforeMethod
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testHandleSupply() {
        businessHandlerDelegator.handleSupply(EntityType.PARKING_LOT, Arrays.<SupplyDto>asList(new SupplyDto("id", EntityType.PARKING_LOT, "entityAsJson")));
    }

    @Test
    public void testHandleDemands() {
        businessHandlerDelegator.handleDemands(EntityType.PARKING_LOT, Arrays.<DemandDto>asList(new DemandDto("id", EntityType.PARKING_LOT, "entityAsJson")));
    }

    @Test
    public void testHandleDispatchStart() {
        String result = businessHandlerDelegator.handleDispatchStart("parkingAreaId", new Demand("_id", EntityType.PARKING_LOT, "entityId", "entityAsJson"));
        Assert.assertEquals(result, "replaceMeWithExpectedResult");
    }

    @Test
    public void testFindAllSupplies() {
        List<SupplyDto> result = businessHandlerDelegator.findAllSupplies();
        Assert.assertEquals(result, Arrays.<SupplyDto>asList(new SupplyDto("id", EntityType.PARKING_LOT, "entityAsJson")));
    }

    @Test
    public void testHandleFindDispatchesByFilters() {
        List<DispatchDto> result = businessHandlerDelegator.handleFindDispatchesByFilters(EntityType.PARKING_LOT, EntityType.PARKING_LOT, "filterKey1", "filterValue1");
        Assert.assertEquals(result, Arrays.<DispatchDto>asList(new DispatchDto("id", "supplyId", "demandId", 0L, 0L, "entityAsJson")));
    }

    @Test
    public void testGetParkingService() {
        ParkingService result = businessHandlerDelegator.getParkingService();
        Assert.assertEquals(result, new ParkingService(new ParkingAreaCrudHandler(null), new ParkingLotCrudHandler(new ParkingAreaCrudHandler(null), null), new ParkingLotAllocator(null, new ParkingLotSelector())));
    }

    @Test
    public void testGetVehicleService() {
        VehicleService result = businessHandlerDelegator.getVehicleService();
        Assert.assertEquals(result, new VehicleService(null));
    }
}

