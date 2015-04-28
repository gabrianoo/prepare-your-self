package com.learn.service.media;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.fail;
import static org.mockito.Mockito.*;

public class DefaultMediaServiceDeleteMediaTest {


    private static final Integer validMediaId = 1;
    private static final Integer inValidMediaId = -1;
    private static final Integer nonExistMediaId = 2;
    private static MediaService mediaService;
    private static MediaRepository mediaRepository;

    @BeforeClass
    public static void setUp() {
        mediaService = new DefaultMediaService();
        mediaRepository = mock(MediaRepository.class);
        ((DefaultMediaService) mediaService).setMediaRepository(mediaRepository);
        doThrow(new IllegalArgumentException())
                .when(mediaRepository).delete(eq(nonExistMediaId));
        doNothing()
                .when(mediaRepository).delete(eq(validMediaId));
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenNullMediaIdWhenCreateMediaThenIllegalArgumentExceptionThrown() {
        mediaService.deleteMedia(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenInvalidMediaIdWhenUpdateMediaThenIllegalArgumentExceptionThrown() {
        mediaService.deleteMedia(inValidMediaId);
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenNotExistMediaIdWhenReadMediaThenIllegalArgumentExceptionThrown() {
        mediaService.deleteMedia(nonExistMediaId);
    }

    @Test
    public void givenValidMediaIdWhenUpdateMediaThenMediaIsDeleted() {
        mediaService.deleteMedia(validMediaId);
        verify(mediaRepository, times(1))
                .delete(validMediaId);
    }
}