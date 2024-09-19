package senior.pe.restful.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import senior.pe.restful.domain.user.model.User;
import senior.pe.restful.domain.user.repository.UserRepository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserJpaRepository extends JpaRepository<User, UUID>, UserRepository {
    Optional<User> findByEmail(String email);
}