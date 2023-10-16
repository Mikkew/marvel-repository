package com.marvel.comics.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

import com.marvel.comics.api.constants.Env;

@Configuration
public class MarvelConnectionConfig {

    @Autowired
    private Env env;

    @Bean
    public WebClient getConnection(WebClient.Builder webClientBuilder) {
        return webClientBuilder
                .baseUrl(env.getMARVEL_URL_VALUE())
                .build();
    }

}
