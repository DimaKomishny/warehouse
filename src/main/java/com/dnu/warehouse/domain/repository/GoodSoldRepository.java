package com.dnu.warehouse.domain.repository;

import com.dnu.warehouse.domain.dao.GoodSold;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GoodSoldRepository extends JpaRepository<GoodSold, UUID> {
}
