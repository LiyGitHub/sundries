package com.practice.bootintegrate;

import com.practice.bootintegrate.user.service.TestService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@MapperScan("com.practice.bootintegrate.user.mapper")
@SpringBootApplication
@EnableScheduling
public class BootIntegrateApplication {

    private static final ThreadLocal<String> TEMP_DYNAMIC_TENANT = new ThreadLocal<>();

    public static void main(String[] args) {
        SpringApplication.run(BootIntegrateApplication.class, args);
    }

}
