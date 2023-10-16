package mx.com.mms.marvel.service.app.models.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DataCharacters {

    private Integer id;
    private String name;
    private String urlImage;
    private String urlDetails;
    private Comics comics;
}
