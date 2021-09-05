package com.gnavin.parkinglotservice.abstraction.dto;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ParkingLotDtoTest {
    ParkingLotDto parkingLotDto = new ParkingLotDto("id", "parkingAreaId", "location", "owner");

    @Test
    public void testGetId() {
        String result = parkingLotDto.getId();
        Assert.assertEquals(result, "replaceMeWithExpectedResult");
    }

    @Test
    public void testGetParkingAreaId() {
        String result = parkingLotDto.getParkingAreaId();
        Assert.assertEquals(result, "replaceMeWithExpectedResult");
    }

    @Test
    public void testGetLocation() {
        String result = parkingLotDto.getLocation();
        Assert.assertEquals(result, "replaceMeWithExpectedResult");
    }

    @Test
    public void testGetOwner() {
        String result = parkingLotDto.getOwner();
        Assert.assertEquals(result, "replaceMeWithExpectedResult");
    }

    @Test
    public void testComponent1() {
        String result = parkingLotDto.component1();
        Assert.assertEquals(result, "replaceMeWithExpectedResult");
    }

    @Test
    public void testComponent2() {
        String result = parkingLotDto.component2();
        Assert.assertEquals(result, "replaceMeWithExpectedResult");
    }

    @Test
    public void testComponent3() {
        String result = parkingLotDto.component3();
        Assert.assertEquals(result, "replaceMeWithExpectedResult");
    }

    @Test
    public void testComponent4() {
        String result = parkingLotDto.component4();
        Assert.assertEquals(result, "replaceMeWithExpectedResult");
    }

    @Test
    public void testCopy() {
        ParkingLotDto result = parkingLotDto.copy("id", "parkingAreaId", "location", "owner");
        Assert.assertEquals(result, new ParkingLotDto("id", "parkingAreaId", "location", "owner"));
    }

    @Test
    public void testToString() {
        String result = parkingLotDto.toString();
        Assert.assertEquals(result, "replaceMeWithExpectedResult");
    }

    @Test
    public void testHashCode() {
        int result = parkingLotDto.hashCode();
        Assert.assertEquals(result, 0);
    }

    @Test
    public void testEquals() {
        boolean result = parkingLotDto.equals("other");
        Assert.assertEquals(result, true);
    }
}

