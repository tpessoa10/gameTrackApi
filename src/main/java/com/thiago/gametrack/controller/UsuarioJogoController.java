package com.thiago.gametrack.controller;

import com.thiago.gametrack.dto.UsuarioCreateDto;
import com.thiago.gametrack.dto.UsuarioJogoCreateDto;
import com.thiago.gametrack.service.UsuarioJogoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/minha-lista")
@RequiredArgsConstructor
public class UsuarioJogoController {

    private final UsuarioJogoService usuarioJogoService;

    @PostMapping
    public ResponseEntity<Void> adicionar(@Valid @RequestBody UsuarioJogoCreateDto dto, Authentication authentication) {
        System.out.println("ENTROU NO MINHA LISTA");
        System.out.println("Usuário: " + authentication.getName());
        String email = authentication.getName();

        usuarioJogoService.adicionar(dto, email);

        return ResponseEntity.status(HttpStatus.CREATED).build();

    }
}
