package com.learn.service.media;

public class DefaultMediaService implements MediaService {

    private MediaRepository mediaRepository;

    public void setMediaRepository(MediaRepository mediaRepository) {
        this.mediaRepository = mediaRepository;
    }

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
