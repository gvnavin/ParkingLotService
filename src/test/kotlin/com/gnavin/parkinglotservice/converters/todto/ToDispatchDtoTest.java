package com.gnavin.parkinglotservice.converters.todto;

import com.gnavin.parkinglotservice.abstraction.dto.DispatchDto;
import com.gnavin.parkinglotservice.abstraction.dto.ParkingLotDto;
import com.gnavin.parkinglotservice.business.vehicle.dbmodels.Vehicle;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class ToDispatchDtoTest {
    ToDispatchDto toDispatchDto = null;

    @Test
    public void testBatchConvertVehicles() {
        List<DispatchDto> result = toDispatchDto.batchConvertVehicles(Arrays.<Vehicle>asList(new Vehicle("_id", "owner", "color")));
        Assert.assertEquals(result, Arrays.<DispatchDto>asList(new DispatchDto("id", "supplyId", "demandId", 0L, 0L, "entityAsJson")));
    }

    @Test
    public void testBatchConvertParkingLotDtos() {
        List<DispatchDto> result = toDispatchDto.batchConvertParkingLotDtos(Arrays.<ParkingLotDto>asList(new ParkingLotDto("id", "parkingAreaId", "location", "owner")));
        Assert.assertEquals(result, Arrays.<DispatchDto>asList(new DispatchDto("id", "supplyId", "demandId", 0L, 0L, "entityAsJson")));
    }
}

