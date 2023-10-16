package com.marvel.comics.api.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.marvel.comics.api.utils.URIUtils;
import com.marvel.comics.api.constants.Env;
import com.marvel.comics.api.constants.Paths;
import com.marvel.comics.api.models.params.ParamsContext;
import com.marvel.comics.api.models.response.ResponseCharacter;
import com.marvel.comics.api.services.ICharacterService;

@Service
public class CharacterServiceImpl implements ICharacterService {

	private final WebClient WEB_CLIENT;
	private final Env ENVIRONMENT;

	@Autowired
	public CharacterServiceImpl(final WebClient webClient, final Env env) {
		this.WEB_CLIENT = webClient;
		this.ENVIRONMENT = env;
	}

	@Override
	public ResponseCharacter getCharacter(Optional<ParamsContext> paramsContext) {
		return WEB_CLIENT.get().uri(URIUtils.createUriBuilder(ENVIRONMENT, paramsContext)).retrieve()
				.bodyToMono(ResponseCharacter.class).block();
	}

	@Override
	public ResponseCharacter getCharacterById(Integer characterId) {
		return WEB_CLIENT.get()
				.uri(URIUtils.uriBuilderWithPath(Paths.CHARACTER_ID.getValue(), characterId, ENVIRONMENT)).retrieve()
				.bodyToMono(ResponseCharacter.class).block();
	}
}
