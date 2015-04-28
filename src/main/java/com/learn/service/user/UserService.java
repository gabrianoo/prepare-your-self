package com.learn.service.user;

import java.util.List;

/**
 * This interface is responsible for manipulating basic user operations.
 */
public interface UserService {

    /**
     * Create a new {@link User} in the system
     *
     * @param user business object that holds all the details for the user.
     * @return a {@link User} business object that holds all the details for the user.
     */
    User createUser(User user);

    /**
     * Read a saved {@link User} from the system given this user Id.
     *
     * @param userId as {@link Integer} representing the user Id.
     * @return a {@link User} business object that holds all the details for the user.
     */
    User readUser(Integer userId);

    /**
     * Update a saved {@link User} from the system given the new user information.
     *
     * @param user business object that holds all the details for the user.
     */
    void updateUser(User user);

    /**
     * Delete an existing {@link User} in the system.
     *
     * @param userId as {@link Integer} representing the user Id.
     */
    void deleteUser(Integer userId);

    /**
     * Read all the saved users from the system.
     *
     * @return {@link List} of business objects that holds all the details for the user.
     */
    List<User> readAllUsers();
}
