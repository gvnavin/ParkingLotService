package com.gnavin.parkinglotservice.abstraction.dto;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ParkingAreaDtoTest {
    ParkingAreaDto parkingAreaDto = new ParkingAreaDto("id", "location", "owner");

    @Test
    public void testGetId() {
        String result = parkingAreaDto.getId();
        Assert.assertEquals(result, "replaceMeWithExpectedResult");
    }

    @Test
    public void testSetId() {
        parkingAreaDto.setId("id");
    }

    @Test
    public void testGetLocation() {
        String result = parkingAreaDto.getLocation();
        Assert.assertEquals(result, "replaceMeWithExpectedResult");
    }

    @Test
    public void testGetOwner() {
        String result = parkingAreaDto.getOwner();
        Assert.assertEquals(result, "replaceMeWithExpectedResult");
    }

    @Test
    public void testComponent1() {
        String result = parkingAreaDto.component1();
        Assert.assertEquals(result, "replaceMeWithExpectedResult");
    }

    @Test
    public void testComponent2() {
        String result = parkingAreaDto.component2();
        Assert.assertEquals(result, "replaceMeWithExpectedResult");
    }

    @Test
    public void testComponent3() {
        String result = parkingAreaDto.component3();
        Assert.assertEquals(result, "replaceMeWithExpectedResult");
    }

    @Test
    public void testCopy() {
        ParkingAreaDto result = parkingAreaDto.copy("id", "location", "owner");
        Assert.assertEquals(result, new ParkingAreaDto("id", "location", "owner"));
    }

    @Test
    public void testToString() {
        String result = parkingAreaDto.toString();
        Assert.assertEquals(result, "replaceMeWithExpectedResult");
    }

    @Test
    public void testHashCode() {
        int result = parkingAreaDto.hashCode();
        Assert.assertEquals(result, 0);
    }

    @Test
    public void testEquals() {
        boolean result = parkingAreaDto.equals("other");
        Assert.assertEquals(result, true);
    }
}

