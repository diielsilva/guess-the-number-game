package com.ddev.guess_the_number.web.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ddev.guess_the_number.domain.services.GameService;
import com.ddev.guess_the_number.shared.dtos.ApiResponse;
import com.ddev.guess_the_number.shared.dtos.UserMove;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api/v1/")
public class GameController {

    private final GameService service;

    public GameController(GameService service) {
        this.service = service;
    }

    @PostMapping(value = "/start")
    public ResponseEntity<ApiResponse> play() {
        ApiResponse response = service.start();

        return ResponseEntity.ok().body(response);
    }

    @PostMapping(value = "/play")
    public ResponseEntity<ApiResponse> play(@RequestBody @Valid UserMove move) {
        ApiResponse response = service.play(move);

        return ResponseEntity.ok().body(response);
    }

}
