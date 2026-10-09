package com.thiago.gametrack.controller;

import com.thiago.gametrack.dto.UsuarioCreateDto;
import com.thiago.gametrack.dto.UsuarioJogoCreateDto;
import com.thiago.gametrack.dto.UsuarioJogoResponseDto;
import com.thiago.gametrack.dto.UsuarioJogoUpdateDto;
import com.thiago.gametrack.service.UsuarioJogoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<UsuarioJogoResponseDto>> buscarMinhaLista(
            Authentication authentication
    ) {

        System.out.println("ENTROU NO GET MINHA LISTA");
        System.out.println("Usuário: " + authentication.getName());

        String email = authentication.getName();

        List<UsuarioJogoResponseDto> lista =
                usuarioJogoService.buscarMinhaLista(email);

        return ResponseEntity.ok(lista);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<UsuarioJogoResponseDto> alterarStatus(
            @PathVariable Long id,
            @Valid @RequestBody UsuarioJogoUpdateDto dto,
            Authentication authentication
    ) {
        UsuarioJogoResponseDto jogoAtualizado =
                usuarioJogoService.alterarStatus(
                        id,
                        dto,
                        authentication.getName()
                );

        return ResponseEntity.ok(jogoAtualizado);
    }
}
