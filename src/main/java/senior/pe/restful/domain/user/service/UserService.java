package senior.pe.restful.domain.user.service;

import senior.pe.restful.domain.user.model.User;

import java.util.UUID;

/**
 * Service interface for managing users.
 */
public interface UserService {

    /**
     * Creates a new user in the system.
     *
     * @param user the user entity to create
     * @return the created user entity
     */
    User createUser(User user);

    /**
     * Retrieves a user by their unique identifier.
     *
     * @param id the UUID of the user to retrieve
     * @return the user entity found by the given ID
     */
    User getUserById(UUID id);

    /**
     * Updates the information of an existing user.
     *
     * @param user the user entity with updated information
     * @return the updated user entity
     */
    User updateUser(User user);

    /**
     * Deletes a user by their unique identifier.
     *
     * @param id the UUID of the user to delete
     * @return true if the user was successfully deleted, false otherwise
     */
    boolean deleteUser(UUID id);
}
