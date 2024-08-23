package com.ddev.guess_the_number.domain.repositories;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.ddev.guess_the_number.domain.models.Answer;
import com.ddev.guess_the_number.domain.models.Match;

@ExtendWith(value = SpringExtension.class)
public class MatchRepositoryTest {

    private MatchRepository repository;

    @BeforeEach
    void setup() {
        repository = new MatchRepositoryImpl();
    }

    @Test
    void create_MatchShouldBeSaved() {
        Match created = repository.create(new Match("123", new Answer(10), new ArrayList<>()));

        assertNotNull(created.id());
    }

    @Test
    void retrieve_MatchShouldBeReturned() {
        Match created = repository.create(new Match(null, new Answer(10), List.of()));

        Optional<Match> retrieved = repository.retrieve(created.id());

        assertTrue(retrieved.isPresent());
    }

    @Test
    void retrieve_MatchShouldNotBeReturned_WhenIdIsNotFound() {
        Optional<Match> retrieved = repository.retrieve("123");

        assertTrue(retrieved.isEmpty());
    }

    @Test
    void remove_MatchShouldBeRemoved() {
        Match created = repository.create(new Match(null, new Answer(10), new ArrayList<>()));

        Optional<Match> removed = repository.remove(created.id());
    
        assertTrue(removed.isPresent());
    }

    @Test
    void remove_MatchShouldNotBeRemoved_WhenIdIsNotFound() {
        Optional<Match> removed = repository.remove("123");

        assertTrue(removed.isEmpty());
    }

}
