package com.andymazik.module3projects.service;

import com.andymazik.module3projects.entity.User;
import com.andymazik.module3projects.repository.Repository;
import com.andymazik.module3projects.repository.UserRepository;

import java.util.Collection;
import java.util.Optional;

@SuppressWarnings("unused")
public enum UserService {

    USER_SERVICE;

    private final Repository<User> userRepository = new UserRepository();

    public void create(User user) {
        userRepository.create(user);
    }

    public void update(User user) {
        userRepository.update(user);
    }

    public void delete(User user) {
        userRepository.delete(user);
    }

    public Collection<User> getAll() {
        return userRepository.getAll();
    }

    public Optional<User> get(Long id) {
        return userRepository.get(id);
    }
}
