package com.dnu.warehouse.core.convertor;

import com.dnu.warehouse.core.dto.SupplyDto;
import com.dnu.warehouse.domain.dao.Supplier;
import com.dnu.warehouse.domain.dao.Supply;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class SupplyDtoConvertor {

    private GoodDtoConvertor goodConvertor;

    public Supply toSupply(SupplyDto dto, Supplier supplier) {
        var supply = Supply.builder()
                .id(convertId(dto.getId()))
                .date(dto.getDate())
                .supplier(supplier)
                .totalPrice(dto.getTotalPrice())
                .build();
        supply.setGoods(dto.getGoods().stream().map(g -> goodConvertor.toGood(g, supply)).collect(Collectors.toList()));
        return supply;
    }

    public SupplyDto toSupplyDto(Supply supply) {
        return SupplyDto.builder()
                .id(supply.getId().toString())
                .totalPrice(supply.getTotalPrice())
                .date(supply.getDate())
                .goods(supply.getGoods().stream().map(goodConvertor::toGoodDto).collect(Collectors.toList()))
                .build();
    }

    private UUID convertId(String id) {
        return id != null ? UUID.fromString(id) : null;
    }
}
