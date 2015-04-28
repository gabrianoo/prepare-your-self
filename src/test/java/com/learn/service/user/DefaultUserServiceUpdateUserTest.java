package com.learn.service.user;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.mockito.Mockito.spy;

public class DefaultUserServiceUpdateUserTest {

    private static UserService mediaService;

    @BeforeClass
    public static void setUp(){
        mediaService = spy(new DefaultUserService());
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenNullUserObjectWhenUpdateUserThenIllegalArgumentExceptionThrown() {

    }

    @Test(expected = IllegalArgumentException.class)
    public void givenNullUserIdWhenCreateUserThenIllegalArgumentExceptionThrown() {

    }

    @Test(expected = IllegalArgumentException.class)
    public void givenInvalidUserIdWhenUpdateUserThenIllegalArgumentExceptionThrown() {

    }

    @Test(expected = IllegalArgumentException.class)
    public void givenNotExistUserIdWhenReadUserThenIllegalArgumentExceptionThrown() {

    }

    @Test(expected = IllegalArgumentException.class)
    public void givenNullUserBytesWhenCreateUserThenIllegalArgumentExceptionThrown() {

    }

    @Test(expected = IllegalArgumentException.class)
    public void givenNullUserNameWhenCreateUserThenIllegalArgumentExceptionThrown() {

    }

    @Test(expected = IllegalArgumentException.class)
    public void givenNullUserExtensionWhenCreateUserThenIllegalArgumentExceptionThrown() {

    }

    @Test
    public void givenValidUserObjectWhenUpdateUserThenUserIsUpdated() {

    }
}