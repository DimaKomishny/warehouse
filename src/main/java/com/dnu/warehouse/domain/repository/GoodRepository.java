package com.dnu.warehouse.domain.repository;

import com.dnu.warehouse.domain.dao.Good;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface GoodRepository extends JpaRepository<Good, UUID> {

    List<Good> findByName(String name);

    List<Good> findByClassName(String className);

    @Query("SELECT g FROM Good g WHERE g.className = ?1 AND g.supply.date >= ?2 AND g.supply.date <= ?3 ORDER BY g.supply.date")
    List<Good> findByClassNameAndDeliveryDateRange(String className, LocalDateTime start, LocalDateTime end);

    @Query("SELECT g FROM Good g WHERE g.supply.date >= ?1 AND g.supply.date <= ?2 ORDER BY g.supply.date")
    List<Good> findByDeliveryDateRange(LocalDateTime start, LocalDateTime end);
}
