package senior.pe.restful.application;

import senior.pe.restful.domain.user.model.UserDTO;

import java.util.UUID;

/**
 * Service interface for user application operations.
 */
public interface UserApplicationService {

    /**
     * Creates a new user based on the provided user DTO.
     *
     * @param userDTO the data transfer object containing user information
     * @return the created user DTO
     */
    UserDTO createUser(UserDTO userDTO);

    /**
     * Retrieves a user by their unique identifier.
     *
     * @param id the UUID of the user to retrieve
     * @return the user DTO found by the given ID
     */
    UserDTO getUserById(UUID id);

    /**
     * Updates the information of an existing user based on the provided user DTO.
     *
     * @param id the UUID of the user to update
     * @param userDTO the data transfer object containing updated user information
     * @return the updated user DTO
     */
    UserDTO updateUser(UUID id, UserDTO userDTO);

    /**
     * Deletes a user by their unique identifier.
     *
     * @param id the UUID of the user to delete
     * @return true if the user was successfully deleted, false otherwise
     */
    boolean deleteUser(UUID id);
}
