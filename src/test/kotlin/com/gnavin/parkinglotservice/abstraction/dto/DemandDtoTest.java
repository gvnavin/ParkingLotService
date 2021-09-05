package com.gnavin.parkinglotservice.abstraction.dto;

import com.gnavin.parkinglotservice.models.EntityType;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DemandDtoTest {
    //Field type of type EntityType - was not mocked since Mockito doesn't mock enums
    DemandDto demandDto = new DemandDto("id", EntityType.PARKING_LOT, "entityAsJson");

    @Test
    public void testGetId() {
        String result = demandDto.getId();
        Assert.assertEquals(result, "replaceMeWithExpectedResult");
    }

    @Test
    public void testSetId() {
        demandDto.setId("id");
    }

    @Test
    public void testGetType() {
        EntityType result = demandDto.getType();
        Assert.assertEquals(result, EntityType.PARKING_LOT);
    }

    @Test
    public void testGetEntityAsJson() {
        String result = demandDto.getEntityAsJson();
        Assert.assertEquals(result, "replaceMeWithExpectedResult");
    }

    @Test
    public void testComponent1() {
        String result = demandDto.component1();
        Assert.assertEquals(result, "replaceMeWithExpectedResult");
    }

    @Test
    public void testComponent2() {
        EntityType result = demandDto.component2();
        Assert.assertEquals(result, EntityType.PARKING_LOT);
    }

    @Test
    public void testComponent3() {
        String result = demandDto.component3();
        Assert.assertEquals(result, "replaceMeWithExpectedResult");
    }

    @Test
    public void testCopy() {
        DemandDto result = demandDto.copy("id", EntityType.PARKING_LOT, "entityAsJson");
        Assert.assertEquals(result, new DemandDto("id", EntityType.PARKING_LOT, "entityAsJson"));
    }

    @Test
    public void testToString() {
        String result = demandDto.toString();
        Assert.assertEquals(result, "replaceMeWithExpectedResult");
    }

    @Test
    public void testHashCode() {
        int result = demandDto.hashCode();
        Assert.assertEquals(result, 0);
    }

    @Test
    public void testEquals() {
        boolean result = demandDto.equals("other");
        Assert.assertEquals(result, true);
    }
}

