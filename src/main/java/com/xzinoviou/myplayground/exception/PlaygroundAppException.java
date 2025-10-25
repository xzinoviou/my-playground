package com.xzinoviou.myplayground.exception;

import lombok.Getter;

/**
 * @author : Xenofon Zinoviou
 */
@Getter
public class PlaygroundAppException extends RuntimeException {

    public PlaygroundAppException(String message) {
        super(message);
    }
}
