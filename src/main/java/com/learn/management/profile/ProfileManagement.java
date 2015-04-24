package com.learn.management.profile;

import java.util.List;

/**
 * This interface is responsible for manipulating the high level application features.
 */
public interface ProfileManagement {

    /**
     * The user should be able to register a profile in our system.
     *
     * @param profile a {@link Profile} instance that represent the complete user profile the user want to register.
     */
    void registerProfile(Profile profile);

    /**
     * The user should be able to un-register (remove) his profile from our system.
     *
     * @param profile a {@link Profile} instance that represent the complete user profile the user want to register.
     */
    void unRegisterProfile(Profile profile);

    /**
     * The user should be able to update his profile in our system.
     *
     * @param profile a {@link Profile} instance that represent the complete user profile the user want to register.
     */
    void updateProfile(Profile profile);

    /**
     * The user should be able to fetch any specific profile in our system.
     *
     * @param profileId an {@link Integer} representing the user id that we want to fetch his complete profile.
     * @return a {@link Profile} instance representing the
     */
    Profile fetchProfile(Integer profileId);

    /**
     * The user should be able to view all the profiles registered in our system.
     *
     * @return a {@link List} of {@link Profile} instances that represent the profiles registered in our system.
     */
    List<Profile> fetshAllProfiles();
}
