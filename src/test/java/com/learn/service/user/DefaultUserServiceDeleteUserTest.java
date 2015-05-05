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
public class DefaultUserServiceDeleteUserTest {

    @Inject
    private UserService userService;
    @Inject
    private UserRepository userRepository;

    @Test(expected = IllegalArgumentException.class)
    public void givenNullUserIdWhenCreateUserThenIllegalArgumentExceptionThrown() {
        userService.deleteUser(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenInvalidUserIdWhenUpdateUserThenIllegalArgumentExceptionThrown() {
        final Integer inValidUserId = -1;
        userService.deleteUser(inValidUserId);
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenNotExistUserIdWhenReadUserThenIllegalArgumentExceptionThrown() {
        final Integer nonExistUserId = 2;
        userService.deleteUser(nonExistUserId);
    }

    @Test
    public void givenValidUserIdWhenUpdateUserThenUserIsDeleted() {
        final Integer validUserId = 1;
        doNothing()
                .when(userRepository).delete(eq(validUserId));
        userService.deleteUser(validUserId);
        verify(userRepository, times(1)).delete(validUserId);
    }
}