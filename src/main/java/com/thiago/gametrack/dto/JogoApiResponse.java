package com.thiago.gametrack.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class JogoApiResponse {

    private Long id;
    private String name;
    private String description;
    private String background_image;
}
