package com.learn.service.media;

import java.io.Serializable;

/**
 * The contract for the media business object implementation.
 */
public interface Media extends Serializable {

    /**
     * @return an {@link Integer} representing the mediaId.
     */
    Integer getMediaId();

    /**
     * @return a {@link String} representing the media name.
     */
    String getMediaName();

    /**
     * @return a {@link String} representing the media extension.
     */
    String getMediaExtension();

    /**
     * @return a byte[] representing the media data.
     */
    byte[] getMediaBytes();
}