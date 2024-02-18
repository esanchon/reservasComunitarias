package com.amenity_reservation_system.service;

import com.amenity_reservation_system.model.Usuario;
import com.amenity_reservation_system.repos.UserRepository;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Usuario> findAll() {
        return userRepository.findAll();
    }

    public Usuario get(final Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Usuario getUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    public Long create(final Usuario user) {
        return userRepository.save(user).getId();
    }

    public void update(final Long id, final Usuario user) {
        final Usuario existingUser = userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        userRepository.save(user);
    }

    public void delete(final Long id) {
        userRepository.deleteById(id);
    }
}