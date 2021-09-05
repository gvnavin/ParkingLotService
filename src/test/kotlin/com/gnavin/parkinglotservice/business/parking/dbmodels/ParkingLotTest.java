package com.gnavin.parkinglotservice.business.parking.dbmodels;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ParkingLotTest {
    ParkingLot parkingLot = new ParkingLot("_id", "parkingAreaId");

    @Test
    public void testIsNew() {
        boolean result = parkingLot.isNew();
        Assert.assertEquals(result, true);
    }

    @Test
    public void testGetId() {
        String result = parkingLot.getId();
        Assert.assertEquals(result, "replaceMeWithExpectedResult");
    }

    @Test
    public void testGet_id() {
        String result = parkingLot.get_id();
        Assert.assertEquals(result, "replaceMeWithExpectedResult");
    }

    @Test
    public void testSet_id() {
        parkingLot.set_id("_id");
    }

    @Test
    public void testGetParkingAreaId() {
        String result = parkingLot.getParkingAreaId();
        Assert.assertEquals(result, "replaceMeWithExpectedResult");
    }

    @Test
    public void testComponent1() {
        String result = parkingLot.component1();
        Assert.assertEquals(result, "replaceMeWithExpectedResult");
    }

    @Test
    public void testComponent2() {
        String result = parkingLot.component2();
        Assert.assertEquals(result, "replaceMeWithExpectedResult");
    }

    @Test
    public void testCopy() {
        ParkingLot result = parkingLot.copy("_id", "parkingAreaId");
        Assert.assertEquals(result, new ParkingLot("_id", "parkingAreaId"));
    }

    @Test
    public void testToString() {
        String result = parkingLot.toString();
        Assert.assertEquals(result, "replaceMeWithExpectedResult");
    }

    @Test
    public void testHashCode() {
        int result = parkingLot.hashCode();
        Assert.assertEquals(result, 0);
    }

    @Test
    public void testEquals() {
        boolean result = parkingLot.equals("other");
        Assert.assertEquals(result, true);
    }
}

