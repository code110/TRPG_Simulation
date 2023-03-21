package com.example.gameservice.controller;

import com.example.gameservice.dto.CreateGameDto;
import com.example.gameservice.service.GameService;
import java.util.Objects;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException.Conflict;

@RestController
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }


    @PostMapping("create-game")
    public ResponseEntity<CreateGameDto> createGame(CreateGameDto dto) {
        // xxxx
        // validate dto
        // if it's not valid
        if (Objects.equals(dto.getGameName(), ""))  {
            return ResponseEntity.badRequest().body(dto);
        }

        // create game
        boolean success = gameService.createGame();
        if (!success) {
            return ResponseEntity.status(402).body(dto);
        }

        return ResponseEntity.ok(dto);
    }
}
