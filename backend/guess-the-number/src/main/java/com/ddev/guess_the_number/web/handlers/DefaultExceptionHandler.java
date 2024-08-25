package com.ddev.guess_the_number.web.handlers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ddev.guess_the_number.domain.enums.GameState;
import com.ddev.guess_the_number.domain.exceptions.DatabaseException;
import com.ddev.guess_the_number.shared.dtos.ApiResponse;

@RestControllerAdvice
public class DefaultExceptionHandler {

    @ExceptionHandler(value = DatabaseException.class)
    protected ResponseEntity<ApiResponse> handleDatabaseException(DatabaseException exception) {
        ApiResponse response = new ApiResponse("", GameState.UNKNOW, exception.getMessage());

        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    protected ResponseEntity<ApiResponse> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException exception) {
        ApiResponse response = new ApiResponse("", GameState.UNKNOW, "Wrong or missing mandatory fields!");

        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(value = RuntimeException.class)
    protected ResponseEntity<ApiResponse> handleGenericException(RuntimeException exception) {
        ApiResponse response = new ApiResponse("", GameState.UNKNOW, "Unknow error!");

        return ResponseEntity.internalServerError().body(response);
    }

}
