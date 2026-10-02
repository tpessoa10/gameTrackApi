package com.thiago.gametrack.service;


import com.thiago.gametrack.entity.Usuario;
import com.thiago.gametrack.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public Usuario salvar(Usuario usuario) {

        if (usuarioRepository.existsByEmail(usuario.getEmail())) {
            throw new IllegalStateException(
                    "Já existe um usuário cadastrado com esse e-mail."
            );
        }

        return usuarioRepository.save(usuario);
    }
}
