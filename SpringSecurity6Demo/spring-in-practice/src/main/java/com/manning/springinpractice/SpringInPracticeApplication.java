package com.manning.springinpractice;

import com.manning.springinpractice.configuration.DbConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringInPracticeApplication {
    private static final Logger log = LoggerFactory.getLogger(SpringInPracticeApplication.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringInPracticeApplication.class, args);
        DbConfiguration dbConfiguration = applicationContext.getBean(DbConfiguration.class);
        log.info(dbConfiguration.toString());
    }

}
