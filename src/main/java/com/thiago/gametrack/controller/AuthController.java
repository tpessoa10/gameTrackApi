package com.thiago.gametrack.controller;

import com.thiago.gametrack.config.AuthService;
import com.thiago.gametrack.dto.LoginRequestDto;
import com.thiago.gametrack.dto.LoginResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping
    public ResponseEntity<LoginResponseDto> Login(@RequestBody LoginRequestDto dto){

        authService.autenticar(dto);

        return ResponseEntity.ok(authService.autenticar(dto));
    }
}
