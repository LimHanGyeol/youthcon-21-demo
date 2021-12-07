package com.yoouthcon21.secondservice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class SecondServiceConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
