package com.dnu.warehouse.core.service;

import com.dnu.warehouse.domain.dao.Supplier;
import com.dnu.warehouse.domain.dao.Supply;

import java.time.LocalDate;
import java.util.List;

public interface SupplyService {

    List<Supply> findBySupplierAndDateRange(Supplier supplier, LocalDate dateStart, LocalDate dateEnd);
}
