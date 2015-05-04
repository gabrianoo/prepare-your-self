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
public class DefaultMediaServiceUpdateMediaTest {

    private final Integer validMediaId = 1;
    private final String validMediaName = "MediaName";
    private final String validMediaExtension = "JPG";
    private final byte[] validMediaBytes = validMediaName.getBytes();
    @Inject
    @Named("defaultMediaService")
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
    public void givenNullMediaObjectWhenUpdateMediaThenIllegalArgumentExceptionThrown() {
        mediaService.updateMedia(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenNullMediaIdWhenUpdateMediaThenIllegalArgumentExceptionThrown() {
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
        final Integer inValidMediaId = -1;
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
    public void givenNotExistMediaIdWhenUpdateMediaThenIllegalArgumentExceptionThrown() {
        final Integer nonExistMediaId = 2;
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
    public void givenNullMediaBytesWhenUpdateMediaThenIllegalArgumentExceptionThrown() {
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
    public void givenNullMediaNameWhenUpdateMediaThenIllegalArgumentExceptionThrown() {
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
    public void givenNullMediaExtensionWhenUpdateMediaThenIllegalArgumentExceptionThrown() {
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
        doReturn(buildValidMediaEntity()).
                when(mediaRepository).save(buildValidMediaEntity());
        mediaService.updateMedia(buildValidMedia());
        verify(mediaRepository, times(1)).save(buildValidMediaEntity());
    }
}