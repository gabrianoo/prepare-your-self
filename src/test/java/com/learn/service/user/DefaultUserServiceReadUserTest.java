package com.learn.service.user;

import com.learn.configuration.SpringTestConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import javax.inject.Named;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.doReturn;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringTestConfiguration.class)
public class DefaultUserServiceReadUserTest {

    private final Integer validUserId = 1;
    private final String validUserFirstName = "FirstName";
    private final String validUserEmail = "email@email.com";
    @Inject
    @Named("defaultUserService")
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
    public void givenNullUserIdWhenReadUserThenIllegalArgumentExceptionThrown() {
        userService.readUser(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenInvalidUserIdWhenReadUserThenIllegalArgumentExceptionThrown() {
        final Integer inValidUserId = -1;
        userService.readUser(inValidUserId);
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenNotExistUserIdWhenReadUserThenIllegalArgumentExceptionThrown() {
        final Integer nonExistUserId = 2;
        userService.readUser(nonExistUserId);
    }

    @Test
    public void givenValidUserIdWhenReadUserThenUserIsUpdated() {
        doReturn(buildValidUserEntity()).
                when(userRepository).findOne(validUserId);
        User user = userService.readUser(validUserId);
        assertThat(user, equalTo(buildValidUser()));
    }
}