package com.ddev.guess_the_number.domain.repositories;

import com.ddev.guess_the_number.domain.exceptions.DatabaseException;
import com.ddev.guess_the_number.domain.models.Match;

public interface MatchRepository {
    Match store(Match match) throws DatabaseException;

    Match retrieve(String id) throws DatabaseException;

    Match remove(String id);

    void clean();
}
