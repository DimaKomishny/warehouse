package com.dnu.warehouse.core.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SupplierDto {

    private String id;
    private String name;
    List<SupplyDto> supplies = new ArrayList<>();
}
