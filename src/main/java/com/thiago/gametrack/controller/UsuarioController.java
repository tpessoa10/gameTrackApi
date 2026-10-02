package com.thiago.gametrack.controller;

import com.thiago.gametrack.dto.UsuarioCreateDto;
import com.thiago.gametrack.dto.UsuarioResponseDto;
import com.thiago.gametrack.dto.mapper.UsuarioMapper;
import com.thiago.gametrack.entity.Usuario;
import com.thiago.gametrack.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<UsuarioResponseDto> cadastrar(@Valid @RequestBody UsuarioCreateDto dto) {

        Usuario toUsuario = UsuarioMapper.toUsuario(dto);

        usuarioService.salvar(toUsuario);

        return ResponseEntity.status(HttpStatus.CREATED).body(UsuarioMapper.toDto(toUsuario));
    }
}