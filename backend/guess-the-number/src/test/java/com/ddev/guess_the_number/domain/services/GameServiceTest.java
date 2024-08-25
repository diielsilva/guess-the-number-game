package com.ddev.guess_the_number.domain.services;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.ddev.guess_the_number.domain.enums.GameState;
import com.ddev.guess_the_number.domain.models.Answer;
import com.ddev.guess_the_number.domain.models.Match;
import com.ddev.guess_the_number.domain.repositories.MatchRepository;
import com.ddev.guess_the_number.shared.dtos.CurrentGame;
import com.ddev.guess_the_number.shared.dtos.UserMove;

@ExtendWith(value = SpringExtension.class)
class GameServiceTest {

    @InjectMocks
    private GameServiceImpl service;

    @Mock
    private MatchRepository repository;

    @BeforeEach
    void setUp() {
        when(repository.store(any(Match.class)))
                .thenReturn(new Match("12345", new Answer(10)));

        when(repository.retrieve(anyString()))
                .thenReturn(new Match("12345", new Answer(10)));

        when(repository.remove(anyString()))
                .thenReturn(new Match("12345", new Answer(10)));
    }

    @Test
    void start_GameShouldBeStarted() {
        CurrentGame game = service.start();

        assertAll(() -> {
            assertEquals(GameState.PLAYING, game.state());
            assertEquals("Game started, good luck!", game.message());
        });
    }

    @Test
    void play_GameShouldBeFinished_WhenAnswerIsCorrect() {
        CurrentGame game = service.play(new UserMove("12345", 10));

        assertAll(() -> {
            assertEquals(GameState.FINISHED, game.state());
            assertEquals("Game finished!", game.message());
        });
    }

    @Test
    void play_GameShouldNotBeFinished_WhenAnswerIsIncorrect() {
        CurrentGame game = service.play(new UserMove("12345", 1));

        assertAll(() -> {
            assertEquals(GameState.PLAYING, game.state());
            assertEquals("Wrong answer, try again!", game.message());
        });
    }

}
