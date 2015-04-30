package com.learn.service.media;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.*;

public class DefaultMediaServiceUpdateMediaTest {

    private static final Integer validMediaId = 1;
    private static final Integer inValidMediaId = -1;
    private static final Integer nonExistMediaId = 2;
    private static final String validMediaName = "MediaName";
    private static final String validMediaExtension = "JPG";
    private static final byte[] validMediaBytes = validMediaName.getBytes();
    private static MediaService mediaService;
    private static MediaRepository mediaRepository;

    @BeforeClass
    public static void setUp() {
        mediaService = new DefaultMediaService();
        mediaRepository = mock(MediaRepository.class);
        ((DefaultMediaService) mediaService).setMediaRepository(mediaRepository);
        doNothing().
                when(mediaRepository).save(buildValidMediaEntity());
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
    public void givenNullMediaObjectWhenUpdateMediaThenIllegalArgumentExceptionThrown() {
        mediaService.updateMedia(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenNullMediaIdWhenCreateMediaThenIllegalArgumentExceptionThrown() {
        mediaService.updateMedia(
                MediaBusinessObject.newBuilder()
                        .mediaId(null)
                        .mediaName(validMediaName)
                        .mediaExtension(validMediaExtension)
                        .mediaBytes(validMediaBytes)
                        .build()
        );
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenInvalidMediaIdWhenUpdateMediaThenIllegalArgumentExceptionThrown() {
        mediaService.updateMedia(
                MediaBusinessObject.newBuilder()
                        .mediaId(inValidMediaId)
                        .mediaName(validMediaName)
                        .mediaExtension(validMediaExtension)
                        .mediaBytes(validMediaBytes)
                        .build()
        );
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenNotExistMediaIdWhenReadMediaThenIllegalArgumentExceptionThrown() {
        mediaService.updateMedia(
                MediaBusinessObject.newBuilder()
                        .mediaId(nonExistMediaId)
                        .mediaName(validMediaName)
                        .mediaExtension(validMediaExtension)
                        .mediaBytes(validMediaBytes)
                        .build()
        );
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenNullMediaBytesWhenCreateMediaThenIllegalArgumentExceptionThrown() {
        mediaService.updateMedia(
                MediaBusinessObject.newBuilder()
                        .mediaId(validMediaId)
                        .mediaName(validMediaName)
                        .mediaExtension(validMediaExtension)
                        .mediaBytes(null)
                        .build()
        );
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenNullMediaNameWhenCreateMediaThenIllegalArgumentExceptionThrown() {
        mediaService.updateMedia(
                MediaBusinessObject.newBuilder()
                        .mediaId(validMediaId)
                        .mediaName(null)
                        .mediaExtension(validMediaExtension)
                        .mediaBytes(validMediaBytes)
                        .build()
        );
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenNullMediaExtensionWhenCreateMediaThenIllegalArgumentExceptionThrown() {
        mediaService.updateMedia(
                MediaBusinessObject.newBuilder()
                        .mediaId(validMediaId)
                        .mediaName(validMediaName)
                        .mediaExtension(null)
                        .mediaBytes(validMediaBytes)
                        .build()
        );
    }

    @Test
    public void givenValidMediaObjectWhenUpdateMediaThenMediaIsUpdated() {
        mediaService.updateMedia(buildValidMedia());
        verify(mediaRepository, times(1)).save(buildValidMediaEntity());
    }
}