package com.learn.service.user;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.mockito.Mockito.spy;

public class DefaultUserServiceReadUserTest {

    private static UserService mediaService;

    @BeforeClass
    public static void setUp(){
        mediaService = spy(new DefaultUserService());
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenNullUserIdWhenReadUserThenIllegalArgumentExceptionThrown() {

    }

    @Test(expected = IllegalArgumentException.class)
    public void givenInvalidUserIdWhenReadUserThenIllegalArgumentExceptionThrown() {

    }

    @Test(expected = IllegalArgumentException.class)
    public void givenNotExistUserIdWhenReadUserThenIllegalArgumentExceptionThrown() {

    }

    @Test
    public void givenValidUserIdWhenReadUserThenUserIsUpdated() {

    }
}