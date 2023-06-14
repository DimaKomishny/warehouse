package com.dnu.warehouse.core.facade;

import com.dnu.warehouse.core.dto.GoodDto;
import com.dnu.warehouse.core.dto.GoodSellRequest;
import com.dnu.warehouse.core.dto.GoodSellResponse;

import java.time.LocalDateTime;
import java.util.List;

public interface GoodFacade {

    List<GoodDto> findByClassAndDeliveryDateRange(String className, long start, long end);
    GoodSellResponse sell(GoodSellRequest sellRequest);
}
