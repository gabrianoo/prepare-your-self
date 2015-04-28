package com.learn.service.media;

/**
 * This interface is responsible for manipulating media operations.
 */
public interface MediaService {

    /**
     * Create a new {@link Media} in the system
     *
     * @param media business object that holds all the details for the media.
     * @return a {@link Media} business object that holds all the details for the media.
     */
    Media createMedia(Media media);

    /**
     * Read a saved {@link Media} from the system given this media Id.
     *
     * @param mediaId as {@link Integer} representing the media Id.
     * @return a {@link Media} business object that holds all the details for the media.
     */
    Media readMedia(Integer mediaId);

    /**
     * Update a saved {@link Media} from the system given the new user information.
     *
     * @param media business object that holds all the details for the media.
     */
    void updateMedia(Media media);

    /**
     * Delete an existing {@link Media} in the system.
     *
     * @param mediaId as {@link Integer} representing the media Id.
     */
    void deleteMedia(Integer mediaId);
}
