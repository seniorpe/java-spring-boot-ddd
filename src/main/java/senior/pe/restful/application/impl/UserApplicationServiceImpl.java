package senior.pe.restful.application.impl;

import io.vavr.control.Try;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import senior.pe.restful.api.exception.ExistsEmailException;
import senior.pe.restful.application.UserApplicationService;
import senior.pe.restful.domain.user.mapper.UserMapper;
import senior.pe.restful.domain.user.model.User;
import senior.pe.restful.domain.user.model.UserDTO;
import senior.pe.restful.domain.user.service.UserService;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserApplicationServiceImpl implements UserApplicationService {
    private final UserService userService;
    private final UserMapper userMapper;

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        return Try.of(() -> userDTO)
                .map(userMapper::toEntity)
                .map(userService::createUser)
                .map(userMapper::toDto)
                .onFailure(ex -> {
                    if (ex instanceof ExistsEmailException) {
                        throw new ExistsEmailException(ex.getMessage());
                    } else {
                        throw new RuntimeException("Error creating user", ex);
                    }
                }).get();
    }

    @Override
    public UserDTO getUserById(UUID id) {
        return Try.of(() -> id)
                .map(userService::getUserById)
                .map(userMapper::toDto)
                .getOrElseThrow(() -> new RuntimeException("Error find user"));
    }

    @Override
    public UserDTO updateUser(UUID id, UserDTO userDTO) {
        return Try.of(() -> {
            User user = userMapper.toEntity(userDTO);
            user.setId(id);
            User updatedUser = userService.updateUser(user);
            return updatedUser != null ? userMapper.toDto(updatedUser) : null;
        }).getOrElseThrow(() -> new RuntimeException("Error updating user"));
    }

    @Override
    public boolean deleteUser(UUID id) {
        return Try.of(() -> userService.deleteUser(id))
                .getOrElse(false);
    }
}