package com.ddev.guess_the_number.domain.models;

import java.time.LocalDateTime;

public record Attempt(int value, LocalDateTime date) {

}
