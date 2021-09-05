package com.gnavin.parkinglotservice.abstraction.dto;

import com.gnavin.parkinglotservice.models.EntityType;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SupplyDtoTest {
    //Field type of type EntityType - was not mocked since Mockito doesn't mock enums
    SupplyDto supplyDto = new SupplyDto("id", EntityType.PARKING_LOT, "entityAsJson");

    @Test
    public void testGetId() {
        String result = supplyDto.getId();
        Assert.assertEquals(result, "replaceMeWithExpectedResult");
    }

    @Test
    public void testSetId() {
        supplyDto.setId("id");
    }

    @Test
    public void testGetType() {
        EntityType result = supplyDto.getType();
        Assert.assertEquals(result, EntityType.PARKING_LOT);
    }

    @Test
    public void testGetEntityAsJson() {
        String result = supplyDto.getEntityAsJson();
        Assert.assertEquals(result, "replaceMeWithExpectedResult");
    }

    @Test
    public void testComponent1() {
        String result = supplyDto.component1();
        Assert.assertEquals(result, "replaceMeWithExpectedResult");
    }

    @Test
    public void testComponent2() {
        EntityType result = supplyDto.component2();
        Assert.assertEquals(result, EntityType.PARKING_LOT);
    }

    @Test
    public void testComponent3() {
        String result = supplyDto.component3();
        Assert.assertEquals(result, "replaceMeWithExpectedResult");
    }

    @Test
    public void testCopy() {
        SupplyDto result = supplyDto.copy("id", EntityType.PARKING_LOT, "entityAsJson");
        Assert.assertEquals(result, new SupplyDto("id", EntityType.PARKING_LOT, "entityAsJson"));
    }

    @Test
    public void testToString() {
        String result = supplyDto.toString();
        Assert.assertEquals(result, "replaceMeWithExpectedResult");
    }

    @Test
    public void testHashCode() {
        int result = supplyDto.hashCode();
        Assert.assertEquals(result, 0);
    }

    @Test
    public void testEquals() {
        boolean result = supplyDto.equals("other");
        Assert.assertEquals(result, true);
    }
}

