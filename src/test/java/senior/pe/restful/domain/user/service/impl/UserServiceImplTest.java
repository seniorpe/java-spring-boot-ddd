package senior.pe.restful.domain.user.service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import senior.pe.restful.api.exception.ExistsEmailException;
import senior.pe.restful.domain.user.model.User;
import senior.pe.restful.domain.user.repository.UserRepository;
import senior.pe.restful.factories.UserFactory;
import senior.pe.restful.infrastructure.security.JwtTokenProvider;

import java.util.Optional;
import java.util.UUID;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class UserServiceImplTest {
    @Mock
    UserRepository userRepository;
    @Mock
    JwtTokenProvider jwtTokenProvider;
    @InjectMocks
    UserServiceImpl userServiceImpl;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateUser() {
        var user = UserFactory.build();
        when(jwtTokenProvider.generateToken(anyString())).thenReturn("eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJqdWFuQHJvZHJpZ3Vlei5vcmciLCJpYXQiOjE3MjY2OTQ1MTQsImV4cCI6MTcyNjY5ODExNH0.7EQR3yBJhpC6hn7a8q-lw6AB8Z7ZDyofuW-doxx4BG7TbjFZkL0mevBBXnmtvQywac8IAi0k65YVeqluGz_-Gg");
        when(userRepository.findByEmail(anyString())).thenReturn(Optional.empty());
        when(userRepository.save(any(User.class))).thenReturn(user);

        var result = userServiceImpl.createUser(user);
        Assertions.assertNotNull(result);

        verify(userRepository).findByEmail(anyString());
        verify(userRepository).save(any(User.class));
        verify(jwtTokenProvider).generateToken(anyString());
    }

    @Test
    void testCreateUser_UserAlreadyExists() {
        when(userRepository.findByEmail(anyString())).thenReturn(Optional.of(UserFactory.build()));

        Assertions.assertThrows(ExistsEmailException.class, () -> {
            userServiceImpl.createUser(UserFactory.build());
        });
    }


    @Test
    void testGetUserById() {
        var user = UserFactory.build();
        when(userRepository.findById(any(UUID.class))).thenReturn(Optional.of(user));

        User result = userServiceImpl.getUserById(UUID.randomUUID());

        Assertions.assertNotNull(result);

        verify(userRepository).findById(any(UUID.class));
    }
}

