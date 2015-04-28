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

    public Media updateMedia(Media media) {
        return null;
    }

    public void deleteMedia(Integer mediaId) {
    }
}
