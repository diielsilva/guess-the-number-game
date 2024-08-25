package com.ddev.guess_the_number.domain.models;

import java.time.LocalDateTime;

public class Attempt {

    public final int value;
    public final LocalDateTime attemptDate;

    public Attempt(int value, LocalDateTime attemptDate) {
        this.value = value;
        this.attemptDate = attemptDate;
    }

}
