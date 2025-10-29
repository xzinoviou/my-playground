package com.xzinoviou.myplayground.it;

import com.xzinoviou.myplayground.mapper.UserMapper;
import com.xzinoviou.myplayground.model.enumeration.UserRole;
import com.xzinoviou.myplayground.model.input.UserCreateInput;
import com.xzinoviou.myplayground.repository.UserRepository;
import com.xzinoviou.myplayground.service.UserService;
import com.xzinoviou.myplayground.service.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author : Xenofon Zinoviou
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class UserServiceIT {

    private static final String OFFSET_DATE_TIME = "2025-10-31T23:59:59.111222789+03:00";

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    private UserService testClass;

    @BeforeEach
    void setUp() {
        testClass = new UserServiceImpl(userRepository, userMapper);
    }

    @Test
    void getUserById() {
        System.out.println("UserServiceIT.getUserById");
        var result = testClass.getById(1);

        assertEquals(1L, result.getId());
        assertEquals("Darth", result.getFirstName());
        assertEquals("Vader", result.getLastName());
        assertEquals(UserRole.ADMIN, result.getRole());
    }

    @Test
    void create_whenUserCreatedSuccessfully_returnId() {
        System.out.println("UserServiceIT.create_whenUserCreatedSuccessfully_returnId");
        var input = newUserCreateInput();

        var id = testClass.create(input);

        assertEquals(6, id);
    }

    private UserCreateInput newUserCreateInput() {
        var input = new UserCreateInput();
        input.setFirstName("Derrick");
        input.setLastName("Rose");
        input.setRole("user");
        input.setOffsetDateTime(OFFSET_DATE_TIME);
        return input;
    }
}
