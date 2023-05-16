package com.andymazik.module3projects.repository;

import com.andymazik.module3projects.entity.Role;
import com.andymazik.module3projects.entity.User;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

public class UserRepository implements Repository<User>{
    private final Map<Long, User> map = new HashMap<>();
    public static final AtomicLong id = new AtomicLong(System.currentTimeMillis());

    public UserRepository() {
        map.put(1L, new User(1L, "user", "qwerty", Role.USER));
        map.put(2L, new User(2L, "guest", "", Role.GUEST));
        map.put(3L, new User(3L, "admin", "admin", Role.ADMIN ));
    }

    @Override
    public Collection<User> getAll() {
        return map.values();
    }

    @Override
    public Optional<User> get(long id) {
        return Optional.ofNullable(map.get(id));
    }

    @Override
    public void create(User entity) {
        entity.setId(id.incrementAndGet());
        update(entity);
    }

    @Override
    public void update(User entity) {
        map.put(entity.getId(), entity);
    }

    @Override
    public void delete(User entity) {
        map.remove(entity.getId());
    }
}
