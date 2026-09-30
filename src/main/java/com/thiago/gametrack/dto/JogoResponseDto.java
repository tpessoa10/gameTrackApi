package com.thiago.gametrack.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JogoResponseDto {
    private Long id;
    private String nome;
    private String descricao;
    private String capa;
}
