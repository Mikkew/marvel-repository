package mx.com.mms.marvel.service.app.service.impl;

import com.marvel.comics.api.models.params.ParamsContext;
import com.marvel.comics.api.models.response.ResponseCharacter;
import com.marvel.comics.api.payloads.MarvelPayload;
import lombok.extern.slf4j.Slf4j;
import mx.com.mms.marvel.service.app.service.IMarvelServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@Slf4j
public class MarvelAPIServiceImpl implements IMarvelServiceAPI {

    private final MarvelPayload payload;

    @Autowired
    public MarvelAPIServiceImpl(MarvelPayload payload) {
        this.payload = payload;
    }

    @Override
    public Map<String, Object> getCharacters(Optional<ParamsContext> paramsContext) {
        LOGGER.info("Starting connection for Marvel API");
        Map<String, Object> result = new HashMap<>();

        final LocalDateTime start = LocalDateTime.now();
        final ResponseCharacter responseMarvel = payload.getCharactersPayload(paramsContext);
        LOGGER.info("Got response from Marvel API");

        final LocalDateTime end = LocalDateTime.now();

        result.put("response", responseMarvel);
        result.put("start", start);
        result.put("end", end);
        LOGGER.info("Ending connection for Marvel API");
        return result;
    }

    @Override
    public Map<String, Object> getCharacterById(Integer id) {
        LOGGER.info("Starting connection for Marvel API");
        Map<String, Object> result = new HashMap<>();

        final LocalDateTime start = LocalDateTime.now();
        final ResponseCharacter responseMarvel = payload.getCharacterByIdPayload(id);
        LOGGER.info("Got response from Marvel API");

        final LocalDateTime end = LocalDateTime.now();

        result.put("response", responseMarvel);
        result.put("start", start);
        result.put("end", end);
        LOGGER.info("Ending request for Marvel API");
        return result;
    }
}
