package com.ddev.guess_the_number.shared.dtos;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record UserMove(@NotBlank String matchId, @Min(value = 1) @Max(value = 100) int userAnswer) {

}
