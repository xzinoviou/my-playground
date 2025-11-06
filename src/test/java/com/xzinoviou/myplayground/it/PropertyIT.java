package com.xzinoviou.myplayground.it;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;

/**
 * @author : Xenofon Zinoviou
 */
@ContextConfiguration(classes = PropertyIT.class)
@TestPropertySource("/application-test.properties")
@Slf4j
class PropertyIT {

    @Value("$env.var.mysql.user")
    private String user;

    @Value("$env.var.mysql.josy")
    private String host;

    @Test
    void whenRunIntegrationTestsShouldOutputEnvVars() {
        log.info("[----->>>> IS THIS WORKING <<<<-----]");
        log.info("[-----  Mysql User: " + user + "   -----]");
        log.info("[-----  Mysql host: " + host + "   -----]");
    }
}
