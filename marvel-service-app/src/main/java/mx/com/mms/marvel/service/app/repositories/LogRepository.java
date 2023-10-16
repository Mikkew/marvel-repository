package mx.com.mms.marvel.service.app.repositories;

import mx.com.mms.marvel.service.app.models.entities.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends JpaRepository<Log, String> {
}
