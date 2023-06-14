package com.dnu.warehouse.domain.dao.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Permission {
    FULL("full"),
    DEFAULT("default");

    private final String permission;
}
