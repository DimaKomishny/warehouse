package com.dnu.warehouse.core.service;

import com.dnu.warehouse.domain.dao.Good;
import com.dnu.warehouse.domain.dao.Supplier;

import java.util.List;
import java.util.UUID;

public interface SupplierService {

    void save(Supplier supplier);
    void delete(UUID uuid);
    List<Supplier> findAll();
    Supplier findById(UUID id);
    List<Supplier> findByName(String name);
    List<Good> getSupplierGood(UUID supplierId);
}
