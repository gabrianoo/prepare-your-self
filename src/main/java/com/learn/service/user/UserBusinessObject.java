package com.learn.service.user;

import java.util.Calendar;

import static java.util.Calendar.YEAR;

public class UserBusinessObject implements User {

    private Integer userId;
    private String userFirstName;
    private String userLastName;
    private Calendar userDateOfBirth;
    private String userEmail;
    private Integer mediaId;

    private UserBusinessObject(Builder builder) {
        this.userId = builder.userId;
        this.userFirstName = builder.userFirstName;
        this.userLastName = builder.userLastName;
        this.userDateOfBirth = builder.userDateOfBirth;
        this.userEmail = builder.userEmail;
        this.mediaId = builder.mediaId;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getUserFullName() {
        return String.join(userFirstName, " ", userLastName);
    }

    public Byte getUserAge() {
        return (byte) (Calendar.getInstance().get(YEAR) - userDateOfBirth.get(YEAR));
    }

    public String getUserEmail() {
        return userEmail;
    }

    public Integer getMediaId() {
        return mediaId;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static final class Builder {

        private Integer userId;
        private String userFirstName;
        private String userLastName;
        private Calendar userDateOfBirth;
        private String userEmail;
        private Integer mediaId;

        private Builder() {
        }

        public Builder userId(Integer userId) {
            this.userId = userId;
            return this;
        }

        public Builder userFirstName(String userFirstName) {
            this.userFirstName = userFirstName;
            return this;
        }

        public Builder userLastName(String userLastName) {
            this.userLastName = userLastName;
            return this;
        }

        public Builder userDateOfBirth(Calendar userDateOfBirth) {
            this.userDateOfBirth = userDateOfBirth;
            return this;
        }

        public Builder userEmail(String userEmail) {
            this.userEmail = userEmail;
            return this;
        }

        public Builder mediaId(Integer mediaId) {
            this.mediaId = mediaId;
            return this;
        }

        public User build() {
            return new UserBusinessObject(this);
        }
    }
}
