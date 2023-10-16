package com.marvel.comics.api.payloads;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import com.marvel.comics.api.models.params.ParamsContext;
import com.marvel.comics.api.models.response.ResponseCharacter;
import com.marvel.comics.api.services.ICharacterService;

import java.util.Optional;

@Component
public class MarvelPayload {

    private final ICharacterService service;

    @Autowired
    public MarvelPayload(ICharacterService service) {
        this.service = service;
    }

    public ResponseCharacter getCharactersPayload(Optional<ParamsContext> body) {
    	return service.getCharacter(body);
    }
    

    public ResponseCharacter getCharacterByIdPayload(@PathVariable Integer characterId) {
    	return service.getCharacterById(characterId);
    }
}
