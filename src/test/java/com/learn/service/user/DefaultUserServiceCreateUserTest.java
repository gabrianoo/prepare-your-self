package com.learn.service.user;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.mockito.Mockito.spy;

public class DefaultUserServiceCreateUserTest {

    private static UserService userService;

    @BeforeClass
    public static void setUp(){
        userService = spy(new DefaultUserService());
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenNullUserObjectWhenCreateUserThenIllegalArgumentExceptionThrown() {

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
    public void givenValidUserObjectWhenCreateUserThenMediaIsStored() {

    }
}