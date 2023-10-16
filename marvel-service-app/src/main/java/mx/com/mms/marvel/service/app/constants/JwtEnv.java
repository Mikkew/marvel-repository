package mx.com.mms.marvel.service.app.constants;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class JwtEnv {

    private final Long _JWT_EXPIRATION;
    private final String _JWT_SECRET;

    @Autowired
    public JwtEnv(@Value("${jwt.expiration}") final Long jwtExpiration, @Value("${jwt.secret}") final String jwtSecret) {
        this._JWT_EXPIRATION = jwtExpiration;
        this._JWT_SECRET = jwtSecret;
    }
}
