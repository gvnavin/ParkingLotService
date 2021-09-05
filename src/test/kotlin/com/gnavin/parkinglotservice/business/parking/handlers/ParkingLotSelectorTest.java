package com.gnavin.parkinglotservice.business.parking.handlers;

import com.gnavin.parkinglotservice.business.parking.dbmodels.ParkingLot;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class ParkingLotSelectorTest {
    ParkingLotSelector parkingLotSelector = new ParkingLotSelector();

    @Test
    public void testSelect() {
        ParkingLot result = parkingLotSelector.select(Arrays.<ParkingLot>asList(new ParkingLot("_id", "parkingAreaId")));
        Assert.assertEquals(result, new ParkingLot("_id", "parkingAreaId"));
    }

    @Test
    public void testGetStrategy() {
        ParkingLotSelectionStrategy result = parkingLotSelector.getStrategy();
        Assert.assertEquals(result, new ParkingLotDistanceBasedStrategy());
    }
}

