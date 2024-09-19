package senior.pe.restful.domain.user.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import senior.pe.restful.api.exception.ExistsEmailException;
import senior.pe.restful.domain.user.model.User;
import senior.pe.restful.domain.user.repository.UserRepository;
import senior.pe.restful.domain.user.service.UserService;
import senior.pe.restful.infrastructure.security.JwtTokenProvider;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public User createUser(User user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new ExistsEmailException("El correo ya fue registrado.");
        }

        user.setId(UUID.randomUUID());
        user.setLastLogin(LocalDateTime.now());
        String token = jwtTokenProvider.generateToken(user.getEmail());
        user.setToken(token);

        if (user.getPhones() != null) {
            user.getPhones().forEach(phone -> phone.setUser(user));
        }

        return userRepository.save(user);
    }

    @Override
    public User getUserById(UUID id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User updateUser(User user) {
        if (userRepository.findById(user.getId()).isPresent()) {
            return userRepository.save(user);
        }
        return null;
    }

    @Override
    public boolean deleteUser(UUID id) {
        if (userRepository.findById(id).isPresent()) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}