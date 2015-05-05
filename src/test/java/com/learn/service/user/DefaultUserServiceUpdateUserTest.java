package com.learn.service.user;

import com.learn.configuration.TddSpringConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

import static org.mockito.Mockito.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TddSpringConfiguration.class)
public class DefaultUserServiceUpdateUserTest {

    private final Integer validUserId = 1;
    private final Integer nonExistUserId = 2;
    private final String validUserFirstName = "FirstName";
    private final String validUserEmail = "email@email.com";
    @Inject
    private UserService userService;
    @Inject
    private UserRepository userRepository;

    private UserEntity buildValidUserEntity() {
        return UserEntity.newBuilder()
                .userId(validUserId)
                .userFirstName(validUserFirstName)
                .userEmail(validUserEmail)
                .build();
    }

    private User buildValidUser() {
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
        final Integer inValidUserId = -1;
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
        doReturn(buildValidUserEntity()).
                when(userRepository).save(buildValidUserEntity());
        userService.updateUser(buildValidUser());
        verify(userRepository, times(1)).save(buildValidUserEntity());
    }
}