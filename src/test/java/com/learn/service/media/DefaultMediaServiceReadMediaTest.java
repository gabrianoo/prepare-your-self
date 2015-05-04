package com.learn.service.media;

import com.learn.configuration.SpringTestConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import javax.inject.Named;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.doReturn;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringTestConfiguration.class)
public class DefaultMediaServiceReadMediaTest {

    private final Integer validMediaId = 1;
    private final String validMediaName = "MediaName";
    private final String validMediaExtension = "JPG";
    private final byte[] validMediaBytes = validMediaName.getBytes();
    @Inject
    private MediaService mediaService;
    @Inject
    private MediaRepository mediaRepository;

    private MediaEntity buildValidMediaEntity() {
        return MediaEntity.newBuilder()
                .mediaId(validMediaId)
                .mediaName(validMediaName)
                .mediaExtension(validMediaExtension)
                .mediaBytes(validMediaBytes)
                .build();
    }

    private Media buildValidMedia() {
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
        final Integer inValidMediaId = -1;
        mediaService.readMedia(inValidMediaId);
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenNotExistMediaIdWhenReadMediaThenIllegalArgumentExceptionThrown() {
        final Integer nonExistMediaId = 2;
        mediaService.readMedia(nonExistMediaId);
    }

    @Test
    public void givenValidMediaIdWhenReadMediaThenMediaIsUpdated() {
        doReturn(buildValidMediaEntity())
                .when(mediaRepository).findOne(validMediaId);
        Media media = mediaService.readMedia(validMediaId);
        assertThat(media, equalTo(buildValidMedia()));
    }
}