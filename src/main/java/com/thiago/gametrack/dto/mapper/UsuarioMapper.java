package com.thiago.gametrack.dto.mapper;

import com.thiago.gametrack.dto.UsuarioCreateDto;
import com.thiago.gametrack.dto.UsuarioResponseDto;
import com.thiago.gametrack.entity.Usuario;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UsuarioMapper {

    public static Usuario toUsuario(UsuarioCreateDto dto) {

        return new ModelMapper().map(dto, Usuario.class);
    }

    public static UsuarioResponseDto toDto(Usuario jogo) {
        return new ModelMapper().map(jogo, UsuarioResponseDto.class);
    }
}
