package com.dnu.warehouse.core.facade.impl;

import com.dnu.warehouse.core.convertor.GoodDtoConvertor;
import com.dnu.warehouse.core.convertor.SupplierDtoConvertor;
import com.dnu.warehouse.core.dto.GoodDto;
import com.dnu.warehouse.core.dto.SupplierDto;
import com.dnu.warehouse.core.facade.SupplierFacade;
import com.dnu.warehouse.core.service.SupplierService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SupplierFacadeImpl implements SupplierFacade {

    private SupplierService supplierService;
    private SupplierDtoConvertor supplierConvertor;
    private GoodDtoConvertor goodConvertor;

    @Override
    public List<SupplierDto> getSuppliers() {
        return supplierService.findAll().stream()
                .map(supplierConvertor::toSupplierDto).collect(Collectors.toList());
    }

    @Override
    public List<GoodDto> getSupplierGood(String supplierId) {
        return supplierService.getSupplierGood(UUID.fromString(supplierId)).stream()
                .map(goodConvertor::toGoodDto).collect(Collectors.toList());
    }

    @Override
    public String save(SupplierDto supplierDto) {
        var supplier = supplierConvertor.toSupplier(supplierDto);
        supplierService.save(supplier);
        return supplier.getId().toString();
    }
}
