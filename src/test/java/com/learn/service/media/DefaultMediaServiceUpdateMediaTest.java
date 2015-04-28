package com.learn.service.media;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.mockito.Mockito.spy;

public class DefaultMediaServiceUpdateMediaTest {

    private static MediaService mediaService;

    @BeforeClass
    public static void setUp(){
        mediaService = spy(new DefaultMediaService());
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenNullMediaObjectWhenUpdateMediaThenIllegalArgumentExceptionThrown() {

    }

    @Test(expected = IllegalArgumentException.class)
    public void givenNullMediaIdWhenCreateMediaThenIllegalArgumentExceptionThrown() {

    }

    @Test(expected = IllegalArgumentException.class)
    public void givenInvalidMediaIdWhenUpdateMediaThenIllegalArgumentExceptionThrown() {

    }

    @Test(expected = IllegalArgumentException.class)
    public void givenNotExistMediaIdWhenReadMediaThenIllegalArgumentExceptionThrown() {

    }

    @Test(expected = IllegalArgumentException.class)
    public void givenNullMediaBytesWhenCreateMediaThenIllegalArgumentExceptionThrown() {

    }

    @Test(expected = IllegalArgumentException.class)
    public void givenNullMediaNameWhenCreateMediaThenIllegalArgumentExceptionThrown() {

    }

    @Test(expected = IllegalArgumentException.class)
    public void givenNullMediaExtensionWhenCreateMediaThenIllegalArgumentExceptionThrown() {

    }

    @Test
    public void givenValidMediaObjectWhenUpdateMediaThenMediaIsUpdated() {

    }
}