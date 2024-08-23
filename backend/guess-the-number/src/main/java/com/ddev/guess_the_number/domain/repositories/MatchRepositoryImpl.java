package com.ddev.guess_the_number.domain.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.ddev.guess_the_number.domain.models.Match;

@Repository
public class MatchRepositoryImpl implements MatchRepository {

    private final Map<String, Match> database = new HashMap<>();

    @Override
    public Match create(Match model) {
        String id = generateRandomId();
        Match created = new Match(id, model.answer(), new ArrayList<>());

        database.put(id, created);

        return created;
    }

    @Override
    public Optional<Match> retrieve(String id) {
        Match retrieved = database.get(id);

        return retrieved == null ? Optional.empty() : Optional.of(retrieved);
    }

    @Override
    public Optional<Match> remove(String id) {
        Match deleted = database.remove(id);

        return deleted == null ? Optional.empty() : Optional.of(deleted);
    }

    private String generateRandomId() {
        return UUID.randomUUID().toString();
    }

}
