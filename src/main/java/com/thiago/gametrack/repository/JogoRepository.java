package com.thiago.gametrack.repository;

import com.thiago.gametrack.entity.Jogo;
import com.thiago.gametrack.entity.UsuarioJogo;
import com.thiago.gametrack.projection.JogoProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JogoRepository extends JpaRepository<Jogo, Long> {

    @Query("""
        SELECT j
        FROM Jogo j
    """)
    Page<JogoProjection> findAllPageable(@Param("nome")Pageable pageable);


    Optional<Jogo> findByExternalId(String externalId);


}
