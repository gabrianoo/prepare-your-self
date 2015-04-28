package com.learn.service.media;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;

public class DefaultMediaServiceCreateMediaTest {

    private static final Integer dummyMediaId = 1;
    private static final String dummyMediaName = "MediaName";
    private static final String dummyMediaExtension = "JPG";
    private static final byte[] dummyMediaBytes = dummyMediaName.getBytes();
    private static MediaService mediaService;
    private static final Media dummyMedia = MediaBusinessObject.newBuilder()
            .mediaId(dummyMediaId)
            .mediaName(dummyMediaName)
            .mediaExtension(dummyMediaExtension)
            .mediaBytes(dummyMediaBytes)
            .build();

    @BeforeClass
    public static void setUp() {
        MediaRepository mediaRepository = mock(MediaRepository.class);
        mediaService = new DefaultMediaService();
        ((DefaultMediaService) mediaService).setMediaRepository(mediaRepository);
        stub(mediaRepository.save(
                MediaEntity.newBuilder()
                        .mediaName(dummyMediaName)
                        .mediaExtension(dummyMediaExtension)
                        .mediaBytes(dummyMediaBytes)
                        .build()
        )).toReturn(
                MediaEntity.newBuilder()
                        .mediaId(dummyMediaId)
                        .mediaName(dummyMediaName)
                        .mediaExtension(dummyMediaExtension)
                        .mediaBytes(dummyMediaBytes)
                        .build()
        );
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenNullMediaObjectWhenCreateMediaThenIllegalArgumentExceptionThrown() {
        mediaService.createMedia(null);
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
    }

    @Test
    public void givenValidMediaObjectWhenCreateMediaThenMediaIsStored() {
        Media media = mediaService.createMedia(
                MediaBusinessObject.newBuilder()
                        .mediaName(dummyMediaName)
                        .mediaExtension(dummyMediaExtension)
                        .mediaBytes(dummyMediaBytes)
                        .build()
        );
        assertThat(media, equalTo(dummyMedia));
    }
}