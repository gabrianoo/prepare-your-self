package com.learn.management.profile;

import com.google.common.base.Objects;
import com.learn.service.media.Media;
import com.learn.service.user.User;

import java.io.Serializable;
import java.util.Calendar;

public class Profile implements Serializable {

    private User user;
    private Media media;

    private Profile(Builder builder) {
        this.user = builder.user;
        this.media = builder.media;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Media getMedia() {
        return media;
    }

    public void setMedia(Media media) {
        this.media = media;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profile profile = (Profile) o;
        return Objects.equal(user, profile.user) &&
                Objects.equal(media, profile.media);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(user, media);
    }

    @Override
    public String toString() {
        return "Profile{" +
                "user=" + user +
                ", media=" + media +
                '}';
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static final class Builder {

        private User user;
        private Media media;

        private Builder() {
        }

        public Builder user(User user) {
            this.user = user;
            return this;
        }

        public Builder media(Media media) {
            this.media = media;
            return this;
        }

        public Profile build() {
            return new Profile(this);
        }
    }
}
