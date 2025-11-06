package com.xzinoviou.myplayground.it;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;

/**
 * @author : Xenofon Zinoviou
 */
@ContextConfiguration(classes = PropertyIT.class)
@TestPropertySource("/application-test.properties")
class PropertyIT {

    @Value("$env.var.mysql.user")
    private String user;

    @Value("$env.var.mysql.josy")
    private String host;

    @Test
    void whenRunIntegrationTestsShouldOutputEnvVars() {
        System.out.println("[----->>>> IS THIS WORKING <<<<-----]");
        System.out.println("[-----  Mysql User: " + user + "   -----]");
        System.out.println("[-----  Mysql host: " + host + "   -----]");
    }
}
