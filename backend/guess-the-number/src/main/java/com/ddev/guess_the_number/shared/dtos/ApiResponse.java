package com.ddev.guess_the_number.shared.dtos;

import com.ddev.guess_the_number.domain.enums.GameState;

public record ApiResponse(String matchId, GameState state, String message) {
}
