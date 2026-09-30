package com.thiago.gametrack.controller;

import com.thiago.gametrack.dto.JogoResponseDto;
import com.thiago.gametrack.dto.PageableDto;
import com.thiago.gametrack.dto.mapper.JogoMapper;
import com.thiago.gametrack.dto.mapper.PageableMapper;
import com.thiago.gametrack.entity.Jogo;
import com.thiago.gametrack.projection.JogoProjection;
import com.thiago.gametrack.repository.JogoRepository;
import com.thiago.gametrack.service.JogoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/jogos")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class JogoController {

    @Autowired
    private JogoService jogoService;

    @GetMapping
    public ResponseEntity<PageableDto<JogoProjection>> getAll(@PageableDefault(size = 10, sort = {"nome"}) Pageable pageable) {
        Page<JogoProjection> jogos = jogoService.buscarTodos(pageable);
        return ResponseEntity.ok(PageableMapper.toDto(jogos));
    }

    @GetMapping("/{id}")
    public ResponseEntity<JogoResponseDto> getById(@PathVariable Long id) {
        Jogo jogo = jogoService.buscarPorId(id);
        return ResponseEntity.ok(JogoMapper.toDto(jogo));
    }
}
