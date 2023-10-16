package mx.com.mms.marvel.service.app.service.impl;

import mx.com.mms.marvel.service.app.models.entities.User;
import mx.com.mms.marvel.service.app.repositories.UserRepository;
import mx.com.mms.marvel.service.app.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    private final UserRepository repository;

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public Optional<User> createUser(Optional<User> user) {
        return Optional.of(repository.save(user.get()));
    }
}
