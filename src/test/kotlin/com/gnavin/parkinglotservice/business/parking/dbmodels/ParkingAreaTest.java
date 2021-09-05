package com.gnavin.parkinglotservice.business.parking.dbmodels;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ParkingAreaTest {
    ParkingArea parkingArea = new ParkingArea("_id", "location", "owner");

    @Test
    public void testGetId() {
        String result = parkingArea.getId();
        Assert.assertEquals(result, "replaceMeWithExpectedResult");
    }

    @Test
    public void testIsNew() {
        boolean result = parkingArea.isNew();
        Assert.assertEquals(result, true);
    }

    @Test
    public void testGet_id() {
        String result = parkingArea.get_id();
        Assert.assertEquals(result, "replaceMeWithExpectedResult");
    }

    @Test
    public void testSet_id() {
        parkingArea.set_id("_id");
    }

    @Test
    public void testGetLocation() {
        String result = parkingArea.getLocation();
        Assert.assertEquals(result, "replaceMeWithExpectedResult");
    }

    @Test
    public void testGetOwner() {
        String result = parkingArea.getOwner();
        Assert.assertEquals(result, "replaceMeWithExpectedResult");
    }

    @Test
    public void testComponent1() {
        String result = parkingArea.component1();
        Assert.assertEquals(result, "replaceMeWithExpectedResult");
    }

    @Test
    public void testComponent2() {
        String result = parkingArea.component2();
        Assert.assertEquals(result, "replaceMeWithExpectedResult");
    }

    @Test
    public void testComponent3() {
        String result = parkingArea.component3();
        Assert.assertEquals(result, "replaceMeWithExpectedResult");
    }

    @Test
    public void testCopy() {
        ParkingArea result = parkingArea.copy("_id", "location", "owner");
        Assert.assertEquals(result, new ParkingArea("_id", "location", "owner"));
    }

    @Test
    public void testToString() {
        String result = parkingArea.toString();
        Assert.assertEquals(result, "replaceMeWithExpectedResult");
    }

    @Test
    public void testHashCode() {
        int result = parkingArea.hashCode();
        Assert.assertEquals(result, 0);
    }

    @Test
    public void testEquals() {
        boolean result = parkingArea.equals("other");
        Assert.assertEquals(result, true);
    }
}

