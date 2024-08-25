package com.ddev.guess_the_number.domain.services;

import com.ddev.guess_the_number.shared.dtos.UserMove;
import com.ddev.guess_the_number.shared.dtos.CurrentGame;

public interface GameService {
    CurrentGame start();

    CurrentGame play(UserMove move);
}
