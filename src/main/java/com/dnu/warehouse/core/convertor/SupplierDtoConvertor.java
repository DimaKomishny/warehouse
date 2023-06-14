package com.dnu.warehouse.core.convertor;

import com.dnu.warehouse.core.dto.SupplierDto;
import com.dnu.warehouse.domain.dao.Supplier;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class SupplierDtoConvertor {

    SupplyDtoConvertor supplyConvertor;

    public Supplier toSupplier(SupplierDto dto) {
        var supplier = Supplier.builder()
                .id(convertId(dto.getId()))
                .name(dto.getName())
                .build();
        supplier.setSupplies(dto.getSupplies()
                .stream()
                .map(s -> supplyConvertor.toSupply(s, supplier))
                .collect(Collectors.toList()));
        return supplier;
    }

    public SupplierDto toSupplierDto(Supplier supplier) {
        return SupplierDto.builder()
                .id(supplier.getId().toString())
                .name(supplier.getName())
                .supplies(supplier.getSupplies().stream().map(supplyConvertor::toSupplyDto).collect(Collectors.toList()))
                .build();
    }

    private UUID convertId(String id) {
        return id != null ? UUID.fromString(id) : null;
    }
}