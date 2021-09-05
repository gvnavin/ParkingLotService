package com.gnavin.parkinglotservice.abstraction.dbmodels;

import com.gnavin.parkinglotservice.models.EntityType;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DemandTest {
    //Field type of type EntityType - was not mocked since Mockito doesn't mock enums
    Demand demand = new Demand("_id", EntityType.PARKING_LOT, "entityId", "entityAsJson");

    @Test
    public void testGetId() {
        String result = demand.getId();
        Assert.assertEquals(result, "replaceMeWithExpectedResult");
    }

    @Test
    public void testIsNew() {
        boolean result = demand.isNew();
        Assert.assertEquals(result, true);
    }

    @Test
    public void testGet_id() {
        String result = demand.get_id();
        Assert.assertEquals(result, "replaceMeWithExpectedResult");
    }

    @Test
    public void testGetType() {
        EntityType result = demand.getType();
        Assert.assertEquals(result, EntityType.PARKING_LOT);
    }

    @Test
    public void testGetEntityId() {
        String result = demand.getEntityId();
        Assert.assertEquals(result, "replaceMeWithExpectedResult");
    }

    @Test
    public void testGetEntityAsJson() {
        String result = demand.getEntityAsJson();
        Assert.assertEquals(result, "replaceMeWithExpectedResult");
    }

    @Test
    public void testComponent1() {
        String result = demand.component1();
        Assert.assertEquals(result, "replaceMeWithExpectedResult");
    }

    @Test
    public void testComponent2() {
        EntityType result = demand.component2();
        Assert.assertEquals(result, EntityType.PARKING_LOT);
    }

    @Test
    public void testComponent3() {
        String result = demand.component3();
        Assert.assertEquals(result, "replaceMeWithExpectedResult");
    }

    @Test
    public void testComponent4() {
        String result = demand.component4();
        Assert.assertEquals(result, "replaceMeWithExpectedResult");
    }

    @Test
    public void testCopy() {
        Demand result = demand.copy("_id", EntityType.PARKING_LOT, "entityId", "entityAsJson");
        Assert.assertEquals(result, new Demand("_id", EntityType.PARKING_LOT, "entityId", "entityAsJson"));
    }

    @Test
    public void testToString() {
        String result = demand.toString();
        Assert.assertEquals(result, "replaceMeWithExpectedResult");
    }

    @Test
    public void testHashCode() {
        int result = demand.hashCode();
        Assert.assertEquals(result, 0);
    }

    @Test
    public void testEquals() {
        boolean result = demand.equals("other");
        Assert.assertEquals(result, true);
    }
}

