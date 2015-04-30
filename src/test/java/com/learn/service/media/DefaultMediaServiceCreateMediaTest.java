package com.learn.service.media;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class DefaultMediaServiceCreateMediaTest {

    private static final Integer validMediaId = 1;
    private static final String validMediaName = "MediaName";
    private static final String validMediaExtension = "JPG";
    private static final byte[] validMediaBytes = validMediaName.getBytes();
    private static MediaService mediaService;

    @BeforeClass
    public static void setUp() {
        MediaRepository mediaRepository = mock(MediaRepository.class);
        mediaService = new DefaultMediaService();
        ((DefaultMediaService) mediaService).setMediaRepository(mediaRepository);
        doReturn(buildValidMedia()).
                when(mediaRepository.save(buildValidMediaEntity()));
    }

    private static MediaEntity buildValidMediaEntity() {
        return MediaEntity.newBuilder()
                .mediaId(validMediaId)
                .mediaName(validMediaName)
                .mediaExtension(validMediaExtension)
                .mediaBytes(validMediaBytes)
                .build();
    }

    private static Media buildValidMedia() {
        return MediaBusinessObject.newBuilder()
                .mediaId(validMediaId)
                .mediaName(validMediaName)
                .mediaExtension(validMediaExtension)
                .mediaBytes(validMediaBytes)
                .build();
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenNullMediaObjectWhenCreateMediaThenIllegalArgumentExceptionThrown() {
        mediaService.createMedia(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenNullMediaBytesWhenCreateMediaThenIllegalArgumentExceptionThrown() {
        mediaService.createMedia(
                MediaBusinessObject.newBuilder()
                        .mediaName(validMediaName)
                        .mediaExtension(validMediaExtension)
                        .mediaBytes(null)
                        .build()
        );
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenNullMediaNameWhenCreateMediaThenIllegalArgumentExceptionThrown() {
        mediaService.createMedia(
                MediaBusinessObject.newBuilder()
                        .mediaName(null)
                        .mediaExtension(validMediaExtension)
                        .mediaBytes(validMediaBytes)
                        .build()
        );
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenNullMediaExtensionWhenCreateMediaThenIllegalArgumentExceptionThrown() {
        mediaService.createMedia(
                MediaBusinessObject.newBuilder()
                        .mediaName(validMediaName)
                        .mediaExtension(null)
                        .mediaBytes(validMediaBytes)
                        .build()
        );
    }

    @Test
    public void givenValidMediaObjectWhenCreateMediaThenMediaIsStored() {
        Media media = mediaService.createMedia(
                MediaBusinessObject.newBuilder()
                        .mediaName(validMediaName)
                        .mediaExtension(validMediaExtension)
                        .mediaBytes(validMediaBytes)
                        .build()
        );
        assertThat(media, equalTo(buildValidMedia()));
    }
}