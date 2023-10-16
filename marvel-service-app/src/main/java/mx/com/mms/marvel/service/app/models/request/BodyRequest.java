package mx.com.mms.marvel.service.app.models.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BodyRequest implements Serializable {

    private Integer statusCode;
    private Integer totalResult;
    private Integer totalRequest;
    private List<DataCharacters> result;

}
