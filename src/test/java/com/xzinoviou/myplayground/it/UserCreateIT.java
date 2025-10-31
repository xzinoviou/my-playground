package com.xzinoviou.myplayground.it;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xzinoviou.myplayground.model.input.UserCreateInput;
import com.xzinoviou.myplayground.repository.UserRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.testcontainers.containers.MySQLContainer;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

/**
 * @author : Xenofon Zinoviou
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Sql(value = "/test-data.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@AutoConfigureMockMvc
class UserCreateIT {

    private static final String OFFSET_DATE_TIME = "2025-10-31T23:59:59.111222789+03:00";

    static MySQLContainer<?> mysql;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MockMvc mockMvc;

    private final ObjectMapper objectMapper = new ObjectMapper();


    @BeforeAll
    static void beforeAll() {
        mysql = new MySQLContainer<>("mysql:8.0.31")
                .withDatabaseName("test_db")
                .withUsername("dev")
                .withPassword("dev");

        mysql.start();
    }

    @AfterAll
    static void afterAll() {
        mysql.stop();
    }

    @DynamicPropertySource
    static void configureProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", mysql::getJdbcUrl);
        registry.add("spring.datasource.username", mysql::getUsername);
        registry.add("spring.datasource.password", mysql::getPassword);
        registry.add("spring.datasource.driver-class-name", mysql::getDriverClassName);
        registry.add("spring.jpa.show-sql", () -> false);
        registry.add("spring.jpa.properties.hibernate.format_sql", () -> false);
    }

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
        userRepository.deleteAll();
    }

    @Test
    void testShouldCreateUserAndReturnUserId() throws Exception {
        final String payloadAsString = objectMapper.writeValueAsString(newUserCreateInput());

        mockMvc.perform(post("/users")
                        .contentType("application/json")
                        .content(payloadAsString))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$").value(6));
    }

    @Test
    void test_whenInvalidInput_shouldThrowException_andFailCreation() throws Exception {
        var payload = newUserCreateInput();
        payload.setRole("invalidROLE");
        final String payloadAsString = objectMapper.writeValueAsString(payload);

        mockMvc.perform(post("/users").contentType("application/json").content(payloadAsString))
                .andExpect(MockMvcResultMatchers.status().is5xxServerError())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Failed to create user"));
    }

    private UserCreateInput newUserCreateInput() {
        var input = new UserCreateInput();
        input.setFirstName("Derrick");
        input.setLastName("Rose");
        input.setRole("user");
        input.setRegistrationDate(OFFSET_DATE_TIME);
        return input;
    }
}
