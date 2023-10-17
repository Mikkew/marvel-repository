package mx.com.mms.marvel.service.app.models.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String username;
    private String password;
}
