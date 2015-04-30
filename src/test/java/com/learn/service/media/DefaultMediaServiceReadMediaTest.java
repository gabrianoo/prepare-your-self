package com.learn.service.media;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class DefaultMediaServiceReadMediaTest {

    private static final Integer validMediaId = 1;
    private static final String validMediaName = "MediaName";
    private static final String validMediaExtension = "JPG";
    private static final byte[] validMediaBytes = validMediaName.getBytes();
    private static final Integer inValidMediaId = -1;
    private static final Integer nonExistMediaId = 2;
    private static MediaService mediaService;

    @BeforeClass
    public static void setUp() {
        mediaService = new DefaultMediaService();
        MediaRepository mediaRepository = mock(MediaRepository.class);
        ((DefaultMediaService) mediaService).setMediaRepository(mediaRepository);
        doReturn(buildValidMediaEntity())
                .when(mediaRepository.findOne(validMediaId));
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
    public void givenNullMediaIdWhenReadMediaThenIllegalArgumentExceptionThrown() {
        mediaService.readMedia(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenInvalidMediaIdWhenReadMediaThenIllegalArgumentExceptionThrown() {
        mediaService.readMedia(inValidMediaId);
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenNotExistMediaIdWhenReadMediaThenIllegalArgumentExceptionThrown() {
        mediaService.readMedia(nonExistMediaId);
    }

    @Test
    public void givenValidMediaIdWhenReadMediaThenMediaIsUpdated() {
        Media media = mediaService.readMedia(validMediaId);
        assertThat(media, equalTo(buildValidMedia()));
    }
}