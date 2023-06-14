package com.dnu.warehouse.web.controller;

import com.dnu.warehouse.core.dto.GoodDto;
import com.dnu.warehouse.core.dto.SupplierDto;
import com.dnu.warehouse.core.dto.SupplyDto;
import com.dnu.warehouse.core.facade.SupplierFacade;
import com.dnu.warehouse.domain.dao.enums.Category;
import com.dnu.warehouse.domain.dao.enums.MeasureType;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/v1/supplier")
@AllArgsConstructor
@PreAuthorize("hasAnyAuthority('default')")
public class SupplierController {

    private SupplierFacade supplierFacade;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<SupplierDto> getAllSuppliers() {
        return supplierFacade.getSuppliers();
    }

    @GetMapping("/{id}/good")
    @ResponseStatus(HttpStatus.OK)
    public List<GoodDto> getGoods(@PathVariable("id") String id) {
        return supplierFacade.getSupplierGood(id);
    }

    @GetMapping("/random")
    @ResponseStatus(HttpStatus.OK)
    public SupplierDto getRandomSupplier() {
        var good = GoodDto.builder()
                .id(UUID.randomUUID().toString())
                .name(UUID.randomUUID().toString())
                .measureType(MeasureType.QUANTITY)
                .quantity(10D)
                .sellPrice(100D)
                .buyPrice(80D)
                .category(Category.DRINK)
                .build();

        var supply = SupplyDto.builder()
                .id(UUID.randomUUID().toString())
                .totalPrice(null)
                .goods(List.of(good))
                .date(LocalDateTime.now())
                .build();

        return SupplierDto.builder()
                .id(UUID.randomUUID().toString())
                .name(UUID.randomUUID().toString())
                .supplies(List.of(supply))
                .build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public Map<String, String> saveSupplier(@RequestBody SupplierDto supplier) {
        String id = supplierFacade.save(supplier);
        return Map.of("id", id);
    }
}
