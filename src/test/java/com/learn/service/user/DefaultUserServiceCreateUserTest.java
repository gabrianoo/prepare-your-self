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

    @Test
    public void givenNullUserObjectWhenCreateUserThenIllegalArgumentExceptionThrown() {

    }

    @Test
    public void givenNullUserBytesWhenCreateUserThenIllegalArgumentExceptionThrown() {

    }

    @Test
    public void givenNullUserNameWhenCreateUserThenIllegalArgumentExceptionThrown() {

    }

    @Test
    public void givenNullUserExtensionWhenCreateUserThenIllegalArgumentExceptionThrown() {

    }

    @Test
    public void givenValidUserObjectWhenCreateUserThenMediaIsStored() {

    }
}