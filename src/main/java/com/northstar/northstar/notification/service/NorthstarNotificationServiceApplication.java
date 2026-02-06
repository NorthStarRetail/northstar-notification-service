package com.northstar.northstar.notification.service;

import com.northstar.northstar.notification.service.configuration.AppConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(value = AppConfiguration.class)
public class NorthstarNotificationServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(NorthstarNotificationServiceApplication.class, args);
    }
}
