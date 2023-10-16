package mx.com.mms.marvel.service.app.converters;

import com.marvel.comics.api.constants.Extensions;
import com.marvel.comics.api.constants.Paths;
import com.marvel.comics.api.models.response.ComicsCharacter;
import com.marvel.comics.api.models.response.ItemCharacterv1;
import com.marvel.comics.api.models.response.ResponseCharacter;
import com.marvel.comics.api.models.response.ResultCharacter;
import mx.com.mms.marvel.service.app.models.request.BodyRequest;
import mx.com.mms.marvel.service.app.models.request.Comics;
import mx.com.mms.marvel.service.app.models.request.DataCharacters;
import org.springframework.stereotype.Component;

@Component
public class ResponseConverter {

    private Comics comicsCharactersToComics(ComicsCharacter comicsCharacter) {
        return Comics.builder()
                .total(comicsCharacter.getAvailable())
                .comics(comicsCharacter.getItems().stream().map(ItemCharacterv1::getName).toList())
                .build();
    }


    private DataCharacters resultCharacterToDataCharacters(ResultCharacter resultCharacter) {
        final String imageUrl = resultCharacter.getThumbnail().getPath()
                .concat("/").concat(Paths.SIZE_IMAGE.getValue()).concat(Extensions.JPG.getValue());
        return DataCharacters.builder()
                .id(resultCharacter.getId())
                .name(resultCharacter.getName())
                .urlDetails(resultCharacter.getResourceURI())
                .urlImage(imageUrl)
                .comics(comicsCharactersToComics(resultCharacter.getComics()))
                .build();
    }

    public BodyRequest bodyRequestToRequestCharacter(ResponseCharacter responseCharacter) {
        return BodyRequest.builder()
                .statusCode(responseCharacter.getCode())
                .totalResult(responseCharacter.getData().getCount())
                .totalRequest(responseCharacter.getData().getTotal())
                .result(responseCharacter.getData().getResults().stream().map(this::resultCharacterToDataCharacters).toList())
                .build();
    }
}
