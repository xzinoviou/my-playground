package com.xzinoviou.myplayground.model.input;

import lombok.Getter;
import lombok.Setter;

/**
 * @author : Xenofon Zinoviou
 */
@Getter
@Setter
public class UserCreateInput {
    private Long id;
    private String firstName;
    private String lastName;
    private String role;
    private String offsetDateTime;
}
