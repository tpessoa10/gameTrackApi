package com.thiago.gametrack.entity;

import com.thiago.gametrack.enuns.StatusJogo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "usuario_jogos", uniqueConstraints = {@UniqueConstraint(columnNames = {"usuario_idd", "jogo_id"})})
public class UsuarioJogo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "jogo_id", nullable = false)
    private Jogo jogo;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusJogo statusJogo;

}
