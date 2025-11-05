package com.xzinoviou.myplayground.service;

import com.xzinoviou.myplayground.mapper.UserMapper;
import com.xzinoviou.myplayground.model.entity.User;
import com.xzinoviou.myplayground.model.enumeration.UserRole;
import com.xzinoviou.myplayground.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author : Xenofon Zinoviou
 */
@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    private static final String OFFSET_DATE_TIME = "2025-10-31T23:59:59.111222789+03:00";

    @Mock
    private UserRepository userRepository;

    private final UserMapper userMapper = Mappers.getMapper(UserMapper.class);

    private UserService testClass;

    @BeforeEach
    void setUp() {

        testClass = new UserServiceImpl(userRepository, userMapper);
    }

    @Test
    void getAllUsersSuccessfully() {
        System.out.println("UserServiceImplTest.getById");
        var user = newUser();

        when(userRepository.findAll()).thenReturn(Collections.singletonList(user));
        var result = assertDoesNotThrow(() -> testClass.getAll());

        assertEquals(user.getId(), result.get(0).getId());
        verify(userRepository).findAll();

    }

    private User newUser() {
        var offsetDateTime = newOffsetDateTime();
        return User.builder()
                .id(1L)
                .firstName("firstName")
                .lastName("lastName")
                .role(UserRole.USER)
                .registrationDate(offsetDateTime)
                .timeZoneOffset(offsetDateTime.getOffset().toString())
                .build();
    }

    private OffsetDateTime newOffsetDateTime() {
        return OffsetDateTime.parse(OFFSET_DATE_TIME, DateTimeFormatter.ISO_OFFSET_DATE_TIME);
    }
}
