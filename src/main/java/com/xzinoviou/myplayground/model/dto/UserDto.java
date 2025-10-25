package com.xzinoviou.myplayground.model.dto;

import com.xzinoviou.myplayground.model.enumeration.UserRole;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;
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
    private OffsetDateTime offsetDateTimeRegistration;
    private LocalDateTime localDateTimeRegistration;
    private String timeZoneOffset;
}
