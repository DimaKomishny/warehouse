package com.dnu.warehouse.core.dto;

import com.dnu.warehouse.domain.dao.enums.Category;
import com.dnu.warehouse.domain.dao.enums.MeasureType;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GoodDto {

    private String id;
    private String name;
    @JsonProperty("class")
    private String className;
    private MeasureType measureType;
    private Double quantity;
    private Double buyPrice;
    private Double sellPrice;
    private Category category;
}
