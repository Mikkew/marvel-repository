package mx.com.mms.marvel.service.app.utlis;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class EncryptUtils {

    private EncryptUtils() {}

    public static String decode(SecretKey secretKey) throws NoSuchAlgorithmException {
        final byte[] rawData = secretKey.getEncoded();
        return Base64.getEncoder().encodeToString(rawData);
    }

    public static SecretKey encode(String encodedKey) {
        final byte[] decodedKey = Base64.getDecoder().decode(encodedKey);
        return new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES");
    }
}
