package com.api.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class UserServiceNorisApiConfiguration {
	
    @Bean
    //@LoadBalanced
    public RestTemplate NorisApiClient() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate;
    }
}
