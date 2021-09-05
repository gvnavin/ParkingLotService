package com.gnavin.parkinglotservice.business.vehicle.dbmodels;

import org.testng.Assert;
import org.testng.annotations.Test;

public class VehicleTest {
    Vehicle vehicle = new Vehicle("_id", "owner", "color");

    @Test
    public void testGetId() {
        String result = vehicle.getId();
        Assert.assertEquals(result, "replaceMeWithExpectedResult");
    }

    @Test
    public void testIsNew() {
        boolean result = vehicle.isNew();
        Assert.assertEquals(result, true);
    }

    @Test
    public void testGet_id() {
        String result = vehicle.get_id();
        Assert.assertEquals(result, "replaceMeWithExpectedResult");
    }

    @Test
    public void testGetOwner() {
        String result = vehicle.getOwner();
        Assert.assertEquals(result, "replaceMeWithExpectedResult");
    }

    @Test
    public void testGetColor() {
        String result = vehicle.getColor();
        Assert.assertEquals(result, "replaceMeWithExpectedResult");
    }

    @Test
    public void testComponent1() {
        String result = vehicle.component1();
        Assert.assertEquals(result, "replaceMeWithExpectedResult");
    }

    @Test
    public void testComponent2() {
        String result = vehicle.component2();
        Assert.assertEquals(result, "replaceMeWithExpectedResult");
    }

    @Test
    public void testComponent3() {
        String result = vehicle.component3();
        Assert.assertEquals(result, "replaceMeWithExpectedResult");
    }

    @Test
    public void testCopy() {
        Vehicle result = vehicle.copy("_id", "owner", "color");
        Assert.assertEquals(result, new Vehicle("_id", "owner", "color"));
    }

    @Test
    public void testToString() {
        String result = vehicle.toString();
        Assert.assertEquals(result, "replaceMeWithExpectedResult");
    }

    @Test
    public void testHashCode() {
        int result = vehicle.hashCode();
        Assert.assertEquals(result, 0);
    }

    @Test
    public void testEquals() {
        boolean result = vehicle.equals("other");
        Assert.assertEquals(result, true);
    }
}

