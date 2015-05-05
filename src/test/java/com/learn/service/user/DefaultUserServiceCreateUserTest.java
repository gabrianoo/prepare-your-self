package com.learn.service.user;

import com.learn.configuration.TddSpringConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.mockito.Mockito.doReturn;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TddSpringConfiguration.class)
public class DefaultUserServiceCreateUserTest {

    private final Integer validUserId = 1;
    private final String validUserFirstName = "FirstName";
    private final String validUserEmail = "email@email.com";
    @Inject
    private UserService userService;
    @Inject
    private UserRepository userRepository;

    private User buildValidUser() {
        return UserBusinessObject.newBuilder()
                .userId(validUserId)
                .userFirstName(validUserFirstName)
                .userEmail(validUserEmail)
                .build();
    }

    private UserEntity buildValidUserEntity() {
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
        doReturn(buildValidUserEntity()).
                when(userRepository).save(buildValidUserEntity());
        User user = userService.createUser(
                UserBusinessObject.newBuilder()
                        .userFirstName(validUserFirstName)
                        .userEmail(validUserEmail)
                        .build()
        );
        assertThat(user, equalTo(buildValidUser()));
    }
}