package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * This is the main Core (Spring-Boot) application class
 *
 * @author ahayat
 */
@Configuration
@ComponentScan("com.app")
@EnableAutoConfiguration
@PropertySource("classpath:sql.properties")
public class Application extends SpringBootServletInitializer {

    /**
     * Entry point function
     *
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }

    /**
     *
     * @param application
     * @return
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }
}
