package com.marvel.comics.api.constants;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class Env {

    private final String MARVEL_URL_VALUE;
    private final String TS_VALUE;
    private final String API_KEY_VALUE ;
    private final String HASH_VALUE;
    private final String ENDPOINT_VALUE;

    @Autowired
    public Env(
            @Value("${marvel.url}") final String marvelUrl,
            @Value("${marvel.ts}") final String ts,
            @Value("${marvel.apiKey}") final String apiKey,
            @Value("${marvel.hash}") final String hash,
            @Value("${marvel.endpoints.characters}") final String endpoint) {
        this.MARVEL_URL_VALUE = marvelUrl;
        this.TS_VALUE = ts;
        this.API_KEY_VALUE = apiKey;
        this.HASH_VALUE = hash;
        this.ENDPOINT_VALUE =  endpoint;
    }

}
