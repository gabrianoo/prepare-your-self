package com.learn.service.media;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.spy;

public class DefaultMediaServiceCreateMediaTest {

    private static MediaService mediaService;

    @BeforeClass
    public static void setUp(){
        mediaService = spy(new DefaultMediaService());
    }

    @Test
    public void givenNullMediaObjectWhenCreateMediaThenIllegalArgumentExceptionThrown() {

    }

    @Test
    public void givenNullMediaBytesWhenCreateMediaThenIllegalArgumentExceptionThrown() {

    }

    @Test
    public void givenNullMediaNameWhenCreateMediaThenIllegalArgumentExceptionThrown() {

    }

    @Test
    public void givenNullMediaExtensionWhenCreateMediaThenIllegalArgumentExceptionThrown() {

    }

    @Test
    public void givenValidMediaObjectWhenCreateMediaThenMediaIsStored() {

    }
}