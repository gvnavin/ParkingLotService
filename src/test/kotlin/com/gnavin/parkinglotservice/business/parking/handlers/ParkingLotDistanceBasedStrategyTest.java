package com.gnavin.parkinglotservice.business.parking.handlers;

import com.gnavin.parkinglotservice.business.parking.dbmodels.ParkingLot;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class ParkingLotDistanceBasedStrategyTest {
    ParkingLotDistanceBasedStrategy parkingLotDistanceBasedStrategy = new ParkingLotDistanceBasedStrategy();

    @Test
    public void testCompute() {
        int result = parkingLotDistanceBasedStrategy.compute("entry", new ParkingLot("_id", "parkingAreaId"));
        Assert.assertEquals(result, 0);
    }

    @Test
    public void testFindMinimumDistanceLot() {
        ParkingLot result = parkingLotDistanceBasedStrategy.findMinimumDistanceLot(Arrays.<ParkingLot>asList(new ParkingLot("_id", "parkingAreaId")));
        Assert.assertEquals(result, new ParkingLot("_id", "parkingAreaId"));
    }

    @Test
    public void testSelect() {
        ParkingLot result = parkingLotDistanceBasedStrategy.select(Arrays.<ParkingLot>asList(new ParkingLot("_id", "parkingAreaId")));
        Assert.assertEquals(result, new ParkingLot("_id", "parkingAreaId"));
    }
}

