package com.marvel.comics.api.utils;

import java.net.URI;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.web.util.UriBuilder;

import com.marvel.comics.api.constants.Env;
import com.marvel.comics.api.constants.Params;
import com.marvel.comics.api.models.params.ParamsContext;

public final class URIUtils {

    private static Function<UriBuilder, URI> uriBulderWithParams(final Env env, final ParamsContext params) {
        return uriBuilder -> uriBuilder.path(env.getENDPOINT_VALUE())
                .queryParam(Params.TS.getValue(), env.getTS_VALUE())
                .queryParam(Params.API_KEY.getValue(), env.getAPI_KEY_VALUE())
                .queryParam(Params.HASH.getValue(), env.getHASH_VALUE())
                .queryParamIfPresent(Params.NAME.getValue(), params.getName())
                .queryParamIfPresent(Params.NAME_STARTS_WITH.getValue(), params.getNameStartsWith())
                .queryParamIfPresent(Params.MODIFIED_SINCE.getValue(), params.getModifiedSince())
                .queryParamIfPresent(Params.COMICS.getValue(), params.getComics())
                .queryParamIfPresent(Params.SERIES.getValue(), params.getSeries())
                .queryParamIfPresent(Params.EVENTS.getValue(), params.getEvents())
                .queryParamIfPresent(Params.STORIES.getValue(),params.getStories())
                .queryParamIfPresent(Params.ORDER_BY.getValue(), params.getOrderBy())
                .queryParamIfPresent(Params.LIMIT.getValue(), params.getLimit())
                .queryParamIfPresent(Params.OFFSET.getValue(), params.getOffset())
                .build();
    }

    private static Function<UriBuilder, URI> uriBulderWithoutParams(final Env env) {
        return uriBuilder -> uriBuilder.path(env.getENDPOINT_VALUE())
                .queryParam(Params.TS.getValue(), env.getTS_VALUE())
                .queryParam(Params.API_KEY.getValue(), env.getAPI_KEY_VALUE())
                .queryParam(Params.HASH.getValue(), env.getHASH_VALUE())
                .build();
    }

    public static Function<UriBuilder, URI> createUriBuilder(final Env env, Optional<ParamsContext> paramsContext) {
        return paramsContext.map(params -> uriBulderWithParams(env, params)).orElseGet(() -> uriBulderWithoutParams(env));
    }

    private static String generatePathFormat(final String value) {
        return String.format("/{%s}", value);
    }

    public static Function<UriBuilder, URI> uriBuilderWithPath(final String pathKey, final Integer pathValue, final Env env) {
        return uriBuilder -> uriBuilder.path(env.getENDPOINT_VALUE().concat(generatePathFormat(pathKey)))
                .queryParam(Params.TS.getValue(), env.getTS_VALUE())
                .queryParam(Params.API_KEY.getValue(), env.getAPI_KEY_VALUE())
                .queryParam(Params.HASH.getValue(), env.getHASH_VALUE())
                .build(pathValue);
    }

}
