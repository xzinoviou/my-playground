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
    @GeneratedValue(generator = "users_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(
            name = "users_seq",
            sequenceName = "users_seq",
            allocationSize = 1,
            initialValue = 1
    )
    private Long id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Enumerated(EnumType.STRING)
    @Column(name = "ROLE")
    private UserRole role;

    @Column(name = "OFFSET_DATE_TIME")
    private OffsetDateTime offsetDateTime;

    @Column(name = "LOCAL_DATE_TIME")
    private LocalDateTime localDateTime;

    @Column(name = "TIME_ZONE_OFFSET")
    private String timeZoneOffset;
}
