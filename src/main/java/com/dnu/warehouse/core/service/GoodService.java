package com.dnu.warehouse.core.service;

import com.dnu.warehouse.domain.dao.Good;
import com.dnu.warehouse.domain.dao.GoodSold;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface GoodService {

    void save(Good good);
    void delete(UUID uuid);
    List<Good> findAll();
    Good findById(UUID id);
    List<Good> findByName(String name);
    List<Good> findByClassNameAndDeliveryDateRange(String className, LocalDateTime start, LocalDateTime end);
    GoodSold sell(UUID goodId, double quantity);
}
