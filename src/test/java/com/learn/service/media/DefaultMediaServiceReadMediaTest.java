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

    @Test
    public void givenNullMediaIdWhenReadMediaThenIllegalArgumentExceptionThrown() {

    }

    @Test
    public void givenInvalidMediaIdWhenReadMediaThenIllegalArgumentExceptionThrown() {

    }

    @Test
    public void givenNotExistMediaIdWhenReadMediaThenIllegalArgumentExceptionThrown() {

    }

    @Test
    public void givenValidMediaIdWhenReadMediaThenMediaIsUpdated() {

    }
}