package com.packt.cardatabase;

import com.packt.cardatabase.domain.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class CardatabaseApplication implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(CardatabaseApplication.class);

    @Autowired
    private CarRepository repository;

    @Autowired
    private OwnerRepository orepository;
    @Autowired
    private UserRepository urepository;
    public static void main(String[] args) {
        SpringApplication.run(CardatabaseApplication.class, args);
        logger.info("Application started");
    }



    @Override
    public void run(String... args) throws Exception {
        // Add owner objects and save these to db
        Owner owner1 = new Owner("John" , "Johnson");
        Owner owner2 = new Owner("Mary" , "Robinson");
        orepository.saveAll(Arrays.asList(owner1,
                owner2));
        repository.save(new Car(1,"Ford", "Mustang", "Red", "ADF-1121", 2021,59000,owner1));
        repository.save(new Car(2,"Nissan", "Leaf", "White", "SSJ-3002", 2019, 29000,owner2));
        repository.save(new Car(3,"Toyota", "Prius", "Silver", "KKO-0212", 2020, 39000,owner2));

        for (Car car: repository.findAll()) {
            logger.info(car.getBrand() + " " + car.getModel());
        }

        // Username: user, password: user
        urepository.save(new User("user",
                "$2a$10$NVM0n8ElaRgg7zWO1CxUdei7vWoPg91Lz2aYavh9.f9q0e4bRadue","USER"));
        // Username: admin, password: admin
                urepository.save(new User("admin",
                        "$2a$10$8cjz47bjbR4Mn8GMg9IZx.vyjhLXR/SKKMSZ9.mP9vpMu0ssKi8GW", "ADMIN"));
    }
}
