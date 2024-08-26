package com.ddev.guess_the_number.domain.repositories;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.ddev.guess_the_number.domain.exceptions.DatabaseException;
import com.ddev.guess_the_number.domain.models.Match;

@Repository
public class MatchRepositoryImpl implements MatchRepository {

    private final Map<String, Match> database = new HashMap<>();

    @Override
    public Match store(Match match) {
        String id = UUID.randomUUID().toString();

        if (match.id == null) {
            match.id = id;
        }

        database.put(match.id, match);

        return match;
    }

    @Override
    public Match retrieve(String id) {
        boolean exists = database.containsKey(id);

        if (!exists) {
            throw new DatabaseException(String.format("Match %s not found!", id));
        }

        return database.get(id);
    }

    @Override
    public Match remove(String id) {
        boolean exists = database.containsKey(id);

        if (!exists) {
            throw new DatabaseException(String.format("Match %s not found!", id));
        }

        return database.remove(id);
    }

    @Override
    public void clean() {
        Set<String> keys = database.keySet();

        for (String key : keys) {
            database.remove(key);
        }
    }

}
