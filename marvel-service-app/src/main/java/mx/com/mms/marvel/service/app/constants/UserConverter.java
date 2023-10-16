package mx.com.mms.marvel.service.app.constants;

import mx.com.mms.marvel.service.app.models.entities.User;
import mx.com.mms.marvel.service.app.models.request.UserDto;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserConverter {

    public Optional<UserDto> userToUserDto(Optional<User> user) {
        return user.map(userItem -> Optional.of(
                UserDto.builder()
                        .userId(userItem.getUserId())
                        .firstName(userItem.getFirstName())
                        .lastName(userItem.getLastName())
                        .email(userItem.getEmail())
                        .password(userItem.getPassword())
                        .build()))
                .orElse(null);
    }

    public Optional<User> userDtoToUser(Optional<UserDto> user) {
        return user.map(userItem -> Optional.of(
                        User.builder()
                                .userId(userItem.getUserId())
                                .firstName(userItem.getFirstName())
                                .lastName(userItem.getLastName())
                                .email(userItem.getEmail())
                                .password(userItem.getPassword())
                                .build()))
                .orElse(null);
    }
}
