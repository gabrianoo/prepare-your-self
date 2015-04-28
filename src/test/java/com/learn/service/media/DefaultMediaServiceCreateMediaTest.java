package com.learn.service.media;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.fail;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class DefaultMediaServiceCreateMediaTest {

    private final String dummyMediaName;
    private final String dummyMediaExtension;
    private final byte[] dummyMediaBytes;
    {
        dummyMediaName = "MediaName";
        dummyMediaExtension = "JPG";
        dummyMediaBytes = dummyMediaName.getBytes();
    }
    private static MediaService mediaService;

    @BeforeClass
    public static void setUp() {
        mediaService = spy(new DefaultMediaService());
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenNullMediaObjectWhenCreateMediaThenIllegalArgumentExceptionThrown() {
        mediaService.createMedia(null);
        fail();
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenNullMediaBytesWhenCreateMediaThenIllegalArgumentExceptionThrown() {
        mediaService.createMedia(
                MediaBusinessObject.newBuilder()
                        .mediaName(dummyMediaName)
                        .mediaExtension(dummyMediaExtension)
                        .mediaBytes(null)
                        .build()
        );
        fail();
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenNullMediaNameWhenCreateMediaThenIllegalArgumentExceptionThrown() {
        mediaService.createMedia(
                MediaBusinessObject.newBuilder()
                        .mediaName(null)
                        .mediaExtension(dummyMediaExtension)
                        .mediaBytes(dummyMediaBytes)
                        .build()
        );
        fail();
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenNullMediaExtensionWhenCreateMediaThenIllegalArgumentExceptionThrown() {
        mediaService.createMedia(
                MediaBusinessObject.newBuilder()
                        .mediaName(dummyMediaName)
                        .mediaExtension(null)
                        .mediaBytes(dummyMediaBytes)
                        .build()
        );
        fail();
    }

    @Test
    public void givenValidMediaObjectWhenCreateMediaThenMediaIsStored() {
        verify(mediaService, times(1)).createMedia(
                MediaBusinessObject.newBuilder()
                        .mediaName(dummyMediaName)
                        .mediaExtension(dummyMediaExtension)
                        .mediaBytes(dummyMediaBytes)
                        .build()
        );
    }
}