package com.gnavin.parkinglotservice.abstraction.dbmodels;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DispatchTest {
    Dispatch dispatch = new Dispatch("_id", "supplyId", "demandId", 0L, 0L);

    @Test
    public void testGetId() {
        String result = dispatch.getId();
        Assert.assertEquals(result, "replaceMeWithExpectedResult");
    }

    @Test
    public void testIsNew() {
        boolean result = dispatch.isNew();
        Assert.assertEquals(result, true);
    }

    @Test
    public void testGet_id() {
        String result = dispatch.get_id();
        Assert.assertEquals(result, "replaceMeWithExpectedResult");
    }

    @Test
    public void testGetSupplyId() {
        String result = dispatch.getSupplyId();
        Assert.assertEquals(result, "replaceMeWithExpectedResult");
    }

    @Test
    public void testGetDemandId() {
        String result = dispatch.getDemandId();
        Assert.assertEquals(result, "replaceMeWithExpectedResult");
    }

    @Test
    public void testGetStartTimestamp() {
        long result = dispatch.getStartTimestamp();
        Assert.assertEquals(result, 0L);
    }

    @Test
    public void testGetEndTimestamp() {
        long result = dispatch.getEndTimestamp();
        Assert.assertEquals(result, 0L);
    }

    @Test
    public void testSetEndTimestamp() {
        dispatch.setEndTimestamp(0L);
    }

    @Test
    public void testComponent1() {
        String result = dispatch.component1();
        Assert.assertEquals(result, "replaceMeWithExpectedResult");
    }

    @Test
    public void testComponent2() {
        String result = dispatch.component2();
        Assert.assertEquals(result, "replaceMeWithExpectedResult");
    }

    @Test
    public void testComponent3() {
        String result = dispatch.component3();
        Assert.assertEquals(result, "replaceMeWithExpectedResult");
    }

    @Test
    public void testComponent4() {
        long result = dispatch.component4();
        Assert.assertEquals(result, 0L);
    }

    @Test
    public void testComponent5() {
        long result = dispatch.component5();
        Assert.assertEquals(result, 0L);
    }

    @Test
    public void testCopy() {
        Dispatch result = dispatch.copy("_id", "supplyId", "demandId", 0L, 0L);
        Assert.assertEquals(result, new Dispatch("_id", "supplyId", "demandId", 0L, 0L));
    }

    @Test
    public void testToString() {
        String result = dispatch.toString();
        Assert.assertEquals(result, "replaceMeWithExpectedResult");
    }

    @Test
    public void testHashCode() {
        int result = dispatch.hashCode();
        Assert.assertEquals(result, 0);
    }

    @Test
    public void testEquals() {
        boolean result = dispatch.equals("other");
        Assert.assertEquals(result, true);
    }
}

