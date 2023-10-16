package mx.com.mms.marvel.service.app.service;

import mx.com.mms.marvel.service.app.models.entities.User;

import java.util.Optional;

public interface IUserService {

    Optional<User> createUser(Optional<User> user);
}
