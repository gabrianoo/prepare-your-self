package com.learn.service.user;

/**
 * The contract for the user business object implementation.
 */
public interface User {

    /**
     * Need the user Id to be able to track the user in our system.
     *
     * @return an {@link Integer} representing the userId.
     */
    Integer getUserId();

    /**
     * Need the user full name to be displayed in the frontend systems.
     *
     * @return a {@link String} representing the user full name.
     */
    String getUserFullName();

    /**
     * Need the user age to be displayed in the frontend system.
     *
     * @return a {@link Byte} representing the user age.
     */
    Byte getUserAge();

    /**
     * Need the user email to be displayed in the frontend.
     *
     * @return a {@link String} representing the user email address.
     */
    String getUserEmail();

    /**
     * Need the media Id to be able to fetch the user {@link com.learn.service.media.Media} information.
     *
     * @return an {@link Integer} representing the media Id.
     */
    Integer getMediaId();
}
