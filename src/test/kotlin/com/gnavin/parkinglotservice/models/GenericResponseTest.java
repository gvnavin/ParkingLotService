package com.gnavin.parkinglotservice.models;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GenericResponseTest {
    GenericResponse genericResponse = new GenericResponse(0, "status", "message", "");

    @Test
    public void testGetStatusCode() {
        int result = genericResponse.getStatusCode();
        Assert.assertEquals(result, 0);
    }

    @Test
    public void testGetStatus() {
        String result = genericResponse.getStatus();
        Assert.assertEquals(result, "replaceMeWithExpectedResult");
    }

    @Test
    public void testGetMessage() {
        String result = genericResponse.getMessage();
        Assert.assertEquals(result, "replaceMeWithExpectedResult");
    }

    @Test
    public void testComponent1() {
        int result = genericResponse.component1();
        Assert.assertEquals(result, 0);
    }

    @Test
    public void testComponent2() {
        String result = genericResponse.component2();
        Assert.assertEquals(result, "replaceMeWithExpectedResult");
    }

    @Test
    public void testComponent3() {
        String result = genericResponse.component3();
        Assert.assertEquals(result, "replaceMeWithExpectedResult");
    }

    @Test
    public void testCopy() {
        GenericResponse result = genericResponse.copy(0, "status", "message", "");
        Assert.assertEquals(result, new GenericResponse(0, "status", "message", ""));
    }

    @Test
    public void testToString() {
        String result = genericResponse.toString();
        Assert.assertEquals(result, "replaceMeWithExpectedResult");
    }

    @Test
    public void testHashCode() {
        int result = genericResponse.hashCode();
        Assert.assertEquals(result, 0);
    }

    @Test
    public void testEquals() {
        boolean result = genericResponse.equals("other");
        Assert.assertEquals(result, true);
    }
}

