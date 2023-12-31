package mx.com.mms.marvel.service.app.models.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String userId;
    private String firstName;
    private String lastName;
    private String username;
    private String email;

    @JsonProperty(value = "userId", access = JsonProperty.Access.READ_WRITE)
    private String password;
}
