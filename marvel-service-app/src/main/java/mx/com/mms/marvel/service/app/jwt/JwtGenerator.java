package mx.com.mms.marvel.service.app.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import mx.com.mms.marvel.service.app.constants.JwtEnv;
import mx.com.mms.marvel.service.app.utlis.EncryptUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtGenerator {

    private final JwtEnv jwtEnv;

    @Autowired
    public JwtGenerator(JwtEnv jwtEnv) {
        this.jwtEnv = jwtEnv;
    }

    public String generateToken(Authentication authentication) {
        final String username = authentication.getName();
        final Date currentDate = new Date();
        final Date expiryDate = new Date(currentDate.getTime() + jwtEnv.get_JWT_EXPIRATION());
        final SecretKey key = EncryptUtils.encode(jwtEnv.get_JWT_SECRET());

        final JwtBuilder jwt = Jwts.builder().subject(username).issuedAt(currentDate)
                .expiration(expiryDate).signWith(key);

        return jwt.compact();
    }

    public String getUsernameFromJWT(String token) {
        final SecretKey key = EncryptUtils.encode(jwtEnv.get_JWT_SECRET());
        final Claims claims = Jwts.parser().verifyWith(key).build().parseSignedClaims(token).getPayload();
        return claims.getSubject();
    }

    public boolean validateToken(String token) {
        final SecretKey key = EncryptUtils.encode(jwtEnv.get_JWT_SECRET());
        try {
            Jwts.parser().verifyWith(key).build().parseSignedClaims(token);
            return true;
        }
        catch (Exception ex) {
            throw new AuthenticationCredentialsNotFoundException("JWT token is not valid " + token);
        }
    }
}
