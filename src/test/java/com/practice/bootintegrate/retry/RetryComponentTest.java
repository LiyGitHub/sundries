package com.practice.bootintegrate.retry;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class RetryComponentTest {

    @Autowired
    private RetryComponent retryComponent;

    @Test
    void sendSmsTest() {
        boolean ret = retryComponent.sendSmsRetry();
        log.info("sendSmsTest result = {}", ret);
    }

}
