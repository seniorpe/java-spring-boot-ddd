package senior.pe.restful.domain.user.repository;

import senior.pe.restful.domain.user.model.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Repository interface for managing User entities.
 */
public interface UserRepository {

    /**
     * Saves a given user entity.
     *
     * @param user the user entity to save
     * @return the saved user entity
     */
    User save(User user);

    /**
     * Retrieves a user by their unique identifier.
     *
     * @param id the UUID of the user to retrieve
     * @return an Optional containing the user entity if found, or empty if not
     */
    Optional<User> findById(UUID id);

    /**
     * Retrieves a user by their email address.
     *
     * @param email the email of the user to retrieve
     * @return an Optional containing the user entity if found, or empty if not
     */
    Optional<User> findByEmail(String email);

    /**
     * Retrieves all user entities.
     *
     * @return a list of all user entities
     */
    List<User> findAll();

    /**
     * Deletes a user by their unique identifier.
     *
     * @param id the UUID of the user to delete
     */
    void deleteById(UUID id);
}
