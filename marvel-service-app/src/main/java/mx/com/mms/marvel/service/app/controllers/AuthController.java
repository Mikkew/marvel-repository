package mx.com.mms.marvel.service.app.controllers;

import mx.com.mms.marvel.service.app.constants.UserConverter;
import mx.com.mms.marvel.service.app.models.entities.User;
import mx.com.mms.marvel.service.app.models.request.UserDto;
import mx.com.mms.marvel.service.app.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController(value = "/auth")
public class AuthController {

    private final IUserService service;
    private final UserConverter converter;

    @Autowired
    public AuthController(UserConverter converter, IUserService service) {
        this.converter = converter;
        this.service = service;
    }

    @PostMapping(value = "/register", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> register(@ResponseBody Optional<UserDto> body) {
        Optional<User> response = service.createUser(converter.userDtoToUser(body));
        if(response.isEmpty()) {
            return ResponseEntity.badRequest().body("Username is taken !! ");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body("User Register successfull !! ");
    }
}
