package com.example.newone;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final Map<Long, User> userStore = new HashMap<>();
    private long idCounter = 1;

    public User createUser(User user) {
        user.setId(idCounter++);
        userStore.put(user.getId(), user);
        return user;
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(userStore.values());
    }

    public User getUserById(Long id) {
        return userStore.get(id);
    }

    public User updateUser(Long id, User user) {
        user.setId(id);
        userStore.put(id, user);
        return user;
    }

    public void deleteUser(Long id) {
        userStore.remove(id);
    }
} 