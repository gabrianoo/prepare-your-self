package com.learn.service.media;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.mockito.Mockito.spy;

public class DefaultMediaServiceReadMediaTest {

    private static MediaService mediaService;

    @BeforeClass
    public static void setUp(){
        mediaService = spy(new DefaultMediaService());
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenNullMediaIdWhenReadMediaThenIllegalArgumentExceptionThrown() {

    }

    @Test(expected = IllegalArgumentException.class)
    public void givenInvalidMediaIdWhenReadMediaThenIllegalArgumentExceptionThrown() {

    }

    @Test(expected = IllegalArgumentException.class)
    public void givenNotExistMediaIdWhenReadMediaThenIllegalArgumentExceptionThrown() {

    }

    @Test
    public void givenValidMediaIdWhenReadMediaThenMediaIsUpdated() {

    }
}