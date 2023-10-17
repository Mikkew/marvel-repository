package mx.com.mms.marvel.service.app.controllers;

import mx.com.mms.marvel.service.app.constants.UserConverter;
import mx.com.mms.marvel.service.app.jwt.JwtGenerator;
import mx.com.mms.marvel.service.app.models.entities.User;
import mx.com.mms.marvel.service.app.models.request.LoginDto;
import mx.com.mms.marvel.service.app.models.request.LoginResponseDto;
import mx.com.mms.marvel.service.app.models.request.UserDto;
import mx.com.mms.marvel.service.app.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController(value = "/auth")
public class AuthController {

    private final IUserService service;
    private final UserConverter converter;
    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;
    private final JwtGenerator jwtGenerator;

    @Autowired
    public AuthController(
            final UserConverter converter,
            final IUserService service,
            final PasswordEncoder passwordEncoder,
            final AuthenticationManager authenticationManager,
            final JwtGenerator jwtGenerator) {
        this.converter = converter;
        this.service = service;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtGenerator = jwtGenerator;
    }

    @PostMapping(value = "/register", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> register(@RequestBody Optional<UserDto> body) {
        body.get().setPassword(passwordEncoder.encode(body.get().getPassword()));
        Optional<User> response = service.createUser(converter.userDtoToUser(body));
        if(response.isEmpty()) {
            return ResponseEntity.badRequest().body("Username is taken !! ");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body("User Register successfull !! ");
    }

    @PostMapping
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginDto body) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(body.getUsername(), body.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        final String TOKEN = jwtGenerator.generateToken(authentication);

        final UserDto userDto = converter.userToUserDto(Optional.of(service.findUserByUsername(body.getUsername()))).get();

        final LoginResponseDto response = LoginResponseDto.builder()
                .success(Boolean.TRUE)
                .message("Login Successful")
                .token(TOKEN)
                .user(userDto)
                .build();
        return ResponseEntity.ok(response);

    }
}
