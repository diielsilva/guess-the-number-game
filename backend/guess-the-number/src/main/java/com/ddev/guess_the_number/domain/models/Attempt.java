package com.ddev.guess_the_number.domain.models;

import java.time.LocalDate;

public record Attempt(int value, LocalDate attemptDate) {

}
