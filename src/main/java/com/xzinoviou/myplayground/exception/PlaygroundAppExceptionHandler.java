package com.xzinoviou.myplayground.exception;

import com.xzinoviou.myplayground.error.PlaygroundAppError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.Instant;

/**
 * @author : Xenofon Zinoviou
 */
@Slf4j
@RestControllerAdvice
public class PlaygroundAppExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(PlaygroundAppException.class)
    public ResponseEntity<PlaygroundAppError> handleAppException(final PlaygroundAppException ex) {
        var error = PlaygroundAppError.builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .timestamp(Instant.now().toString())
                .message(ex.getMessage())
                .build();

        log.debug("Handling PlaygroundAppError: {}", error);

        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

