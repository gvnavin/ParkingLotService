package com.gnavin.parkinglotservice.converters.fromdto;

import com.gnavin.parkinglotservice.abstraction.dbmodels.Demand;
import com.gnavin.parkinglotservice.abstraction.dto.DemandDto;
import com.gnavin.parkinglotservice.models.EntityType;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class FromDemandDtoTest {
    FromDemandDto fromDemandDto = null;

    @Test
    public void testBatchConvert() {
        List<Demand> result = fromDemandDto.batchConvert(Arrays.<DemandDto>asList(new DemandDto("id", EntityType.PARKING_LOT, "entityAsJson")));
        Assert.assertEquals(result, Arrays.<Demand>asList(new Demand("_id", EntityType.PARKING_LOT, "entityId", "entityAsJson")));
    }
}

