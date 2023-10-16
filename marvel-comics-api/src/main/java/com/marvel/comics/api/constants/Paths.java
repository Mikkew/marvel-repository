package com.marvel.comics.api.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum  Paths {

	CHARACTER_ID("characterId"),
    SIZE_IMAGE("portrait_uncanny");

    private final String value;
}
