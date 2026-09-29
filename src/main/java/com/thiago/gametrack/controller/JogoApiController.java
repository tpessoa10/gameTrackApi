package com.thiago.gametrack.controller;

import com.thiago.gametrack.service.JogoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/jogos")
@RequiredArgsConstructor
public class JogoApiController {

    private final JogoService jogoService;

    @PostMapping("/sincronizar")
    public ResponseEntity<Void> sincronizar(@RequestParam(defaultValue = "1") int pagina) {

        jogoService.sincronizarJogos(pagina);

        return ResponseEntity.ok().build();
    }
}