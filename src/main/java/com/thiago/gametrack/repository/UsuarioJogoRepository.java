package com.thiago.gametrack.repository;

import com.thiago.gametrack.entity.UsuarioJogo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioJogoRepository extends JpaRepository<UsuarioJogo, Long> {

    boolean existsByUsuarioIdAndJogoId(Long usuarioId, Long jogoId);

    List<UsuarioJogo> findAllByUsuarioId(Long usuarioId);

}
