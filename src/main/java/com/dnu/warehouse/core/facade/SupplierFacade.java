package com.dnu.warehouse.core.facade;

import com.dnu.warehouse.core.dto.GoodDto;
import com.dnu.warehouse.core.dto.SupplierDto;

import java.util.List;

public interface SupplierFacade {

    List<SupplierDto> getSuppliers();
    List<GoodDto> getSupplierGood(String supplierId);
    String save(SupplierDto supplier);
}
