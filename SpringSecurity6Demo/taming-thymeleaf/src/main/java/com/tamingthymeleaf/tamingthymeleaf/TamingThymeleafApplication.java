package com.tamingthymeleaf.tamingthymeleaf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TamingThymeleafApplication {

    @Value("${spring.profiles.active}")
    private static String activeProfile;



    public static void main(String[] args) {
        SpringApplication.run(TamingThymeleafApplication.class, args);
        System.out.println(activeProfile);
    }



}
