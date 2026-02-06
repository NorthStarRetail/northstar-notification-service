package com.northstar.northstar.notification.service.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("notification")
public class AppConfiguration {
    private String msg;
    private String buildVersion;
    private String baseUrl;
}
