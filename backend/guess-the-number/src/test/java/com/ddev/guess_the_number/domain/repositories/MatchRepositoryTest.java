package com.ddev.guess_the_number.domain.repositories;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.ddev.guess_the_number.domain.exceptions.DatabaseException;
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
        Match created = repository.store(new Match("123", new Answer(10)));

        assertNotNull(created.id);
    }

    @Test
    void retrieve_MatchShouldBeReturned() {
        Match created = repository.store(new Match(new Answer(10)));

        assertDoesNotThrow(() -> repository.retrieve(created.id));
    }

    @Test
    void retrieve_MatchShouldNotBeReturned_WhenIdIsNotFound() {
        assertThrows(DatabaseException.class, () -> repository.retrieve("12345"));
    }

    @Test
    void remove_MatchShouldBeRemoved() {
        Match created = repository.store(new Match(new Answer(10)));

        assertDoesNotThrow(() -> repository.remove(created.id));
    }

    @Test
    void remove_MatchShouldNotBeRemoved_WhenIdIsNotFound() {
        assertThrows(DatabaseException.class, () -> repository.remove("12345"));
    }

}
