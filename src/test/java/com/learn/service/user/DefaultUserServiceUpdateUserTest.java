package com.learn.service.user;

import com.learn.service.media.MediaBusinessObject;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class DefaultUserServiceUpdateUserTest {

    private static final Integer validUserId = 1;
    private static final Integer inValidUserId = -1;
    private static final Integer nonExistUserId = 2;
    private static final String validUserFirstName = "FirstName";
    private static final String validUserEmail = "email@email.com";
    private static UserRepository userRepository;
    private static UserService userService;

    @BeforeClass
    public static void setUp() {
        userService = new DefaultUserService();
        userRepository = mock(UserRepository.class);
        ((DefaultUserService) userService).setUserRepository(userRepository);
        doNothing().
                when(userRepository).save(buildValidUserEntity());
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
    public void givenNullUserObjectWhenUpdateUserThenIllegalArgumentExceptionThrown() {
        userService.updateUser(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenNullUserIdWhenUpdateUserThenIllegalArgumentExceptionThrown() {
        userService.updateUser(
                UserBusinessObject.newBuilder()
                        .userId(null)
                        .userFirstName(validUserFirstName)
                        .userEmail(validUserEmail)
                        .build()
        );
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenInvalidUserIdWhenUpdateUserThenIllegalArgumentExceptionThrown() {
        userService.updateUser(
                UserBusinessObject.newBuilder()
                        .userId(inValidUserId)
                        .userFirstName(validUserFirstName)
                        .userEmail(validUserEmail)
                        .build()
        );
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenNotExistUserIdWhenUpdateUserThenIllegalArgumentExceptionThrown() {
        userService.updateUser(
                UserBusinessObject.newBuilder()
                        .userId(nonExistUserId)
                        .userFirstName(validUserFirstName)
                        .userEmail(validUserEmail)
                        .build()
        );
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenNullUserFirstNameWhenUpdateUserThenIllegalArgumentExceptionThrown() {
        userService.updateUser(
                UserBusinessObject.newBuilder()
                        .userId(validUserId)
                        .userFirstName(null)
                        .userEmail(validUserEmail)
                        .build()
        );
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenNullUserEmailWhenUpdateUserThenIllegalArgumentExceptionThrown() {
        userService.updateUser(
                UserBusinessObject.newBuilder()
                        .userId(nonExistUserId)
                        .userFirstName(validUserFirstName)
                        .userEmail(null)
                        .build()
        );
    }

    @Test
    public void givenValidUserObjectWhenUpdateUserThenUserIsUpdated() {
        userService.updateUser(buildValidUser());
        verify(userRepository, times(1)).save(buildValidUserEntity());
    }
}