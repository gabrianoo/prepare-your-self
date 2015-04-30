package com.learn.service.user;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class DefaultUserServiceReadAllUsersTest {

    private static final Integer validUserId = 1;
    private static final String validUserFirstName = "FirstName";
    private static final String validUserEmail = "email@email.com";
    private static UserService userService;

    @BeforeClass
    public static void setUp() {
        userService = new DefaultUserService();
        UserRepository userRepository = mock(UserRepository.class);
        ((DefaultUserService) userService).setUserRepository(userRepository);
        List<UserEntity> users = new ArrayList<>();
        users.add(buildValidUserEntity());
        users.add(buildValidUserEntity());
        doReturn(users).
                when(userRepository).findAll();
    }

    private static UserEntity buildValidUserEntity() {
        return UserEntity.newBuilder()
                .userId(validUserId)
                .userFirstName(validUserFirstName)
                .userEmail(validUserEmail)
                .build();
    }

    private static User buildValidUser() {
        return UserBusinessObject.newBuilder()
                .userId(validUserId)
                .userFirstName(validUserFirstName)
                .userEmail(validUserEmail)
                .build();
    }

    @Test
    public void whenReadAllUserThenAllSystemUsersAreReturned() {
        List<User> users = userService.readAllUsers();
        for (User user : users) {
            assertThat(user, equalTo(buildValidUser()));
        }
    }
}
