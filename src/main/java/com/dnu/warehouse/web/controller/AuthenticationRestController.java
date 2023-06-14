package com.dnu.warehouse.web.controller;

import com.dnu.warehouse.core.dto.AuthenticationRequestDto;
import com.dnu.warehouse.core.dto.AuthenticationResponseDto;
import com.dnu.warehouse.core.service.UserService;
import com.dnu.warehouse.domain.dao.User;
import com.dnu.warehouse.security.jwt.JwtTokenProvider;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
@Slf4j
public class AuthenticationRestController {

    private final AuthenticationManager authenticationManager;
    private UserService userService;
    private JwtTokenProvider jwtTokenProvider;

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponseDto> authenticate(@RequestBody AuthenticationRequestDto requestDto) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(requestDto.getUsername(), requestDto.getPassword()));
        User user = userService.findByUsername(requestDto.getUsername());
        String token = jwtTokenProvider.createToken(requestDto.getUsername(), user.getRole().name());
        log.info("User {} was login", requestDto.getUsername());
        return ResponseEntity.ok(new AuthenticationResponseDto(token, user.getRole())) ;
    }

    @PostMapping("/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) {
        SecurityContextLogoutHandler securityContextLogoutHandler = new SecurityContextLogoutHandler();
        securityContextLogoutHandler.logout(request, response, null);
    }
}
