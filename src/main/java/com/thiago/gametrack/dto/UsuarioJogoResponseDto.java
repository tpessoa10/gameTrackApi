package com.thiago.gametrack.dto;

import com.thiago.gametrack.enuns.StatusJogo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioJogoResponseDto {

    private Long id;
    private Long jogoId;
    private String nome;
    private String capa;
    private StatusJogo statusJogo;
}
