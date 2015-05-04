package com.learn.service.user;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import java.util.List;

@Named
@Singleton
public class DefaultUserService implements UserService {

    @Inject
    private UserRepository userRepository;

    public User createUser(User user) {
        return null;
    }

    public User readUser(Integer userId) {
        return null;
    }

    public void updateUser(User user) {
    }

    public void deleteUser(Integer userId) {
    }

    public List<User> readAllUsers() {
        return null;
    }
}
