package com.dnu.warehouse.core.service.impl;

import com.dnu.warehouse.core.service.SupplierService;
import com.dnu.warehouse.domain.dao.Good;
import com.dnu.warehouse.domain.dao.Supplier;
import com.dnu.warehouse.domain.repository.SupplierRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SupplierServiceImpl implements SupplierService {

    SupplierRepository supplierRepository;

    @Override
    public void save(Supplier supplier) {
        supplierRepository.save(supplier);
    }

    @Override
    public void delete(UUID uuid) {
        supplierRepository.deleteById(uuid);
    }

    @Override
    public List<Supplier> findAll() {
        return supplierRepository.findAll();
    }

    @Override
    public Supplier findById(UUID id) {
        return supplierRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(String.format("Supplier with %s does not exist", id)));
    }

    @Override
    public List<Supplier> findByName(String name) {
        return supplierRepository.findByName(name);
    }

    @Override
    @Transactional
    public List<Good> getSupplierGood(UUID supplierId) {
        var supplier = findById(supplierId);
        return supplier.getSupplies().stream().flatMap(s-> s.getGoods().stream()).collect(Collectors.toList());
    }
}
