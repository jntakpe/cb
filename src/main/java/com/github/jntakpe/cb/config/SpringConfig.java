package com.github.jntakpe.cb.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Classe mère de configuration de Spring boot
 *
 * @author jntakpe
 */
@Configuration
@ComponentScan("com.github.jntakpe.cb")
@EnableAutoConfiguration
public class SpringConfig {

    public static void main(String[] args) {
        SpringApplication.run(SpringConfig.class, args);
    }

}
