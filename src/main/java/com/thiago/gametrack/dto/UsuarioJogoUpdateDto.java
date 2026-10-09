package com.thiago.gametrack.dto;

import com.thiago.gametrack.enuns.StatusJogo;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioJogoUpdateDto {

    @NotNull
    private StatusJogo statusJogo;
}
