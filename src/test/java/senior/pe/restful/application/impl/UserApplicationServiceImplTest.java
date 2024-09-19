package senior.pe.restful.application.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import senior.pe.restful.domain.user.mapper.UserMapper;
import senior.pe.restful.domain.user.model.User;
import senior.pe.restful.domain.user.model.UserDTO;
import senior.pe.restful.domain.user.service.UserService;
import senior.pe.restful.factories.UserFactory;
import senior.pe.restful.factories.dto.UserDTOFactory;

import java.util.UUID;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class UserApplicationServiceImplTest {
    @Mock
    UserService userService;
    @Mock
    UserMapper userMapper;
    @InjectMocks
    UserApplicationServiceImpl userApplicationServiceImpl;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateUser() {
        var user = UserFactory.build();
        when(userMapper.toEntity(any(UserDTO.class))).thenReturn(user);
        when(userService.createUser(any(User.class))).thenReturn(user);
        when(userMapper.toDto(any(User.class))).thenReturn(UserDTOFactory.build());

        var newUserDto = UserDTOFactory.build();
        UserDTO result = userApplicationServiceImpl.createUser(newUserDto);
        Assertions.assertNotNull(result);

        verify(userMapper).toEntity(any(UserDTO.class));
        verify(userService).createUser(any(User.class));
        verify(userMapper).toDto(any(User.class));
    }

    @Test
    void testCreateUser_whenServiceThrowsException() {
        when(userMapper.toEntity(any(UserDTO.class))).thenReturn(UserFactory.build());
        when(userService.createUser(any(User.class))).thenThrow(new RuntimeException("Error creating user"));

        Assertions.assertThrows(RuntimeException.class, () -> {
            userApplicationServiceImpl.createUser(new UserDTO());
        });
    }

    @Test
    void testGetUserById() {
        var user = UserFactory.build();
        var dto = UserDTOFactory.build();

        when(userService.getUserById(any(UUID.class))).thenReturn(user);
        when(userMapper.toDto(any(User.class))).thenReturn(dto);

        UserDTO result = userApplicationServiceImpl.getUserById(UUID.randomUUID());
        Assertions.assertNotNull(result);
    }
}