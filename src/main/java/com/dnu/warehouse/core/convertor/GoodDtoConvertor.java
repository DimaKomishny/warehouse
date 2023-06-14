package com.dnu.warehouse.core.convertor;

import com.dnu.warehouse.core.dto.GoodDto;
import com.dnu.warehouse.domain.dao.Good;
import com.dnu.warehouse.domain.dao.Supply;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class GoodDtoConvertor {

    public Good toGood(GoodDto dto, Supply supply) {
        return Good.builder()
                .id(convertId(dto.getId()))
                .name(dto.getName())
                .className(dto.getClassName())
                .supply(supply)
                .category(dto.getCategory())
                .measureType(dto.getMeasureType())
                .quantity(dto.getQuantity())
                .buyPrice(dto.getBuyPrice())
                .sellPrice(dto.getSellPrice())
                .build();
    }

    public GoodDto toGoodDto(Good good) {
        return GoodDto.builder()
                .id(good.getId().toString())
                .name(good.getName())
                .className(good.getClassName())
                .category(good.getCategory())
                .measureType(good.getMeasureType())
                .quantity(good.getQuantity())
                .buyPrice(good.getBuyPrice())
                .sellPrice(good.getSellPrice())
                .build();
    }

    private UUID convertId(String id) {
        return id != null ? UUID.fromString(id) : null;
    }
}
