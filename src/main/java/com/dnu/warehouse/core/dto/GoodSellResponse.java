package com.dnu.warehouse.core.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GoodSellResponse {

    private UUID sellId;
    private LocalDateTime date;
    private Double quantity;
    private Double price;
}
