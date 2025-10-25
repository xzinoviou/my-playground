package com.xzinoviou.myplayground.model.enumeration;

import com.xzinoviou.myplayground.exception.PlaygroundAppException;

import java.util.Arrays;

/**
 * @author : Xenofon Zinoviou
 */
public enum UserRole {

    ADMIN, DEVELOPER, MANAGER, EMPLOYEE, USER;

    public static UserRole fromRole(final String input){
        return Arrays.stream(values()).filter(v -> v.name().equalsIgnoreCase(input))
                .findFirst().orElseThrow(() -> new PlaygroundAppException("Supplied user role is invalid: " + input));
    }
}
