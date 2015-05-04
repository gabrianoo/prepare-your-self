package com.learn.service.media;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

@Named
@Singleton
public class DefaultMediaService implements MediaService {

    @Inject
    private MediaRepository mediaRepository;

    public Media createMedia(Media media) {
        return null;
    }

    public Media readMedia(Integer mediaId) {
        return null;
    }

    public void updateMedia(Media media) {
    }

    public void deleteMedia(Integer mediaId) {
    }
}
