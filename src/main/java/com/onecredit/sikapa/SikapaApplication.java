package com.onecredit.sikapa;

import com.onecredit.sikapa.domain.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

import javax.persistence.Entity;

@SpringBootApplication()
public class SikapaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SikapaApplication.class, args);


    }
}
