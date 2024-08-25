package com.ddev.guess_the_number.domain.services;

import com.ddev.guess_the_number.shared.dtos.UserMove;
import com.ddev.guess_the_number.shared.dtos.ApiResponse;

public interface GameService {
    ApiResponse start();

    ApiResponse play(UserMove move);
}
