package com.learn.service.media;

import com.learn.configuration.SpringTestConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import javax.inject.Named;

import static org.mockito.Mockito.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringTestConfiguration.class)
public class DefaultMediaServiceDeleteMediaTest {

    @Inject
    private MediaService mediaService;
    @Inject
    private MediaRepository mediaRepository;

    @Test(expected = IllegalArgumentException.class)
    public void givenNullMediaIdWhenCreateMediaThenIllegalArgumentExceptionThrown() {
        mediaService.deleteMedia(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenInvalidMediaIdWhenUpdateMediaThenIllegalArgumentExceptionThrown() {
        final Integer inValidMediaId = -1;
        mediaService.deleteMedia(inValidMediaId);
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenNotExistMediaIdWhenReadMediaThenIllegalArgumentExceptionThrown() {
        final Integer nonExistMediaId = 2;
        mediaService.deleteMedia(nonExistMediaId);
    }

    @Test
    public void givenValidMediaIdWhenUpdateMediaThenMediaIsDeleted() {
        final Integer validMediaId = 1;
        doNothing()
                .when(mediaRepository).delete(eq(validMediaId));
        mediaService.deleteMedia(validMediaId);
        verify(mediaRepository, times(1)).delete(validMediaId);
    }
}