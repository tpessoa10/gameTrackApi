package com.thiago.gametrack.dto.mapper;

import com.thiago.gametrack.dto.JogoApiResponse;
import com.thiago.gametrack.entity.Jogo;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@NoArgsConstructor
public class JogoMapper {

    public static Jogo toChamado(JogoApiResponse dto){
        return new ModelMapper().map(dto, Jogo.class);
    }

    public static JogoApiResponse toDto(Jogo jogo){
        return new ModelMapper().map(jogo, JogoApiResponse.class);
    }
}
