package com.learn.management.profile;

import com.learn.service.media.MediaService;
import com.learn.service.user.UserService;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import java.util.List;

@Named
@Singleton
public class DefaultProfileManagement implements ProfileManagement {

    @Inject
    private UserService userService;
    @Inject
    private MediaService mediaService;

    public void registerProfile(Profile profile) {
    }

    public void unRegisterProfile(Integer profile) {
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
