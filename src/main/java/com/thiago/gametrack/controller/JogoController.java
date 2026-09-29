package com.thiago.gametrack.controller;

import com.thiago.gametrack.entity.Jogo;
import com.thiago.gametrack.repository.JogoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/jogos")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class JogoController {

    @Autowired
    private JogoRepository jogoRepository;

    @GetMapping
    public List<Jogo> getAll(){
        return  jogoRepository.findAll();
    }
}
