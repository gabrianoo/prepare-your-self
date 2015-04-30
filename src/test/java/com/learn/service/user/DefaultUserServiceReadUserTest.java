package com.learn.service.user;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.*;

public class DefaultUserServiceReadUserTest {

    private static final Integer validUserId = 1;
    private static final Integer inValidUserId = -1;
    private static final Integer nonExistUserId = 2;
    private static final String validUserFirstName = "FirstName";
    private static final String validUserEmail = "email@email.com";
    private static UserService userService;

    @BeforeClass
    public static void setUp() {
        userService = new DefaultUserService();
        UserRepository userRepository = mock(UserRepository.class);
        ((DefaultUserService) userService).setUserRepository(userRepository);
        doReturn(buildValidUserEntity()).
                when(userRepository).findOne(validUserId);
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

    @Test(expected = IllegalArgumentException.class)
    public void givenNullUserIdWhenReadUserThenIllegalArgumentExceptionThrown() {
        userService.readUser(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenInvalidUserIdWhenReadUserThenIllegalArgumentExceptionThrown() {
        userService.readUser(inValidUserId);
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenNotExistUserIdWhenReadUserThenIllegalArgumentExceptionThrown() {
        userService.readUser(nonExistUserId);
    }

    @Test
    public void givenValidUserIdWhenReadUserThenUserIsUpdated() {
        User user = userService.readUser(validUserId);
        assertThat(user, equalTo(buildValidUser()));
    }
}