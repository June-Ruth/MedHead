package com.medhead.emergency;

import com.medhead.emergency.controller.LoginController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class EmergencyApplicationIT {

    @Autowired
    private LoginController loginController;

    @Test
    void contextLoadsIT() {
        assertThat(loginController).isNotNull();
    }

}
