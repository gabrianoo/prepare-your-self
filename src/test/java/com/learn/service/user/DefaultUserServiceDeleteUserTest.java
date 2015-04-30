package com.learn.service.user;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class DefaultUserServiceDeleteUserTest {

    private static final Integer validUserId = 1;
    private static final Integer inValidUserId = -1;
    private static final Integer nonExistUserId = 2;
    private static UserService userService;
    private static UserRepository userRepository;

    @BeforeClass
    public static void setUp(){
        userRepository = mock(UserRepository.class);
        userService = new DefaultUserService();
        ((DefaultUserService) userService).setUserRepository(userRepository);
        doNothing()
                .when(userRepository).delete(eq(validUserId));
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenNullUserIdWhenCreateUserThenIllegalArgumentExceptionThrown() {
        userService.deleteUser(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenInvalidUserIdWhenUpdateUserThenIllegalArgumentExceptionThrown() {
        userService.deleteUser(inValidUserId);
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenNotExistUserIdWhenReadUserThenIllegalArgumentExceptionThrown() {
        userService.deleteUser(nonExistUserId);
    }

    @Test
    public void givenValidUserIdWhenUpdateUserThenUserIsDeleted() {
        userService.deleteUser(validUserId);
        verify(userRepository, times(1)).delete(validUserId);
    }
}