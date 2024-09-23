package com.mybroker.stockordermanagerapi.config;

import org.springframework.beans.factory.annotation.Value;

public class SecurityConfig {
    @Value("${api.user}")
    private String apiUser;
    @Value("${api.password}")
    private String apiPassword;

}
