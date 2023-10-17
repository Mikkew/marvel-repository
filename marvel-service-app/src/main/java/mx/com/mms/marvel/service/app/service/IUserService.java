package mx.com.mms.marvel.service.app.service;

import mx.com.mms.marvel.service.app.models.entities.User;

import java.util.Optional;

public interface IUserService {

    User findUserByUsername(String username);

    Optional<User> createUser(Optional<User> user);
}
