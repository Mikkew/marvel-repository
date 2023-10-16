package mx.com.mms.marvel.service.app.controllers;

import com.marvel.comics.api.models.params.ParamsContext;
import com.marvel.comics.api.models.response.ResponseCharacter;
import com.marvel.comics.api.payloads.MarvelPayload;
import lombok.extern.slf4j.Slf4j;
import mx.com.mms.marvel.service.app.converters.ResponseConverter;
import mx.com.mms.marvel.service.app.models.entities.Log;
import mx.com.mms.marvel.service.app.models.request.BodyRequest;
import mx.com.mms.marvel.service.app.service.ILogService;
import mx.com.mms.marvel.service.app.service.IMarvelServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/marvel/characters")
@Slf4j
public class MarvelController {

    private final IMarvelServiceAPI marvelService;
    private final ILogService logService;
    private final ResponseConverter converter;

    @Autowired
    public MarvelController(IMarvelServiceAPI marvelService, ILogService logService, ResponseConverter converter) {
        this.marvelService = marvelService;
        this.logService = logService;
        this.converter = converter;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getCharacters(@RequestBody Optional<ParamsContext> paramsContext) {
        LOGGER.info("Starting getCharacters................................................................");
        final LocalDateTime start = LocalDateTime.now();
        final Map<String, Object> response = marvelService.getCharacters(paramsContext);
        final BodyRequest result = converter.bodyRequestToRequestCharacter((ResponseCharacter) response.get("response"));
        final LocalDateTime end = LocalDateTime.now();
        final Log log = Log.builder()
                .startMarvelApiRequest((LocalDateTime) response.get("start"))
                .endMarvelApiRequest((LocalDateTime) response.get("end"))
                .startInternalRequest(start)
                .endInternalRequest(end)
                .build();
        logService.createLog(log);
        LOGGER.info("Finished getCharacters................................................................");
        return ResponseEntity.status(result.getStatusCode()).body(result);
    }
}
