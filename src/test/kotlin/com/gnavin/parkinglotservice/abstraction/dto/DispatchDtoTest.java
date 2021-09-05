package com.gnavin.parkinglotservice.abstraction.dto;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DispatchDtoTest {
    DispatchDto dispatchDto = new DispatchDto("id", "supplyId", "demandId", 0L, 0L, "entityAsJson");

    @Test
    public void testGetId() {
        String result = dispatchDto.getId();
        Assert.assertEquals(result, "replaceMeWithExpectedResult");
    }

    @Test
    public void testGetSupplyId() {
        String result = dispatchDto.getSupplyId();
        Assert.assertEquals(result, "replaceMeWithExpectedResult");
    }

    @Test
    public void testGetDemandId() {
        String result = dispatchDto.getDemandId();
        Assert.assertEquals(result, "replaceMeWithExpectedResult");
    }

    @Test
    public void testGetStartTimestamp() {
        long result = dispatchDto.getStartTimestamp();
        Assert.assertEquals(result, 0L);
    }

    @Test
    public void testGetEndTimestamp() {
        long result = dispatchDto.getEndTimestamp();
        Assert.assertEquals(result, 0L);
    }

    @Test
    public void testSetEndTimestamp() {
        dispatchDto.setEndTimestamp(0L);
    }

    @Test
    public void testGetEntityAsJson() {
        String result = dispatchDto.getEntityAsJson();
        Assert.assertEquals(result, "replaceMeWithExpectedResult");
    }

    @Test
    public void testSetEntityAsJson() {
        dispatchDto.setEntityAsJson("entityAsJson");
    }

    @Test
    public void testComponent1() {
        String result = dispatchDto.component1();
        Assert.assertEquals(result, "replaceMeWithExpectedResult");
    }

    @Test
    public void testComponent2() {
        String result = dispatchDto.component2();
        Assert.assertEquals(result, "replaceMeWithExpectedResult");
    }

    @Test
    public void testComponent3() {
        String result = dispatchDto.component3();
        Assert.assertEquals(result, "replaceMeWithExpectedResult");
    }

    @Test
    public void testComponent4() {
        long result = dispatchDto.component4();
        Assert.assertEquals(result, 0L);
    }

    @Test
    public void testComponent5() {
        long result = dispatchDto.component5();
        Assert.assertEquals(result, 0L);
    }

    @Test
    public void testComponent6() {
        String result = dispatchDto.component6();
        Assert.assertEquals(result, "replaceMeWithExpectedResult");
    }

    @Test
    public void testCopy() {
        DispatchDto result = dispatchDto.copy("id", "supplyId", "demandId", 0L, 0L, "entityAsJson");
        Assert.assertEquals(result, new DispatchDto("id", "supplyId", "demandId", 0L, 0L, "entityAsJson"));
    }

    @Test
    public void testToString() {
        String result = dispatchDto.toString();
        Assert.assertEquals(result, "replaceMeWithExpectedResult");
    }

    @Test
    public void testHashCode() {
        int result = dispatchDto.hashCode();
        Assert.assertEquals(result, 0);
    }

    @Test
    public void testEquals() {
        boolean result = dispatchDto.equals("other");
        Assert.assertEquals(result, true);
    }
}

