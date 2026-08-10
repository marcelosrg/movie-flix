package io.github.marcelosrg.movieflix.configuration;

import io.github.marcelosrg.movieflix.exception.ConflitException;
import io.github.marcelosrg.movieflix.exception.NotFoundException;
import io.github.marcelosrg.movieflix.exception.UsernameOrPasswordInvalidException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHanlder {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Map<String, String>> handleNotFoundException(NotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", ex.getMessage()));
    }

    @ExceptionHandler(ConflitException.class)
    public ResponseEntity<Map<String, String>> ConflitException(ConflitException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(Map.of("error", ex.getMessage()));
    }

    @ExceptionHandler(UsernameOrPasswordInvalidException.class)
    public ResponseEntity<Map<String, String>> UsernameOrPasswordInvalidException(UsernameOrPasswordInvalidException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", ex.getMessage()));
    }
}
