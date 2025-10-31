package com.xzinoviou.myplayground.model.dto;

import com.xzinoviou.myplayground.model.enumeration.UserRole;
import lombok.Builder;
import lombok.Data;

import java.time.OffsetDateTime;

/**
 * @author : Xenofon Zinoviou
 */
@Data
@Builder
public class UserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private UserRole role;
    private OffsetDateTime registrationDate;
    private String timeZoneOffset;
}
