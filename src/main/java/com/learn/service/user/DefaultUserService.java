package com.learn.service.user;

import java.util.List;

public class DefaultUserService implements UserService {

    private UserRepository userRepository;

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        return null;
    }

    public User readUser(Integer userId) {
        return null;
    }

    public User updateUser(User user) {
        return null;
    }

    public void deleteUser(Integer userId) {
    }

    public List<User> readAllUsers() {
        return null;
    }
}
