package com.ddev.guess_the_number.domain.repositories;

import java.util.Optional;

import com.ddev.guess_the_number.domain.models.Match;

public interface MatchRepository {
    Match create(Match match);

    Optional<Match> retrieve(String id);

    Optional<Match> remove(String id);
}
