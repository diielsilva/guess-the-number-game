package com.ddev.guess_the_number.domain.services;

import java.time.LocalDateTime;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.ddev.guess_the_number.domain.enums.GameState;
import com.ddev.guess_the_number.domain.models.Answer;
import com.ddev.guess_the_number.domain.models.Attempt;
import com.ddev.guess_the_number.domain.models.Match;
import com.ddev.guess_the_number.domain.repositories.MatchRepository;
import com.ddev.guess_the_number.shared.dtos.CurrentGame;
import com.ddev.guess_the_number.shared.dtos.UserMove;

@Service
public class GameServiceImpl implements GameService {

    private final MatchRepository repository;

    public GameServiceImpl(MatchRepository repository) {
        this.repository = repository;
    }

    @Override
    public CurrentGame start() {
        Match match = repository.store(new Match(new Answer(randomAnswer())));

        return new CurrentGame(match.id, GameState.PLAYING, "Game started, good luck!");
    }

    @Override
    public CurrentGame play(UserMove move) {
        String match = move.match();
        CurrentGame game = null;
        Match retrieved = repository.retrieve(match);

        if (move.answer() == retrieved.answer.value) {
            game = new CurrentGame(match, GameState.FINISHED, "Game finished!");
            repository.remove(match);
        } else {
            game = new CurrentGame(match, GameState.PLAYING, "Wrong answer, try again!");
            retrieved.attempts.add(new Attempt(move.answer(), LocalDateTime.now()));
            repository.store(retrieved);
        }

        return game;
    }

    private int randomAnswer() {
        Random random = new Random();

        return random.nextInt((100 - 1) + 1) + 1;
    }

}
