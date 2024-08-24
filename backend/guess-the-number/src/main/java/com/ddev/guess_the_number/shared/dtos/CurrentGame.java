package com.ddev.guess_the_number.shared.dtos;

import com.ddev.guess_the_number.domain.enums.GameState;

public record CurrentGame(String match, GameState state, String message) {
}
