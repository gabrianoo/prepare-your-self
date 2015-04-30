package com.learn.management.profile;

import com.learn.service.media.MediaService;
import com.learn.service.user.UserService;

import java.util.List;

public class DefaultProfileManagement implements ProfileManagement {

    private UserService userService;
    private MediaService mediaService;

    public void registerProfile(Profile profile) {
    }

    public void unRegisterProfile(Profile profile) {
    }

    public void updateProfile(Profile profile) {
    }

    public Profile fetchProfile(Integer profileId) {
        return null;
    }

    public List<Profile> fetchAllProfiles() {
        return null;
    }
}
