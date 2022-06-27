package ru.vald3r.customerordersgateway.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "endpoints")
@Data
public class EndpointsConfig {
    private String customerOrdersGateway;
    private String orderService;
    private String customerService;
    private String productService;
}
