package com.dnu.warehouse.core.service.impl;

import com.dnu.warehouse.core.exception.WarehouseIllegalInputException;
import com.dnu.warehouse.core.service.GoodService;
import com.dnu.warehouse.domain.dao.Good;
import com.dnu.warehouse.domain.dao.GoodSold;
import com.dnu.warehouse.domain.repository.GoodRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class GoodServiceImpl implements GoodService {

    private GoodRepository goodRepo;
    private GoodRepository goodSoldRepo;

    @Override
    public void save(Good good) {
        goodRepo.save(good);
    }

    @Override
    public void delete(UUID uuid) {
        goodRepo.deleteById(uuid);
    }

    @Override
    public List<Good> findAll() {
        return goodRepo.findAll();
    }

    @Override
    public Good findById(UUID id) {
        return goodRepo.findById(id).orElseThrow(() ->
                new EntityNotFoundException(String.format("Good was not found with id %s", id)));
    }

    @Override
    public List<Good> findByName(String name) {
        return goodRepo.findByName(name);
    }

    @Override
    public List<Good> findByClassNameAndDeliveryDateRange(String className, LocalDateTime start, LocalDateTime end) {
        return goodRepo.findByClassNameAndDeliveryDateRange(className, start, end);
    }

    @Override
    @Transactional
    public GoodSold sell(UUID goodId, double quantity) {
        var good = findById(goodId);
        checkGoodIsEnough(good, quantity);
        var goodSold = GoodSold.builder()
                .price(quantity * good.getSellPrice())
                .quantity(quantity)
                .date(LocalDateTime.now())
                .build();
        good.getGoodsSold().add(goodSold);
        return goodSold;
    }

    private void checkGoodIsEnough(Good good, double quantity) {
        if (good.getQuantity() < quantity) {
            throw new WarehouseIllegalInputException(String.format("Good quantity is not enough. Quantity is %f", quantity));
        }
    }
}
