package com.dnu.warehouse.core.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SupplyDto {

    private String id;
    private LocalDateTime date;
    private Long totalPrice;
    private List<GoodDto> goods;
}
