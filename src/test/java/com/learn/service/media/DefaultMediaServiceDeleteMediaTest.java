package com.learn.service.media;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.mockito.Mockito.spy;

public class DefaultMediaServiceDeleteMediaTest {

    private static MediaService mediaService;

    @BeforeClass
    public static void setUp(){
        mediaService = spy(new DefaultMediaService());
    }

    @Test
    public void givenNullMediaIdWhenCreateMediaThenIllegalArgumentExceptionThrown() {

    }

    @Test
    public void givenInvalidMediaIdWhenUpdateMediaThenIllegalArgumentExceptionThrown() {

    }

    @Test
    public void givenNotExistMediaIdWhenReadMediaThenIllegalArgumentExceptionThrown() {

    }

    @Test
    public void givenValidMediaIdWhenUpdateMediaThenMediaIsDeleted() {

    }
}