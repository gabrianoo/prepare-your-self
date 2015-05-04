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
public class DefaultMediaServiceCreateMediaTest {

    private Integer validMediaId = 1;
    private String validMediaName = "MediaName";
    private String validMediaExtension = "JPG";
    private byte[] validMediaBytes = validMediaName.getBytes();
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
        doReturn(buildValidMedia()).
                when(mediaRepository.save(buildValidMediaEntity()));
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