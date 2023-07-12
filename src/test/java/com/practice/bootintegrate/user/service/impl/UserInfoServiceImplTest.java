package com.practice.bootintegrate.user.service.impl;

import com.practice.bootintegrate.BootIntegrateApplication;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserInfoServiceImplTest {
    @Autowired
    private UserInfoServiceImpl userInfoService;
    @Test
    void getList() {
        userInfoService.list();
    }
}
