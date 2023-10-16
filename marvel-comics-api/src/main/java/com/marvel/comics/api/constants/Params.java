package com.marvel.comics.api.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Params {

    API_KEY("apikey"),
    HASH("hash"),
    TS("ts"),
    NAME("name"),
    NAME_STARTS_WITH("nameStartsWith"),
    MODIFIED_SINCE("modifiedSince"),
    COMICS("comics"),
    SERIES("series"),
    EVENTS("events"),
    STORIES("stories"),
    ORDER_BY("orderBy"),    
    LIMIT("limit"),
	OFFSET("offset");

    private final String value;
}
