package com.learn.service.user;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class DefaultUserServiceCreateUserTest {

    private static final Integer validUserId = 1;
    private static final String validUserFirstName = "FirstName";
    private static final String validUserEmail = "email@email.com";
    private static UserService userService;

    @BeforeClass
    public static void setUp() {
        UserRepository userRepository = mock(UserRepository.class);
        userService = new DefaultUserService();
        ((DefaultUserService) userService).setUserRepository(userRepository);
        doReturn(buildValidUser()).
                when(userRepository.save(buildValidUserEntity()));
    }

    private static User buildValidUser() {
        return UserBusinessObject.newBuilder()
                .userId(validUserId)
                .userFirstName(validUserFirstName)
                .userEmail(validUserEmail)
                .build();
    }

    private static UserEntity buildValidUserEntity() {
        return UserEntity.newBuilder()
                .userId(validUserId)
                .userFirstName(validUserFirstName)
                .userEmail(validUserEmail)
                .build();
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenNullUserObjectWhenCreateUserThenIllegalArgumentExceptionThrown() {
        userService.createUser(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenNullUserFirstNameWhenCreateUserThenIllegalArgumentExceptionThrown() {
        userService.createUser(
                UserBusinessObject.newBuilder()
                        .userFirstName(null)
                        .userEmail(validUserEmail)
                        .build());
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenNullUserEmailWhenCreateUserThenIllegalArgumentExceptionThrown() {
        userService.createUser(
                UserBusinessObject.newBuilder()
                        .userFirstName(validUserFirstName)
                        .userEmail(null)
                        .build());
    }

    @Test
    public void givenValidUserObjectWhenCreateUserThenUserIsStored() {
        User user = userService.createUser(
                UserBusinessObject.newBuilder()
                        .userFirstName(validUserFirstName)
                        .userEmail(validUserEmail)
                        .build()
        );
        assertThat(user, equalTo(buildValidUser()));
    }
}