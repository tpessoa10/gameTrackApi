package com.thiago.gametrack.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class JogoApiResponsePage {

    private Integer count;
    private  String next;
    private String previous;
    private List<JogoApiResponse> results;
}
