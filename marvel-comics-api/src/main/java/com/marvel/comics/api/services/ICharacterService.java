package com.marvel.comics.api.services;

import com.marvel.comics.api.models.params.ParamsContext;
import com.marvel.comics.api.models.response.ResponseCharacter;

import java.util.Optional;

public interface ICharacterService {

	ResponseCharacter getCharacter(Optional<ParamsContext> paramsContext);
	
	ResponseCharacter getCharacterById(Integer characterId);
}