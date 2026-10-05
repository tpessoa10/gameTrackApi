package com.thiago.gametrack.config;

import com.thiago.gametrack.dto.LoginRequestDto;
import com.thiago.gametrack.dto.LoginResponseDto;
import com.thiago.gametrack.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;

    private final JwtService jwtService;

    public LoginResponseDto autenticar(LoginRequestDto dto){
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getSenha());

        Authentication authentication = authenticationManager.authenticate(authenticationToken);

        String jwt = jwtService.gerarToken(authentication.getName());

        return new LoginResponseDto(jwt);
    }
}
