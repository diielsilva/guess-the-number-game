package com.ddev.guess_the_number.domain.models;

import java.util.List;

public record Match(String id, Answer answer, List<Attempt> attempts) {
}
