package mx.com.mms.marvel.service.app.service;

import com.marvel.comics.api.models.params.ParamsContext;

import java.util.Map;
import java.util.Optional;

public interface IMarvelServiceAPI {

    Map<String, Object> getCharacters(Optional<ParamsContext> paramsContext);

    Map<String, Object> getCharacterById(Integer id);
}
