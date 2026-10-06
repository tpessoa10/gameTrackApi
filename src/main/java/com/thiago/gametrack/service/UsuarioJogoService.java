package com.thiago.gametrack.service;

import com.thiago.gametrack.dto.UsuarioJogoCreateDto;
import com.thiago.gametrack.entity.Jogo;
import com.thiago.gametrack.entity.Usuario;
import com.thiago.gametrack.entity.UsuarioJogo;
import com.thiago.gametrack.repository.JogoRepository;
import com.thiago.gametrack.repository.UsuarioJogoRepository;
import com.thiago.gametrack.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioJogoService {

    private final UsuarioJogoRepository usuarioJogoRepository;
    private final JogoRepository jogoRepository;
    private final UsuarioRepository usuarioRepository;

    public void adicionar(UsuarioJogoCreateDto usuarioJogoCreateDto, String email){
        Usuario usuario = usuarioRepository.findByEmail(email).orElseThrow(() ->
                new EntityNotFoundException("Usuário não encontrado"));

        Jogo jogo = jogoRepository.findById(usuarioJogoCreateDto.getJogoId()).orElseThrow(() ->
                new EntityNotFoundException("Jogo não encontrado"));

        boolean jaExisteJogo = usuarioJogoRepository.existsByUsuarioIdAndJogoId(usuario.getId(), jogo.getId());

        if (jaExisteJogo) {
            throw new IllegalStateException("Este jogo já está na sua lista");
        }

        UsuarioJogo usuarioJogo = new UsuarioJogo();

        usuarioJogo.setUsuario(usuario);
        usuarioJogo.setJogo(jogo);
        usuarioJogo.setStatusJogo(usuarioJogoCreateDto.getStatusJogo());

        usuarioJogoRepository.save(usuarioJogo);
    }

}
