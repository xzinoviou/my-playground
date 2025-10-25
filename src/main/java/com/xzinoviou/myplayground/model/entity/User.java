package com.xzinoviou.myplayground.model.entity;

import com.xzinoviou.myplayground.model.enumeration.UserRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

/**
 * @author : Xenofon Zinoviou
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "USERS")
public class User {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Enumerated(EnumType.STRING)
    @Column(name = "ROLE")
    private UserRole role;

    @Column(name = "OFFSET_DATE_TIME_REGISTRATION")
    private OffsetDateTime offsetDateTimeRegistration;

    @Column(name = "LOCAL_DATE_TIME_REGISTRATION")
    private LocalDateTime localDateTimeRegistration;

    @Column(name = "TIME_ZONE_OFFSET")
    private String timeZoneOffset;
}
