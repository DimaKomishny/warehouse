package com.dnu.warehouse.core.dto;

import com.dnu.warehouse.domain.dao.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponseDto {

    private String token;
    private Role role;
}
