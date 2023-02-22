package com.practice.bootintegrate;

import com.practice.bootintegrate.user.service.TestService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.practice.bootintegrate.user.mapper")
@SpringBootApplication
public class BootIntegrateApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootIntegrateApplication.class, args);
    }

}
