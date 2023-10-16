package mx.com.mms.marvel.service.app.repositories;

import mx.com.mms.marvel.service.app.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
}
