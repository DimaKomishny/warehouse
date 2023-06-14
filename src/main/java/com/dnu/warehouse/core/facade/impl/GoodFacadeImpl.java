package com.dnu.warehouse.core.facade.impl;

import com.dnu.warehouse.core.convertor.GoodDtoConvertor;
import com.dnu.warehouse.core.dto.GoodDto;
import com.dnu.warehouse.core.dto.GoodSellRequest;
import com.dnu.warehouse.core.dto.GoodSellResponse;
import com.dnu.warehouse.core.facade.GoodFacade;
import com.dnu.warehouse.core.service.GoodService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.TimeZone;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class GoodFacadeImpl implements GoodFacade {

    private GoodService goodService;
    private GoodDtoConvertor convertor;

    @Override
    public List<GoodDto> findByClassAndDeliveryDateRange(String className, long start, long end) {
        return goodService.findByClassNameAndDeliveryDateRange(
                        className, convertTimestamp(start), convertTimestamp(end)).stream()
                .map(convertor::toGoodDto)
                .collect(Collectors.toList());
    }

    @Override
    public GoodSellResponse sell(GoodSellRequest sellRequest) {
        var goodSell = goodService.sell(sellRequest.getGoodId(), sellRequest.getQuantity());
        return GoodSellResponse.builder()
                .sellId(goodSell.getId())
                .date(goodSell.getDate())
                .price(goodSell.getPrice())
                .quantity(goodSell.getQuantity())
                .build();
    }

    private LocalDateTime convertTimestamp(long timestamp) {
        return LocalDateTime.ofInstant(Instant.ofEpochSecond(timestamp), TimeZone.getDefault().toZoneId());
    }
}