package com.example.gameservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude
public class CreateGameDto {

    private String gameName;

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }
}
