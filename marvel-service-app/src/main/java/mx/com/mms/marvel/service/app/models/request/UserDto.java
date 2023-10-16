package mx.com.mms.marvel.service.app.models.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {

    private String userId;
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String password;
}
