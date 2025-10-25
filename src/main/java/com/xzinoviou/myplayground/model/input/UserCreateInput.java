package com.xzinoviou.myplayground.model.input;

import lombok.Getter;

/**
 * @author : Xenofon Zinoviou
 */
@Getter
public class UserCreateInput {
    private Long id;
    private String firstName;
    private String lastName;
    private String role;
    private String dateOfBirth;
}
