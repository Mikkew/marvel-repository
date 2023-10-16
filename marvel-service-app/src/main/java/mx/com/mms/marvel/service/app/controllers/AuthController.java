package mx.com.mms.marvel.service.app.controllers;

import mx.com.mms.marvel.service.app.constants.UserConverter;
import mx.com.mms.marvel.service.app.models.request.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController(value = "/auth")
public class AuthController {

    private final UserConverter converter;

    @Autowired
    public AuthController(UserConverter converter) {
        this.converter = converter;
    }

    @PostMapping(value = "/register", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> register(@ResponseBody Optional<UserDto> body) {

    }
}
